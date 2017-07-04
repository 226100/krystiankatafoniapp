package net.azurewebsites.krystiankatafoniapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import net.azurewebsites.krystiankatafoniapp.model.Category;
import net.azurewebsites.krystiankatafoniapp.util.ConnectionProvider;
import net.azurewebsites.krystiankatafoniapp.wrapper.CategoryOccWrapper;

public class CategoryDAOImpl implements CategoryDAO {
	private static final String CREATE_CATEGORY = "INSERT INTO category(category_name,user_id) VALUES(:categoryname,:userId);";
	private static final String READ_CATEGORY = "SELECT category_id, category_name, user_id FROM category WHERE category_id=:category_id;";
	private static final String UPDATE_CATEGORY = "UPDATE category SET category_name=:categoryname, user_id=:user_id WHERE category_id=:category_id;";
	private static final String DELETE_CATEGORY = "DELETE FROM category WHERE category_id=:categoryId ";
	private static final String READ_ALL_CATEGORIES = "SELECT category_id, category_name, user_id FROM category WHERE user_id=:user_id;";
	private static final String CATEGORY_IS_USED = "SELECT COUNT(category_id) FROM purchase WHERE category_id=:category_id";
	private static final String AMOUNT_OF_ALL_CATEGORIES = "SELECT COUNT(category_id) FROM category WHERE user_id=:user_id";
	private static final String READ_ALL_CATEGORIES_FROM_PURCHASES = "SELECT user.user_id, category.category_id, category_name FROM purchase LEFT JOIN category ON purchase.category_id=category.category_id LEFT JOIN user ON purchase.user_id=user.user_id WHERE purchase.user_id=:user_id;";
	NamedParameterJdbcTemplate template;

	public CategoryDAOImpl() {
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}
	/* CRUD */
	@Override
	public Category create(Category category) {
		Category resultCategory = new Category(category);
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(category);
		int update = template.update(CREATE_CATEGORY, paramSource, holder);
		if (update > 0) {
			resultCategory.setId((Long) holder.getKey());
		}
		return resultCategory;
	}

	@Override
	public Category read(Long primaryKey) {
		Category resultCategory = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("category_id", primaryKey);
		resultCategory = template.queryForObject(READ_CATEGORY, paramSource, new CategoryRowMapper());
		return resultCategory;
	}

	@Override
	public boolean update(Category updateObject) {

		Category categoryCopy = updateObject;
		boolean result = false;
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("category_id", categoryCopy.getId());
		paramMap.put("categoryname", categoryCopy.getCategoryname());
		paramMap.put("user_id", categoryCopy.getUserId());
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int update = template.update(UPDATE_CATEGORY, paramSource);
		if (update > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean delete(Long key) {

		boolean result = false;
		SqlParameterSource paramSource = new MapSqlParameterSource("categoryId", key);
		if (!categoryIsUsed(key)) {
			int update = template.update(DELETE_CATEGORY, paramSource);
			if (update > 0) {
				result = true;
			}
		}
		return result;
	}
	/*Get list of all categories added by user */
	@Override
	public List<Category> getAll(Long userId) {
		List<Category> resultList = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("user_id", userId);
		resultList = template.query(READ_ALL_CATEGORIES, paramSource, new CategoryRowMapper());
		return resultList;
	}
	/** Get amount of all categories added by user
	 * @param userId This is id of user which is current logged in
	 * @return This is integer value, which told how many categories were added by user 
	 * */
	@Override
	public int amountOfAllCategories(Long userId) {
		Integer result = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("user_id", userId);
		Number number = template.queryForObject(AMOUNT_OF_ALL_CATEGORIES, paramSource, Integer.class);
		if (number == null) {
			result = 0;
		} else {
			result = number.intValue();
		}
		return result;

	}

	public boolean categoryIsUsed(long key) {
		boolean result = true;
		SqlParameterSource paramSource = new MapSqlParameterSource("category_id", key);
		Number number = template.queryForObject(CATEGORY_IS_USED, paramSource, Integer.class);
		if (number.intValue() > 0) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	public List<Category> getAllCategoriesFromPurchases(long userId) {
		List<Category> resultList = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("user_id", userId);
		resultList = template.query(READ_ALL_CATEGORIES_FROM_PURCHASES, paramSource, new CategoryRowMapper());
		return resultList;
	}

	@Override
	public List<CategoryOccWrapper> getWrappedCategories(long userId) {
		List<Category> categoryList = new ArrayList<>();
		List<CategoryOccWrapper> occList = new ArrayList<>();
		categoryList = getAllCategoriesFromPurchases(userId);
		List<Category> copyList = new ArrayList<>(categoryList);
		categoryList.stream().forEach(categoryItem -> {
			int freq = Collections.frequency(copyList, categoryItem);
			CategoryOccWrapper wrapper = new CategoryOccWrapper(categoryItem, freq);
			if (!occList.contains(wrapper)) {
				occList.add(wrapper);
			}
		});
		return occList;
	}

	private class CategoryRowMapper implements RowMapper<Category> {
		@Override
		public Category mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Category category = new Category();
			category.setId(resultSet.getLong("category_id"));
			category.setCategoryname(resultSet.getString("category_name"));
			category.setUserId(resultSet.getLong("user_id"));
			return category;
		}
	}

}

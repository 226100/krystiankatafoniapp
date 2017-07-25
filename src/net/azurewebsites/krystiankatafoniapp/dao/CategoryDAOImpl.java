package net.azurewebsites.krystiankatafoniapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
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
/**
 * Implementation of CategoryDAO interface
 * This class allow to get access to data in database,
 * to use CRUD methods and other methodds
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-08
 */
public class CategoryDAOImpl implements CategoryDAO {
	/* All queries to database*/
	private static final String CREATE_CATEGORY = "INSERT INTO category(category_name,user_id) VALUES(:categoryname,:userId);";
	private static final String READ_CATEGORY = "SELECT category_id, category_name, user_id FROM category WHERE category_id=:category_id;";
	private static final String UPDATE_CATEGORY = "UPDATE category SET category_name=:categoryname, user_id=:user_id WHERE category_id=:category_id;";
	private static final String DELETE_CATEGORY = "DELETE FROM category WHERE category_id=:categoryId ";
	private static final String READ_ALL_CATEGORIES = "SELECT category_id, category_name, user_id FROM category WHERE user_id=:user_id;";
	private static final String CATEGORY_IS_USED = "SELECT COUNT(category_id) FROM purchase WHERE category_id=:category_id";
	private static final String AMOUNT_OF_ALL_CATEGORIES = "SELECT COUNT(category_id) FROM category WHERE user_id=:user_id";
	private static final String READ_ALL_CATEGORIES_FROM_PURCHASES = "SELECT user.user_id, category.category_id, category_name FROM purchase LEFT JOIN category ON purchase.category_id=category.category_id LEFT JOIN user ON purchase.user_id=user.user_id WHERE purchase.user_id=:user_id;";
	/* Object SpringJDBC framework of class
	 * NamedParameterJdbcTemplate, this object allow to
	 * execute query in database
	 */
	NamedParameterJdbcTemplate template;

	public CategoryDAOImpl() {
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}
	/* CRUD */

	@Override
	public Category create(Category category) throws NullPointerException {
		if(category==null){
			throw new NullPointerException();
		}
		Category resultCategory=null;
			resultCategory = new Category(category);
			KeyHolder holder = new GeneratedKeyHolder();
			SqlParameterSource paramSource = new BeanPropertySqlParameterSource(category);
			int update = template.update(CREATE_CATEGORY, paramSource, holder);
			if (update > 0) {
				resultCategory.setId((Long) holder.getKey());
			}
		
		return resultCategory;
	}
	
	@Override
	public Category read(Long key) throws NullPointerException {
		if(key==null){
			throw new NullPointerException();
		}
		Category resultCategory = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("category_id", key);
		resultCategory = template.queryForObject(READ_CATEGORY, paramSource, new CategoryRowMapper());
		return resultCategory;
	}
	
	@Override
	public boolean update(Category updateObject) throws NullPointerException {
		if(updateObject==null){
			throw new NullPointerException();
		}
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
	public boolean delete(Long key) throws NullPointerException {
		if(key==null){
			throw new NullPointerException();
		}
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
	
	@Override
	public List<Category> getAll(Long userId) throws NullPointerException {
		if(userId==null){
			throw new NullPointerException();
		}
		List<Category> resultList = new LinkedList<>();
		SqlParameterSource paramSource = new MapSqlParameterSource("user_id", userId);
		resultList = template.query(READ_ALL_CATEGORIES, paramSource, new CategoryRowMapper());
		return resultList;
	}

	@Override
	public int amountOfAllCategories(Long userId) throws NullPointerException {
		if(userId==null){
			throw new NullPointerException();
		}
		int result = 0;
		SqlParameterSource paramSource = new MapSqlParameterSource("user_id", userId);
		Number number = template.queryForObject(AMOUNT_OF_ALL_CATEGORIES, paramSource, Integer.class);
		result = number.intValue();
		return result;
	}

	/** getAllCategoriesFromPurchases(Long userId) - get amount of all categories added by user to purchases
	 * @param userId This is id of user which is current logged in
	 * @return resultList - this is a list of all categories which are used in any purchases for logged user
	 * @throws NullPointerException
	 * */
	private List<Category> getAllCategoriesFromPurchases(Long userId) throws NullPointerException {
		if(userId==null){
			throw new NullPointerException();
		}
		List<Category> resultList = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("user_id", userId);
		resultList = template.query(READ_ALL_CATEGORIES_FROM_PURCHASES, paramSource, new CategoryRowMapper());
		return resultList;
	}
	


	@Override
	public List<CategoryOccWrapper> getWrappedCategories(Long userId) throws NullPointerException{
		if(userId==null){
			throw new NullPointerException();
		}
		List<Category> categoryList = new ArrayList<>();
		List<CategoryOccWrapper> wrappedCategoryList = new ArrayList<>();
		categoryList = getAllCategoriesFromPurchases(userId);
		List<Category> copyList = new ArrayList<>(categoryList);
		categoryList.stream().forEach(categoryItem -> {
			int freq = Collections.frequency(copyList, categoryItem);
			CategoryOccWrapper wrapper = new CategoryOccWrapper(categoryItem, freq);
			if (!wrappedCategoryList.contains(wrapper)) {
				wrappedCategoryList.add(wrapper);
			}
		});
		return wrappedCategoryList;
	}
	/** categoryIsUsed(long key) is a method, which told if category with id
	 * like input key is used in any purchase
	 * this method help to decide if delete category or not,
	 * if category is used in any purchase will be not deleted
	 * @param key - id of category
	 * @return result - true - category is used in any purchase
	 *                - false category is not used
	 * @throws NullPointerException
	 * */

	private boolean categoryIsUsed(Long key) throws NullPointerException {
		if(key==null){
			throw new NullPointerException();
		}
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

	/**
	 * Class which map variables of category object
	 * @author Kutti
	 *
	 */
	private class CategoryRowMapper implements RowMapper<Category> {
		@Override
		public Category mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Long categoryId = resultSet.getLong("category_id");
			String categoryname = resultSet.getString("category_name");
			Long userId = resultSet.getLong("user_id");
			/**
			 * Exception
			 */
			if(categoryId==null|categoryname==null|userId==null){
				throw new SQLException("Parameter is not present in DB");
			}
			Category category = new Category();
			category.setId(categoryId);
			category.setCategoryname(categoryname);
			category.setUserId(userId);
			return category;
		}
	}

}

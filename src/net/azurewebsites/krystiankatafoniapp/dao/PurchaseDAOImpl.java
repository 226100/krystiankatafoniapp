package net.azurewebsites.krystiankatafoniapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import net.azurewebsites.krystiankatafoniapp.model.Category;
import net.azurewebsites.krystiankatafoniapp.model.Purchase;
import net.azurewebsites.krystiankatafoniapp.model.Shop;
import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.util.ConnectionProvider;

public class PurchaseDAOImpl implements PurchaseDAO {

	private static final String CREATE_PURCHASE = "INSERT INTO purchase(purchase_name,user_id, category_id, shop_id, price) VALUES(:purchase_name,:user_id,:category_id,:shop_id,:price);";
	private static final String READ_PURCHASE = "SELECT purchase_id, purchase_name, user_id FROM category WHERE purchase_id=:purchase_id;";
	private static final String UPDATE_PURCHASE = "UPDATE purchase SET purchase_name=:purchasename, category_id=:category_id, shop_id=:shop_id, price=:price, user_id=:user_id WHERE purchase_id=:purchase_id;";
	private static final String DELETE_PURCHASE = "DELETE FROM purchase WHERE purchase_id=:purchaseId ";
	private static final String READ_ALL_PURCHASES = "SELECT user.user_id, username, email, password, is_active,category.category_id, category_name, shop.shop_id, shop_name, purchase_id, purchase_name, price, date FROM purchase LEFT JOIN category ON purchase.category_id=category.category_id LEFT JOIN shop ON purchase.shop_id=shop.shop_id LEFT JOIN user ON purchase.user_id=user.user_id WHERE purchase.user_id=:user_id ORDER BY purchase.purchase_name;";
	private static final String AMOUNT_OF_ALL_PURCHASES = "SELECT COUNT(purchase_id) FROM purchase WHERE user_id=:user_id";
	private static final String SUM_OF_PRICES = "SELECT SUM(price) FROM purchase WHERE user_id=:user_id";
	NamedParameterJdbcTemplate template;
	

	public PurchaseDAOImpl() {
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}

	@Override
	public Purchase create(Purchase purchase) {
		Purchase resultPurchase = new Purchase(purchase);
		KeyHolder holder = new GeneratedKeyHolder();
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("purchase_name", purchase.getPurchasename());
		paramMap.put("user_id", purchase.getUser().getId());
		paramMap.put("category_id", purchase.getCategory().getId());
		paramMap.put("shop_id", purchase.getShop().getId());
		paramMap.put("price", purchase.getPrice());

		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int update = template.update(CREATE_PURCHASE, paramSource, holder);
		if (update > 0) {
			resultPurchase.setId((Long) holder.getKey());
		}
		return resultPurchase;
	}

	@Override
	public Purchase read(Long primaryKey) {
		Purchase resultPurchase = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("purchase_id", primaryKey);
		resultPurchase = template.queryForObject(READ_PURCHASE, paramSource, new PurchaseRowMapper());
		return resultPurchase;
	}

	@Override
	public boolean update(Purchase updateObject) {

		Purchase purchaseCopy = updateObject;
		boolean result = false;
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("purchase_id", purchaseCopy.getId());
		paramMap.put("purchasename", purchaseCopy.getPurchasename());
		paramMap.put("category_id", purchaseCopy.getCategory().getId());
		paramMap.put("shop_id", purchaseCopy.getShop().getId());
		paramMap.put("price", purchaseCopy.getPrice());
		paramMap.put("user_id", purchaseCopy.getUser().getId());
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int update = template.update(UPDATE_PURCHASE, paramSource);
		if (update > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean delete(Long key) {

		boolean result = false;
		SqlParameterSource paramSource = new MapSqlParameterSource("purchaseId", key);
		int update = template.update(DELETE_PURCHASE, paramSource);
		if (update > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public List<Purchase> getAll(Long userId) {
		List<Purchase> resultList = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("user_id", userId);
		resultList = template.query(READ_ALL_PURCHASES, paramSource, new PurchaseRowMapper());
		return resultList;
	}
	@Override
	public Integer amountOfAllPurchases(Long userId){
		Integer result = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("user_id", userId);
		Number number = template.queryForObject(AMOUNT_OF_ALL_PURCHASES,paramSource,Integer.class);
		if(number==null){
			result=0;
		}else{
			result=number.intValue();
		}
		return result;
		
	}

	private class PurchaseRowMapper implements RowMapper<Purchase> {
		@Override
		public Purchase mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Purchase purchase = new Purchase();
			User user = new User();
			Category category = new Category();
			Shop shop = new Shop();
			user.setId(resultSet.getLong("user_id"));
			user.setUsername(resultSet.getString("username"));
			user.setEmail(resultSet.getString("email"));
			user.setPassword(resultSet.getString("password"));
			user.setActive(resultSet.getBoolean("is_active"));
			category.setId(resultSet.getLong("category_id"));
			category.setCategoryname(resultSet.getString("category_name"));
			category.setUserId(resultSet.getLong("user_id"));
			shop.setId(resultSet.getLong("shop_id"));
			shop.setShopname(resultSet.getString("shop_name"));
			shop.setUserId(resultSet.getLong("user_id"));
			purchase.setId(resultSet.getLong("purchase_id"));
			purchase.setPurchasename(resultSet.getString("purchase_name"));
			purchase.setUser(user);
			purchase.setCategory(category);
			purchase.setShop(shop);
			purchase.setPrice(resultSet.getFloat("price"));
			purchase.setTimestamp(resultSet.getTimestamp("date"));
			return purchase;
		}
	}

	@Override
	public Float sumOfPrices(Long userId) {
		Float result = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("user_id", userId);
		Number number = template.queryForObject(SUM_OF_PRICES,paramSource,Float.class);
		if(number==null){
			result=0.0F;
		}else{
			result=number.floatValue();
		}
		return result;
		
	}

}

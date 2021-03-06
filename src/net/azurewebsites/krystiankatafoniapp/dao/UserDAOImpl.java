package net.azurewebsites.krystiankatafoniapp.dao;

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.util.ConnectionProvider;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class UserDAOImpl implements UserDAO {
	/* All queries to database */
	private static final String CREATE_USER = "INSERT INTO user(username, email, password, is_active) "
			+ "VALUES (:username, :email, :password, :active);";
	private static final String READ_USER = "SELECT user_id, username, email, password, is_active FROM user WHERE user_id=:id";
	private static final String READ_USER_BY_USERNAME = "SELECT user_id, username, email, password, is_active FROM user WHERE username=:username";
	private static final String USER_EXIST = "SELECT COUNT(username) FROM user WHERE username=:username";
	
	/*
	 * Object SpringJDBC framework of class NamedParameterJdbcTemplate, this
	 * object allow to execute query in database
	 */
	private NamedParameterJdbcTemplate template;
	
	public UserDAOImpl(){
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}
	@Override
	public User create(User user) {
		User resultUser = new User(user);
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		int update = template.update(CREATE_USER, paramSource, holder);
		if(update>0){
			resultUser.setId((Long)holder.getKey());
			setPrivigiles(resultUser);
		}
		return resultUser;
	}
	private void setPrivigiles(User user){
		final String userRoleQuery = "INSERT INTO user_role(username) VALUES(:username)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		template.update(userRoleQuery, paramSource);
	}
	@Override
	public User read(Long primaryKey) {
		User resultUser = null;
		SqlParameterSource paramSource =  new MapSqlParameterSource("id", primaryKey);
		resultUser=template.queryForObject(READ_USER, paramSource,new UserRowMapper());
		return resultUser;
	}
	
	@Override
	public boolean update(User updateObject) {

		return false;
	}

	@Override
	public boolean delete(Long key) {

		return false;
	}

	@Override
	public List<User> getAll(Long userId) {

		return null;
	}

	@Override
	public User getUserByUsername(String username)  {
		User resultUser = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		resultUser=template.queryForObject(READ_USER_BY_USERNAME, paramSource, new UserRowMapper());
		return resultUser;
	}
	@Override
	public boolean isUserExist(String username) {
		boolean result=true;
		SqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		Number number = template.queryForObject(USER_EXIST,paramSource,Integer.class);
		if(number.intValue()>0){
			result = true;
		}else{result=false;}
		return result;
	}
	
	private class UserRowMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Long userId = resultSet.getLong("user_id");
			String username=resultSet.getString("username");
			String email=resultSet.getString("email");
			String password=resultSet.getString("password");
			boolean isActive=resultSet.getBoolean("is_active");

			/**
			 * Exception
			 */
			if (userId == null | username == null | email == null|password==null) {
				throw new SQLException("Parameter is not present in DB");
			}
			User user = new User();
			user.setId(userId);
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password);
			user.setActive(isActive);
			return user;
		}
		
	}
}

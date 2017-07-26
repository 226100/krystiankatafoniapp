package net.azurewebsites.krystiankatafoniapp.dao;

import java.util.List;

import net.azurewebsites.krystiankatafoniapp.model.User;
/**
 * Interface for UserDAOImpl
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-04
 */
public interface UserDAO extends GenericDAO<User,Long> {
	List<User> getAll(Long userId);
	
	/**
	 * This method get user object from database
	 * on the basis of input argument - object user
	 * @param user - name of user
	 * @return object of user from database
	 */
	User getUserByUsername(String username);
	/**
	 * This method check if user exist in db
	 * @param username 
	 * @return result of operation
	 *         true - user exist
	 *         false - user  don't exist
	 */
	boolean isUserExist(String username);
}

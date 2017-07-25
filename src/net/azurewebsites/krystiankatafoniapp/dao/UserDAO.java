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
	User getUserByUsername(String user);
	boolean isUserExist(String username);
}

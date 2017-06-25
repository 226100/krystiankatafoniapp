package net.azurewebsites.krystiankatafoniapp.dao;

import java.util.List;

import net.azurewebsites.krystiankatafoniapp.model.User;

public interface UserDAO extends GenericDAO<User,Long> {
	List<User> getAll(Long userId);
	User getUserByUsername(String user);
}

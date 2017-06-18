package net.azurewebsites.krystiankatafoniapp.service;

import net.azurewebsites.krystiankatafoniapp.dao.DAOFactory;
import net.azurewebsites.krystiankatafoniapp.dao.UserDAO;
import net.azurewebsites.krystiankatafoniapp.model.User;

public class UserService {
	public void addUser(String username, String email, String password){
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setActive(true);
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		userDao.create(user);
	}
}

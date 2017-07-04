package net.azurewebsites.krystiankatafoniapp.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import net.azurewebsites.krystiankatafoniapp.dao.DAOFactory;
import net.azurewebsites.krystiankatafoniapp.dao.UserDAO;
import net.azurewebsites.krystiankatafoniapp.model.User;

public class UserService {
	public boolean addUser(String username, String email, String password){
		boolean result = false;
		User user = user= new User();
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		if(!userDao.isUserExist(username)){
			
			user.setUsername(username);
			String md5Pass=encryptPassword(password);
			user.setEmail(email);
			user.setPassword(md5Pass);
			user.setActive(true);
			userDao.create(user);
			result=true;
		}
		return result;
	}
	private String encryptPassword(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        digest.update(password.getBytes());
        String md5Password = new BigInteger(1, digest.digest()).toString(16);
        return md5Password;
    }
	public User getUserById(long id){
		User resultUser = null;
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		resultUser = userDao.read(id);
		return resultUser;
	}
	public User getUserByUsername(String username){
		User resultUser = null;
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		resultUser = userDao.getUserByUsername(username);
		return resultUser;
		
	}
}

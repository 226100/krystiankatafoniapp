package net.azurewebsites.krystiankatafoniapp.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import net.azurewebsites.krystiankatafoniapp.dao.DAOFactory;
import net.azurewebsites.krystiankatafoniapp.dao.UserDAO;
import net.azurewebsites.krystiankatafoniapp.model.User;
/**
 * UserService class is a class, which is a service layer for User.
 * Service layer is taken factory from DAOFactory
 * and in next step implement business logic to execute CRUD method
 * or other method needed for controller
 * UserService is called in controller.
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-20
 */

public class UserService {
	/**
	 * addUser method use input arguments to
	 * create new User object and than
	 * through userDao object create new user
	 * @param username - username as String
	 * @param email - email as String
	 * @param password - password as String
	 * @return result - result of adding user
	 * 		   true- user added
	 *         false- user not added
	 */
	public boolean addUser(String username, String email, String password){
		boolean result = false;
		if(username!=null&&email!=null&&password!=null){
			User user = new User();
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				UserDAO userDao = factory.getUserDAO();
				if(!userDao.isUserExist(username)){
					user.setUsername(username);
					String md5Pass=encryptPassword(password);
					user.setEmail(email);
					user.setPassword(md5Pass);
					user.setActive(true);
					User resultUser=userDao.create(user);
					if(resultUser.getId()!=null)
						result=true;
				}
			}
		}
		return result;
	}
	/**
	 * encryptPassword method use class MessageDigest to create password
	 * encrypted by MD5 algorithm, and in this form is sended to database
	 * @param password - input password as String
	 * @return md5Password - user password encrypted by md5 algorithm
	 */
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
	/**
	 * getUserById method use input id and send through userDao query
	 * for data of user with input id
	 * @param id - id of user
	 * @return resultUser - user which is querying in database
	 */
	public User getUserById(Long id){
		User resultUser = new User();
		DAOFactory factory = DAOFactory.getDAOFactory();
		if(factory!=null){
			UserDAO userDao = factory.getUserDAO();
			resultUser = userDao.read(id);
		}
		return resultUser;
	}
	/**
	 * getUserByUsername method use input username and send through userDao query
	 * for data of user with input username
	 * @param username - username of user
	 * @return resultUSer - user which is querying in database
	 */
	public User getUserByUsername(String username){
		User resultUser = new User();
		if(username!=null){
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				UserDAO userDao = factory.getUserDAO();
				resultUser = userDao.getUserByUsername(username);
			}
		}
		return resultUser;	
	}
}

package net.azurewebsites.krystiankatafoniapp.dao;

import net.azurewebsites.krystiankatafoniapp.exception.NoSuchDbTypeException;
/**
 *DAOFactory is abstract class which provide
 * access to CategoryDAO, ShopDAO, UserDAO, PurchaseDAO
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-04
 */
public abstract class DAOFactory {
	public abstract UserDAO getUserDAO();
	public abstract ShopDAO getShopDAO();
	public abstract CategoryDAO getCategoryDAO();
	public abstract PurchaseDAO getPurchaseDAO();
	public static final int MYSQL_DAO_FACTORY = 1;
	/**
	 * getDAOFactory() return factory object
	 * @return factory - object of type MysqlDAOFactory, reference is a type DAOFactory
	 *         This object allow to get access to DAO classes
	 */
	public static DAOFactory getDAOFactory(){
		DAOFactory factory = null;
		try{
			factory = getDAOFactory(MYSQL_DAO_FACTORY);
		}catch(NoSuchDbTypeException e){
			e.printStackTrace();
		}
		return factory;
	}
	/**
	 * getDAOFactory(int type) return MysqlDAOFactory,
	 * in other cases(int type) throw NoSuchDbTypeException
	 * this method is private and is used in getDAOFactory() method
	 * @return new MysqlDAOFactory() new object
	 */
	private static DAOFactory getDAOFactory(int type) throws NoSuchDbTypeException{
		switch(type){
		case MYSQL_DAO_FACTORY:
			return new MysqlDAOFactory();
		default: 
			throw new NoSuchDbTypeException();
		}
	}
}

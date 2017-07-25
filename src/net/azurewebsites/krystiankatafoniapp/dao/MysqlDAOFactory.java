package net.azurewebsites.krystiankatafoniapp.dao;
/**
 * Class which has 4 methods
 * to get acess to DAO classes
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-04
 */
public class MysqlDAOFactory extends DAOFactory {
	
	@Override
	public UserDAO getUserDAO() {
		return new UserDAOImpl();
	}

	@Override
	public ShopDAO getShopDAO() {
		return new ShopDAOImpl();
	}

	@Override
	public CategoryDAO getCategoryDAO() {
		return new CategoryDAOImpl();
	}

	@Override
	public PurchaseDAO getPurchaseDAO() {
		return new PurchaseDAOImpl();
	}
	
	
}

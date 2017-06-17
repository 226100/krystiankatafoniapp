package net.azurewebsites.krystiankatafoniapp.dao;

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

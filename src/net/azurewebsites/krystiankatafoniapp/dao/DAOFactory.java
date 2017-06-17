package net.azurewebsites.krystiankatafoniapp.dao;

public abstract class DAOFactory {
	public abstract UserDAO getUserDAO();
	public abstract ShopDAO getShopDAO();
	public abstract CategoryDAO getCategoryDAO();
	public abstract PurchaseDAO getPurchaseDAO();
}

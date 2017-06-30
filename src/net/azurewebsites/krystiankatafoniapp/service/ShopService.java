package net.azurewebsites.krystiankatafoniapp.service;

import java.util.List;

import net.azurewebsites.krystiankatafoniapp.dao.ShopDAO;
import net.azurewebsites.krystiankatafoniapp.dao.DAOFactory;
import net.azurewebsites.krystiankatafoniapp.model.Shop;
import net.azurewebsites.krystiankatafoniapp.model.User;

public class ShopService {
	public void addShop(String shopname, User user){
		User userCopy = new User(user);
		Shop shop = new Shop();
		shop.setShopname(shopname);
		shop.setUserId(userCopy.getId());
		DAOFactory factory = DAOFactory.getDAOFactory();
		ShopDAO shopDao = factory.getShopDAO();
		shopDao.create(shop);
	}
	public List<Shop> getAll(User user){
		List<Shop> shopList = null;
		User userCopy = new User(user);
		DAOFactory factory = DAOFactory.getDAOFactory();
		ShopDAO shopDao=factory.getShopDAO();
		shopList=shopDao.getAll(userCopy.getId());
		return shopList;
	}
	public boolean deleteShop(Long shopId){
		boolean result = false;
		DAOFactory factory = DAOFactory.getDAOFactory();
		ShopDAO shopDao=factory.getShopDAO();
		result=shopDao.delete(shopId);
		return result;
		
	}
	public boolean updateShop(Shop shop){
		boolean result = false;
		Shop shopCopy = new Shop(shop);
		DAOFactory factory = DAOFactory.getDAOFactory();
		ShopDAO shopDao = factory.getShopDAO();
		result=shopDao.update(shopCopy);
		return result;
		
	}
}

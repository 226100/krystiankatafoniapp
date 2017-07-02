package net.azurewebsites.krystiankatafoniapp.service;

import java.util.List;

import net.azurewebsites.krystiankatafoniapp.dao.CategoryDAO;
import net.azurewebsites.krystiankatafoniapp.dao.DAOFactory;
import net.azurewebsites.krystiankatafoniapp.dao.PurchaseDAO;
import net.azurewebsites.krystiankatafoniapp.dao.ShopDAO;
import net.azurewebsites.krystiankatafoniapp.model.Category;
import net.azurewebsites.krystiankatafoniapp.model.Purchase;
import net.azurewebsites.krystiankatafoniapp.model.Shop;
import net.azurewebsites.krystiankatafoniapp.model.User;

public class PurchaseService {
	public void addPurchase(String purchasename,String categoryname, String shopname,float price, User user){
		User userCopy = new User(user);
		Purchase purchase = new Purchase();
		DAOFactory factory = DAOFactory.getDAOFactory();
		CategoryDAO categoryDao = factory.getCategoryDAO();
		ShopDAO shopDao = factory.getShopDAO();
		List<Category> categoryList = categoryDao.getAll(userCopy.getId());
		List<Shop> shopList = shopDao.getAll(userCopy.getId());	
		for(Category c:categoryList){
			if(c.getCategoryname().equals(categoryname)){
				purchase.setCategory(c);
			}
		}
		for(Shop s:shopList){
			if(s.getShopname().equals(shopname)){
				purchase.setShop(s);
			}
		}
		purchase.setUser(user);
		purchase.setPurchasename(purchasename);
		purchase.setPrice(price);
		
		PurchaseDAO purchaseDao = factory.getPurchaseDAO();
		purchaseDao.create(purchase);
	}
	public List<Purchase> getAll(User user){
		List<Purchase> purchaseList = null;
		User userCopy = new User(user);
		DAOFactory factory = DAOFactory.getDAOFactory();
		PurchaseDAO purchaseDao=factory.getPurchaseDAO();
		purchaseList=purchaseDao.getAll(userCopy.getId());
		return purchaseList;
	}
	public boolean deletePurchase(Long purchaseId){
		boolean result = false;
		DAOFactory factory = DAOFactory.getDAOFactory();
		PurchaseDAO purchaseDao=factory.getPurchaseDAO();
		result=purchaseDao.delete(purchaseId);
		return result;
		
	}
	public boolean updatePurchase(long id, String purchasename, String categoryname, String shopname, float price, User user){
		boolean result = false;
		User userCopy = new User(user);
		Purchase purchase = new Purchase();
		DAOFactory factory = DAOFactory.getDAOFactory();
		CategoryDAO categoryDao = factory.getCategoryDAO();
		ShopDAO shopDao = factory.getShopDAO();
		List<Category> categoryList = categoryDao.getAll(userCopy.getId());
		List<Shop> shopList = shopDao.getAll(userCopy.getId());	
		for(Category c:categoryList){
			if(c.getCategoryname().equals(categoryname)){
				purchase.setCategory(c);
			}
		}
		for(Shop s:shopList){
			if(s.getShopname().equals(shopname)){
				purchase.setShop(s);
			}
		}
		purchase.setUser(user);
		purchase.setPurchasename(purchasename);
		purchase.setPrice(price);
		purchase.setId(id);
		
		PurchaseDAO purchaseDao = factory.getPurchaseDAO();
		
		result=purchaseDao.update(purchase);
		return result;
		
	}

}

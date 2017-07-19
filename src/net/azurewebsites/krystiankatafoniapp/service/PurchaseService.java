package net.azurewebsites.krystiankatafoniapp.service;

import java.util.LinkedList;
import java.util.List;

import net.azurewebsites.krystiankatafoniapp.dao.CategoryDAO;
import net.azurewebsites.krystiankatafoniapp.dao.DAOFactory;
import net.azurewebsites.krystiankatafoniapp.dao.PurchaseDAO;
import net.azurewebsites.krystiankatafoniapp.dao.ShopDAO;
import net.azurewebsites.krystiankatafoniapp.model.Category;
import net.azurewebsites.krystiankatafoniapp.model.Purchase;
import net.azurewebsites.krystiankatafoniapp.model.Shop;
import net.azurewebsites.krystiankatafoniapp.model.User;
/**
 * PurchaseService class is a class, which is a service layer for Purchase.
 * Service layer is taken factory from DAOFactory
 * and in next step implement business logic to execute CRUD method
 * or other method needed for controller
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-20
 */

public class PurchaseService {
	/**
	 * addPurchase method use input arguments and
	 * create new Purchase with help of PurchaseDAO object
	 * @param purchasename - name of purchase as String
	 * @param categoryname - name of category as String
	 * @param shopname - name of shop as String
	 * @param price - price of purchase as Float
	 * @param user - object of logged in user as type User
	 */ 
	public void addPurchase(String purchasename, String categoryname, String shopname, Float price, User user) {
		if((user!=null)&&(purchasename!=null)&&(categoryname!=null)&&(shopname!=null)&&(price!=null)){
			User userCopy = new User(user);
			Purchase purchase = new Purchase();
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				CategoryDAO categoryDao = factory.getCategoryDAO();
				ShopDAO shopDao = factory.getShopDAO();
				if(userCopy.getId()!=null){
					List<Category> categoryList = categoryDao.getAll(userCopy.getId());
					List<Shop> shopList = shopDao.getAll(userCopy.getId());
					for (Category c : categoryList) {
						if (c.getCategoryname().equals(categoryname)) {
							purchase.setCategory(c);
						}
					}
					for (Shop s : shopList) {
						if (s.getShopname().equals(shopname)) {
							purchase.setShop(s);
						}
					}
					purchase.setUser(user);
					purchase.setPurchasename(purchasename);
					purchase.setPrice(price);
					PurchaseDAO purchaseDao = factory.getPurchaseDAO();
					purchaseDao.create(purchase);
				}
			}
		}
	}
	/**
	 * getAll return list of all purchases
	 * for  user
	 * @param user - object of user current logged in as type User
	 * @return - list of purchases
	 */
	public List<Purchase> getAll(User user) {
		List<Purchase> purchaseList = new LinkedList<>();
		if(user!=null){
			User userCopy = new User(user);
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				PurchaseDAO purchaseDao = factory.getPurchaseDAO();
				if(userCopy.getId()!=null){
					purchaseList = purchaseDao.getAll(userCopy.getId());
				}
			}
		}
		return purchaseList;	
	}
	/**
	 * deletePurchase is deleting purchase for input purchaseId 
	 * send by controller
	 * @param purchaseId - id of purchase  as Long
	 * @return result- result of deleting
	 * 	       true - purchase deleted,
	 *         false - purchase not deleted
	 */
	public boolean deletePurchase(Long purchaseId) {
		boolean result = false;
		if(purchaseId!=null){
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				PurchaseDAO purchaseDao = factory.getPurchaseDAO();
				result = purchaseDao.delete(purchaseId);
			}
		}
		return result;

	}
	/**
	 * updatePurchase method update data of 
	 * one Purchase   
	 * @param id - id of purchase as Long
	 * @param purchasename - name of purchase as String
	 * @param categoryname - name of category as String
	 * @param shopname - name of shop as String
	 * @param price - price of one purchase as Float
	 * @param user - current logged in user as User
	 * @return result - result of updating
	 * 		   true- purchase updated
	 * 		   false - purchase not updated
	 */
	public boolean updatePurchase(Long id, String purchasename, String categoryname, String shopname, Float price,
			User user) {
		
		boolean result = false;
		if((user!=null)&&(id!=null)&&(purchasename!=null)&&(categoryname!=null)&&(shopname!=null)&&(price!=null)){
			User userCopy = new User(user);
			Purchase purchase = new Purchase();
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				CategoryDAO categoryDao = factory.getCategoryDAO();
				ShopDAO shopDao = factory.getShopDAO();
				if(userCopy.getId()!=null){
					List<Category> categoryList = categoryDao.getAll(userCopy.getId());
					List<Shop> shopList = shopDao.getAll(userCopy.getId());
					for (Category c : categoryList) {
						if (c.getCategoryname().equals(categoryname)) {
							purchase.setCategory(c);
						}
					}
					for (Shop s : shopList) {
						if (s.getShopname().equals(shopname)) {
							purchase.setShop(s);
						}
					}
					purchase.setUser(user);
					purchase.setPurchasename(purchasename);
					purchase.setPrice(price);
					purchase.setId(id);
					PurchaseDAO purchaseDao = factory.getPurchaseDAO();
					result = purchaseDao.update(purchase);
				}
			}
		}
		return result;
	}
	/**
	 * amountOfAllPurchases is a method 
	 * which return amount(as int) all user purchases 
	 * @param user - user current log in as type User
	 * @return result - amount of all purchases as Integer
	 */
	public Integer amountOfAllPurchases(User user) {
		Integer result= new Integer(0);
		if(user!=null){
			User userCopy = new User(user);
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				PurchaseDAO purchaseDao = factory.getPurchaseDAO();
				if(userCopy.getId()!=null){
					result=purchaseDao.amountOfAllPurchases(userCopy.getId());
				}
			}
		}
		return result;
	}
	/**
	 * sumPrices method is a method which return 
	 * for user sum of prices of all user purchases
	 * @param user - user current log in as type User
	 * @return result - result(sum of prices) as Float
	 */
	public Float sumOfPrices(User user) {
		Float result = new Float(0.0f);
		if(user!=null){
			User userCopy = new User(user);
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				PurchaseDAO purchaseDao = factory.getPurchaseDAO();
				if(userCopy.getId()!=null){
					result = purchaseDao.sumOfPrices(userCopy.getId());
				}
			}
		}
		return result;
	}
}

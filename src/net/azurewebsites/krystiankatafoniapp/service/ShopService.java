package net.azurewebsites.krystiankatafoniapp.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

import net.azurewebsites.krystiankatafoniapp.dao.ShopDAO;
import net.azurewebsites.krystiankatafoniapp.dao.DAOFactory;
import net.azurewebsites.krystiankatafoniapp.model.Shop;
import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.wrapper.ShopOccWrapper;
/**
 * ShopService class is a class, which is a service layer for Shop.
 * Service layer is taken factory from DAOFactory
 * and in next step implement business logic to execute CRUD method
 * or other method needed for controller
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-20
 */
 
public class ShopService {
	/**
	 * addShop method use input arguments and
	 * create new Purchase with help of PurchaseDAO object
	 * @param shopname - name of shop as String
	 * @param user - object of logged in user as type User
	 */ 
	public void addShop(String shopname, User user){
		if(shopname!=null&&user!=null){
			User userCopy = new User(user);
			Shop shop = new Shop();
			shop.setShopname(shopname);
			if(userCopy.getId()!=null){
				shop.setUserId(userCopy.getId());
				DAOFactory factory = DAOFactory.getDAOFactory();
				if(factory!=null){
					ShopDAO shopDao = factory.getShopDAO();
					shopDao.create(shop);
				}
			}
		}
	}
	/**
	 * getAll method is a method, which main purpose
	 * is to return list of all shops( for user sent
	 * by controller) from database
	 * @param user - user object send by controller
	 * @return shopList - list of all shops from database 
	 */
	public List<Shop> getAll(User user){
		List<Shop> shopList = new LinkedList<>();
		if(user!=null){
			User userCopy = new User(user);		
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				ShopDAO shopDao=factory.getShopDAO();
				if(userCopy.getId()!=null){
					shopList=shopDao.getAll(userCopy.getId());
				}
			}
		}
		return shopList;
	}
	/**
	 * deleteShop method is a method, which 
	 * delete shop from database
	 * @param shopId - id of shop which has to be deleted
	 * @return result - result of deleting operation, 
	 *         true - shop deleted,
	 *         false - shop not deleted
	 */
	public boolean deleteShop(Long shopId){
		boolean result = false;
		if(shopId!=null){
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				ShopDAO shopDao=factory.getShopDAO();
				result=shopDao.delete(shopId);
			}
		}
		return result;
	}
	/**
	 * updateShop method is updating one shop
	 * in database
	 * @param shop - object of shop which has
	 * 		  to be updated in database
	 * @return result - result of updating operation, 
	 *         true -  shop updated,
	 *         false - shop not updated
	 */
	public boolean updateShop(Shop shop){
		boolean result = false;
		if(shop!=null){
			Shop shopCopy = new Shop(shop);
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				ShopDAO shopDao = factory.getShopDAO();
				result=shopDao.update(shopCopy);
			}
		}
		return result;
		
	}
	/**
	 * amountOfAllShops method get amount of all shops
	 * from database for user given as argument
	 * @param user - object of user, for this user is taken list of
	 *        all shops from db
	 * @return - value as int, amount of all shops
	 */
	public int amountOfAllShops(User user){
		int result =0;
		if(user!=null){
			User userCopy = new User(user);
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				ShopDAO shopDao = factory.getShopDAO();
				if(userCopy.getId()!=null){
					result=shopDao.amountOfAllShops(userCopy.getId());
				}
			}
		}
		return result;
	}
	/**
	 * getWrappedShopsWithPercent set percentage
	 * of one shop from set of all shops(number of used shop/number of all used shops)
	 * @param user- object of user
	 * @return shopWrapper - list of all Wrapper shops with setted percentage values
	 */
	public List<ShopOccWrapper> getWrappedShopsWithPercent(User user) throws ArithmeticException{
		List<ShopOccWrapper> shopWrapper = new LinkedList<>();
		if(user!=null){
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				ShopDAO shopDao = factory.getShopDAO();
				if(user.getId()!=null){
					shopWrapper =shopDao.getWrappedShops(user.getId());
					int numberOfAllShops=0;
					/*
					* Sum of all shops which occur in purchases
					*/
					for(ShopOccWrapper item:shopWrapper){
						numberOfAllShops=item.getOccNumber()+numberOfAllShops;
					}
					if(numberOfAllShops==0){
						throw new ArithmeticException("Number of all shops equals 0");
					}
					/*
					*For each item from shopWrapper list set
					* percent ratio of occurences one shop to occurences all shops in
					* purchase
					*/
					if(numberOfAllShops!=0){
						for(ShopOccWrapper shopItem:shopWrapper){
							float ratio=(float)shopItem.getOccNumber()/(float)numberOfAllShops;
							float percent = BigDecimal.valueOf(ratio*100)
									.setScale(2, RoundingMode.HALF_UP).floatValue();
							shopItem.setPercent(percent);
						};
					}
				}
			}
		}
		return shopWrapper;
	}
}

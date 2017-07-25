package net.azurewebsites.krystiankatafoniapp.dao;

import java.util.List;

import net.azurewebsites.krystiankatafoniapp.model.Purchase;
/**
 * Interface for PurchaseDAOImpl
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-04
 */
public interface PurchaseDAO extends GenericDAO<Purchase,Long> {
	List<Purchase> getAll(Long userId) throws NullPointerException;
	
	/**
	 * get amount of all purchases added by user
	 * @param userId -This is id of user which is current logged in
	 * @return This is integer value, which told how many purchases were added by user
	 */
	Integer amountOfAllPurchases(Long userId) throws NullPointerException;
	
	/**
	 * get sum of all prices for user
	 * @param userId -This is id of user which is current logged in
	 * @return sum of prices
	 */
	Float sumOfPrices(Long userId) throws NullPointerException;
}

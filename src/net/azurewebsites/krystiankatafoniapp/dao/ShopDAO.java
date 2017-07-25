package net.azurewebsites.krystiankatafoniapp.dao;

import java.util.List;
import net.azurewebsites.krystiankatafoniapp.model.Shop;
import net.azurewebsites.krystiankatafoniapp.wrapper.ShopOccWrapper;
/**
 * Interface for ShopDAOImpl
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-04
 */
public interface ShopDAO extends GenericDAO<Shop, Long>{
	List<Shop> getAll(Long userId);
	
	/**
	 * get amount of all shops added by user
	 * @param userId -This is id of user which is current logged in
	 * @return This is integer value, which told how many shops were added by user
	 */
	int amountOfAllShops(Long userId);
	
	/**
	 * get Wrapped Shops
	 * wrapp each shop from list of shops
	 * @param userId -This is id of user which is current logged in
	 * @return List with wrapped shops
	 */
	List<ShopOccWrapper> getWrappedShops(Long userId);
}

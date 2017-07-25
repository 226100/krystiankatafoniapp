package net.azurewebsites.krystiankatafoniapp.dao;

import java.util.List;

import net.azurewebsites.krystiankatafoniapp.model.Category;
import net.azurewebsites.krystiankatafoniapp.wrapper.CategoryOccWrapper;
import net.azurewebsites.krystiankatafoniapp.wrapper.ShopOccWrapper;
/**
 * Interface for CategoryDAOImpl
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-04
 */
public interface CategoryDAO extends GenericDAO<Category,Long> {
	
	List<Category> getAll(Long userId);
	
	/**
	 * get amount of all categories added by user
	 * @param userId -This is id of user which is current logged in
	 * @return This is integer value, which told how many categories were added by user
	 */
	int amountOfAllCategories(Long userId) throws NullPointerException;
	/**
	 * get Wrapped Categories
	 * wrapp each category from list of categories
	 * @param userId -This is id of user which is current logged in
	 * @return List with wrapped categories
	 */
	List<CategoryOccWrapper> getWrappedCategories(Long userId) throws NullPointerException;

}

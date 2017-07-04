package net.azurewebsites.krystiankatafoniapp.dao;

import java.util.List;

import net.azurewebsites.krystiankatafoniapp.model.Category;
import net.azurewebsites.krystiankatafoniapp.wrapper.CategoryOccWrapper;
import net.azurewebsites.krystiankatafoniapp.wrapper.ShopOccWrapper;

public interface CategoryDAO extends GenericDAO<Category,Long> {
	List<Category> getAll(Long userId);
	int amountOfAllCategories(Long userId);
	public List<CategoryOccWrapper> getWrappedCategories(long userId);

}

package net.azurewebsites.krystiankatafoniapp.dao;

import java.util.List;

import net.azurewebsites.krystiankatafoniapp.model.Category;

public interface CategoryDAO extends GenericDAO<Category,Long> {
	List<Category> getAll(Long userId);
	
}

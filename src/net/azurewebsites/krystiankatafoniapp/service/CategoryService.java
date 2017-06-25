package net.azurewebsites.krystiankatafoniapp.service;

import net.azurewebsites.krystiankatafoniapp.dao.CategoryDAO;
import net.azurewebsites.krystiankatafoniapp.dao.DAOFactory;
import net.azurewebsites.krystiankatafoniapp.model.Category;
import net.azurewebsites.krystiankatafoniapp.model.User;

public class CategoryService {
	public void addCategory(String categoryname, User user){
		User userCopy = new User(user);
		Category category = new Category();
		category.setCategoryname(categoryname);
		category.setUserId(userCopy.getId());
		DAOFactory factory = DAOFactory.getDAOFactory();
		CategoryDAO categoryDao = factory.getCategoryDAO();
		categoryDao.create(category);
	}
}

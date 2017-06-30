package net.azurewebsites.krystiankatafoniapp.service;

import java.util.List;

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
	public List<Category> getAll(User user){
		List<Category> categoryList = null;
		User userCopy = new User(user);
		DAOFactory factory = DAOFactory.getDAOFactory();
		CategoryDAO categoryDao=factory.getCategoryDAO();
		categoryList=categoryDao.getAll(userCopy.getId());
		return categoryList;
	}
	public boolean deleteCategory(Long categoryId){
		boolean result = false;
		DAOFactory factory = DAOFactory.getDAOFactory();
		CategoryDAO categoryDao=factory.getCategoryDAO();
		result=categoryDao.delete(categoryId);
		return result;
		
	}
	public boolean updateCategory(Category category){
		boolean result = false;
		Category categoryCopy = new Category(category);
		DAOFactory factory = DAOFactory.getDAOFactory();
		CategoryDAO categoryDao = factory.getCategoryDAO();
		result=categoryDao.update(categoryCopy);
		return result;
		
	}
}

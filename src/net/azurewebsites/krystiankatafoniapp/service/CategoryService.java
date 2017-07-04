package net.azurewebsites.krystiankatafoniapp.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import net.azurewebsites.krystiankatafoniapp.dao.CategoryDAO;
import net.azurewebsites.krystiankatafoniapp.dao.DAOFactory;
import net.azurewebsites.krystiankatafoniapp.dao.CategoryDAO;
import net.azurewebsites.krystiankatafoniapp.model.Category;
import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.wrapper.CategoryOccWrapper;

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
	public int amountOfAllCategories(Long userId){
		DAOFactory factory = DAOFactory.getDAOFactory();
		CategoryDAO categoryDao = factory.getCategoryDAO();
		return categoryDao.amountOfAllCategories(userId);
	}
	public List<CategoryOccWrapper> getWrappedCategoriesWithPercent(long userId){
		DAOFactory factory = DAOFactory.getDAOFactory();
		CategoryDAO categoryDao = factory.getCategoryDAO();
		List<CategoryOccWrapper> categoryWrapper =categoryDao.getWrappedCategories(userId);
		int numberOfAllCategories=0;
		for(CategoryOccWrapper item:categoryWrapper){
			numberOfAllCategories=item.getOccNumber()+numberOfAllCategories;
		}
		
		for(CategoryOccWrapper categoryItem:categoryWrapper){
			float percent=(float)categoryItem.getOccNumber()/(float)numberOfAllCategories;
			float truncatedPercent = BigDecimal.valueOf(percent*100)
				    .setScale(2, RoundingMode.HALF_UP).floatValue();
			categoryItem.setPercent(truncatedPercent);
		};
		return categoryWrapper;
	}
}

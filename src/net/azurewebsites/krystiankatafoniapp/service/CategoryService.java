package net.azurewebsites.krystiankatafoniapp.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import net.azurewebsites.krystiankatafoniapp.dao.CategoryDAO;
import net.azurewebsites.krystiankatafoniapp.dao.DAOFactory;
import net.azurewebsites.krystiankatafoniapp.model.Category;
import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.wrapper.CategoryOccWrapper;
/**
 * CategoryService class is a class, which is a service layer for Category.
 * Service layer is taken factory from DAOFactory
 * and in next step implement business logic to execute CRUD method
 * or other method needed for controller
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-20
 */

public class CategoryService {
	
	/**
	 * addCategory method use input arguments to
	 * create new category object and than
	 * through categoryDao object create new category
	 * @param categoryname - name of category as String send by controller
	 * @param user - user object send by controller
	 */
	public void addCategory(String categoryname, User user){
		
		if((user!=null)&&(categoryname!=null)){
			User userCopy = new User(user);
			Category category = new Category();
			category.setCategoryname(categoryname);
			if(userCopy.getId()!=null){
				category.setUserId(userCopy.getId());
				DAOFactory factory = DAOFactory.getDAOFactory();
				if(factory!=null){
					CategoryDAO categoryDao = factory.getCategoryDAO();
					categoryDao.create(category);
				}
			}
		}
	}
	/**
	 * getAll method is a method, which main purpose
	 * is to return list of all categories( for user sent
	 * by controller) from database
	 * @param user - user object send by controller
	 * @return categoryList - list of all categories from database 
	 */
	public List<Category> getAll(User user){
		List<Category> categoryList = new LinkedList<>();
		if(user!=null){	
			User userCopy = new User(user);
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				CategoryDAO categoryDao=factory.getCategoryDAO();
				if(userCopy.getId()!=null){
					categoryList=categoryDao.getAll(userCopy.getId());
				}	
			}
		}
		return categoryList;
	}
	/**
	 * deleteCategory method is a method, which 
	 * delete category from database
	 * @param categoryId - id of category which has to be deleted
	 * @return result - result of deleting operation, 
	 *         true - category deleted,
	 *         false - category not deleted
	 */
	public boolean deleteCategory(Long categoryId){
		boolean result = false;
		if(categoryId!=null){
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				CategoryDAO categoryDao=factory.getCategoryDAO();
				result=categoryDao.delete(categoryId);
			}
		}
		return result;	
	}
	/**
	 * updateCategory method is updating one category
	 * in database
	 * @param category - object of category which has
	 * 		  to be updated in database
	 * @return result - result of updating operation, 
	 *         true -  category updated,
	 *         false - category not updated
	 */
	public boolean updateCategory(Category category){
		boolean result = false;
		if(category!=null){
			Category categoryCopy = new Category(category);
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				CategoryDAO categoryDao = factory.getCategoryDAO();
				result=categoryDao.update(categoryCopy);
			}
		}
		return result;
	}
	/**
	 * amountOfAllCategories method get amount of all categories
	 * from database for user given as argument
	 * @param user - object of user, for this user is taken list of
	 *        all categories from db
	 * @return - value as int, amount of all categories
	 */
	public int amountOfAllCategories(User user){
		int result=0;
		if(user!=null){
			User userCopy = new User(user);
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				CategoryDAO categoryDao = factory.getCategoryDAO();
				if(userCopy.getId()!=null){
					result = categoryDao.amountOfAllCategories(userCopy.getId());
			
				}
			}
		}
		return result;
	}
	/**
	 * getWrappedCategoriesWithPercent set percentage
	 * of one category from set of all categories 
	 * @param user- object of user
	 * @return categoryWrapper - list of all Wrapper categories with setted percentage values
	 */
	public List<CategoryOccWrapper> getWrappedCategoriesWithPercent(User user){
		int numberOfAllCategories=0;
		List<CategoryOccWrapper> categoryWrapper = new LinkedList<>();
		if(user!=null){
			User userCopy = new User(user);
			DAOFactory factory = DAOFactory.getDAOFactory();
			if(factory!=null){
				CategoryDAO categoryDao = factory.getCategoryDAO();
				if(userCopy.getId()!=null){
					categoryWrapper =categoryDao.getWrappedCategories(userCopy.getId());
					/*This loop count amount of all categories*/
					for(CategoryOccWrapper item:categoryWrapper){
						numberOfAllCategories=item.getOccNumber()+numberOfAllCategories;
					}
					/*This loop count percentage of one item(category) from set of all categories
					 * and set this value for categoryItem 
					 */
					for(CategoryOccWrapper categoryItem:categoryWrapper){
						float percent=(float)categoryItem.getOccNumber()/(float)numberOfAllCategories;
						float truncatedPercent = BigDecimal.valueOf(percent*100)
								.setScale(2, RoundingMode.HALF_UP).floatValue();
						categoryItem.setPercent(truncatedPercent);
					}
				}
			}
		}
		return categoryWrapper;	
	}
}

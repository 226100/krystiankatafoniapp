package net.azurewebsites.krystiankatafoniapp.controller.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.model.Category;
import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.service.CategoryService;
/**
 * Update category controller 
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-05
 */

@WebServlet("/updateCategory")
public class UpdateCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long categoryId = Long.parseLong(request.getParameter("id"));
		User userInSession = (User)request.getSession().getAttribute("user");	
		String categoryname = request.getParameter("categoryname");
		/*
		 * Update category
		 */
		if(categoryId!=null&&userInSession!=null&&categoryname!=null){
			Category category = new Category(categoryId, categoryname, userInSession.getId());
			CategoryService categoryService = new CategoryService();
			categoryService.updateCategory(category);
		}
		response.sendRedirect(request.getContextPath()+"/category");
		
	}

}

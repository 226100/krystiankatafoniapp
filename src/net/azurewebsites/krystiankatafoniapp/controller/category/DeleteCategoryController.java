package net.azurewebsites.krystiankatafoniapp.controller.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.service.CategoryService;

/**
 * Delete category controller 
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-05
 */

@WebServlet("/deleteCategory")
public class DeleteCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result = false;
		Long categoryId = Long.parseLong(request.getParameter("categoryId"));
		CategoryService categoryService = new CategoryService();
		/*
		 * Delete category
		 */
		if(categoryId!=null){
			result=categoryService.deleteCategory(categoryId);
		}
		if(result==false){
			request.getRequestDispatcher("WEB-INF/cannotDeleteCategory.jsp").forward(request,response);
		}else{
			response.sendRedirect(request.getContextPath()+"/category");
		}
	}

}

package net.azurewebsites.krystiankatafoniapp.controller.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.service.CategoryService;

/**
 * Add Category controller 
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-05
 */

@WebServlet("/addCategory")
public class AddCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getUserPrincipal()!=null){
			request.getRequestDispatcher("WEB-INF/category.jsp").forward(request, response);
		}else{
			response.sendError(403);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String categoryname = request.getParameter("categoryname");
		User userInSession = (User)request.getSession().getAttribute("user");
		CategoryService categoryService = new CategoryService();
		/*
		 * Add category
		 */
		if(categoryname!=null&&userInSession!=null){
			categoryService.addCategory(categoryname, userInSession);
		}
		response.sendRedirect(request.getContextPath()+"/category");
	}

}

package net.azurewebsites.krystiankatafoniapp.controller.category;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.model.Category;
import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.service.CategoryService;

/**
 * Category controller, main category overview
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-05
 */

@WebServlet("/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categoryList = new LinkedList<>();
		User userInSession = (User)request.getSession().getAttribute("user");
		CategoryService categoryService = new CategoryService();
		/*
		 * Get list of all categories
		 */
		if(userInSession!=null){
			categoryList=categoryService.getAll(userInSession);
		}
		request.setAttribute("categoryList", categoryList);
		if(request.getUserPrincipal()!=null){
			request.getRequestDispatcher("WEB-INF/category.jsp").forward(request, response);
		}else{
			response.sendError(403);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}

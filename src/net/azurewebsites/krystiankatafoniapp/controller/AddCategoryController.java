package net.azurewebsites.krystiankatafoniapp.controller;

import java.io.IOException;
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
 * Servlet implementation class AddCategoryController
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
	
		request.setCharacterEncoding("UTF-8");
		String categoryname = request.getParameter("categoryname");
		User userInSession = (User)request.getSession().getAttribute("user");
		CategoryService categoryService = new CategoryService();
		categoryService.addCategory(categoryname, userInSession);
		response.sendRedirect(request.getContextPath()+"/category");
	}

}

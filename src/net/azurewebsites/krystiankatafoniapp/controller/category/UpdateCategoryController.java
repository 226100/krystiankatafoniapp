package net.azurewebsites.krystiankatafoniapp.controller.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.model.Category;
import net.azurewebsites.krystiankatafoniapp.service.CategoryService;

/**
 * Servlet implementation class UpdateCategoryController
 */
@WebServlet("/updateCategory")
public class UpdateCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long categoryId = Long.parseLong(request.getParameter("id"));
		Long userId = Long.parseLong(request.getParameter("userId"));
		String categoryname = request.getParameter("categoryname");
		Category category = new Category(categoryId, categoryname, userId);
		CategoryService categoryService = new CategoryService();
		categoryService.updateCategory(category);
		response.sendRedirect(request.getContextPath()+"/category");
		
	}

}

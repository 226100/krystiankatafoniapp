package net.azurewebsites.krystiankatafoniapp.controller.statistics;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.service.CategoryService;
import net.azurewebsites.krystiankatafoniapp.service.PurchaseService;
import net.azurewebsites.krystiankatafoniapp.service.ShopService;
import net.azurewebsites.krystiankatafoniapp.wrapper.CategoryOccWrapper;
import net.azurewebsites.krystiankatafoniapp.wrapper.ShopOccWrapper;

@WebServlet("/statistics")
public class StatisticsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getUserPrincipal() != null) {
			User userInSession = (User) request.getSession().getAttribute("user");
			CategoryService categoryService = new CategoryService();
			ShopService shopService = new ShopService();
			List<ShopOccWrapper> occShopList = shopService.getWrappedShopsWithPercent(userInSession.getId());
			List<CategoryOccWrapper> occCategoryList = categoryService.getWrappedCategoriesWithPercent(userInSession.getId());
			request.setAttribute("occShopList", occShopList);
			request.setAttribute("occCategoryList", occCategoryList);
			request.getRequestDispatcher("WEB-INF/statistics.jsp").forward(request, response);
		} else {
			response.sendError(403);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

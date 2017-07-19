package net.azurewebsites.krystiankatafoniapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.service.CategoryService;
import net.azurewebsites.krystiankatafoniapp.service.PurchaseService;
import net.azurewebsites.krystiankatafoniapp.service.ShopService;

/**
 * Servlet implementation class OverwievController
 */
@WebServlet("/overview")
public class OverviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getUserPrincipal()!=null){
			User userInSession = (User)request.getSession().getAttribute("user");
			CategoryService categoryService = new CategoryService();
			ShopService shopService = new ShopService();
			PurchaseService purchaseService = new PurchaseService();
			Integer totalCategory = categoryService.amountOfAllCategories(userInSession);
			Integer totalShop = shopService.amountOfAllShops(userInSession.getId());
			Integer totalPurchase = purchaseService.amountOfAllPurchases(userInSession);
			Float sumOfPrices = purchaseService.sumOfPrices(userInSession);
			request.setAttribute("amountOfAllCategories",totalCategory.toString());
			request.setAttribute("amountOfAllShops",totalShop.toString());
			request.setAttribute("amountOfAllPurchases", totalPurchase.toString());
			request.setAttribute("sumOfPrices", sumOfPrices.toString());
			request.getRequestDispatcher("WEB-INF/mainPage.jsp").forward(request, response);
		}else{
			response.sendError(403);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

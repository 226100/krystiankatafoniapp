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
 * Login controller 
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-05
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getUserPrincipal()!=null){
			User userInSession = (User)request.getSession().getAttribute("user");
			CategoryService categoryService = new CategoryService();
			ShopService shopService = new ShopService();
			PurchaseService purchaseService = new PurchaseService();
			/*
			 * Total amount of category, shop or purchase for logged user
			 */
			Integer totalCategory = categoryService.amountOfAllCategories(userInSession);
			Integer totalShop = shopService.amountOfAllShops(userInSession);
			Integer totalPurchase = purchaseService.amountOfAllPurchases(userInSession);
			/*
			 * Sum of all purchase prices
			 */
			Float sumOfPrices = purchaseService.sumOfPrices(userInSession);
			/*
			 * Set attributes
			 */
			request.setAttribute("amountOfAllCategories",totalCategory.toString());
			request.setAttribute("amountOfAllShops",totalShop.toString());
			request.setAttribute("amountOfAllPurchases", totalPurchase.toString());
			request.setAttribute("sumOfPrices", sumOfPrices.toString());
			/*
			 * Redirect to mainPage.jsp
			 */
			request.getRequestDispatcher("WEB-INF/mainPage.jsp").forward(request, response);
		}else{
			response.sendError(403);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

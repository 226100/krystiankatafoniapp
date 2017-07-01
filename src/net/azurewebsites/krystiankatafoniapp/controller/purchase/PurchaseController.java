package net.azurewebsites.krystiankatafoniapp.controller.purchase;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.model.Category;
import net.azurewebsites.krystiankatafoniapp.model.Purchase;
import net.azurewebsites.krystiankatafoniapp.model.Shop;
import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.service.CategoryService;
import net.azurewebsites.krystiankatafoniapp.service.PurchaseService;
import net.azurewebsites.krystiankatafoniapp.service.ShopService;


@WebServlet("/purchase")
public class PurchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Purchase> purchaseList = null;
		List<Shop> shopList = null;
		List<Category> categoryList = null;
		User userInSession = (User)request.getSession().getAttribute("user");
		PurchaseService purchaseService = new PurchaseService();
		ShopService shopService = new ShopService();
		CategoryService categoryService = new CategoryService();
		purchaseList=purchaseService.getAll(userInSession);
		shopList=shopService.getAll(userInSession);
		categoryList=categoryService.getAll(userInSession);
		request.setAttribute("purchaseList", purchaseList);
		request.setAttribute("shopList", shopList);
		request.setAttribute("categoryList", categoryList);
		if(request.getUserPrincipal()!=null){
			request.getRequestDispatcher("WEB-INF/purchase.jsp").forward(request, response);
		}else{
			response.sendError(403);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
       

}

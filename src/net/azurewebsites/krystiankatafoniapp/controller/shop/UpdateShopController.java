package net.azurewebsites.krystiankatafoniapp.controller.shop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.model.Shop;
import net.azurewebsites.krystiankatafoniapp.service.ShopService;

/**
 * Servlet implementation class UpdateShopController
 */
@WebServlet("/updateShop")
public class UpdateShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long shopId = Long.parseLong(request.getParameter("id"));
		Long userId = Long.parseLong(request.getParameter("userId"));
		String shopname = request.getParameter("shopname");
		Shop shop = new Shop(shopId, shopname, userId);
		ShopService shopService = new ShopService();
		shopService.updateShop(shop);
		response.sendRedirect(request.getContextPath()+"/shop");
		
	}

}

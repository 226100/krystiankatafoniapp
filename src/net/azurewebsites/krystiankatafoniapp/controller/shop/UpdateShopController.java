package net.azurewebsites.krystiankatafoniapp.controller.shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.model.Shop;
import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.service.ShopService;
/**
 * Update shop controller
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-05
 */
@WebServlet("/updateShop")
public class UpdateShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long shopId = Long.parseLong(request.getParameter("id"));
		User user = (User)request.getSession().getAttribute("user");	
		String shopname = request.getParameter("shopname");
		/*
		 * Update shop 
		 */
		if(shopId!=null&&user!=null&&shopname!=null){
			Shop shop = new Shop(shopId, shopname, user.getId());
			ShopService shopService = new ShopService();
			shopService.updateShop(shop);
		}
		response.sendRedirect(request.getContextPath()+"/shop");
		
	}

}

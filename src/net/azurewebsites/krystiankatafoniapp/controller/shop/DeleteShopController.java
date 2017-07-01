package net.azurewebsites.krystiankatafoniapp.controller.shop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.service.ShopService;

@WebServlet("/deleteShop")
public class DeleteShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long shopId = Long.parseLong(request.getParameter("shopId"));
		ShopService shopService = new ShopService();
		shopService.deleteShop(shopId);
		response.sendRedirect(request.getContextPath()+"/shop");
	}

}

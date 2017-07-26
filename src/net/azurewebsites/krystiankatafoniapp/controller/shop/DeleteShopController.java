package net.azurewebsites.krystiankatafoniapp.controller.shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.service.ShopService;
/**
 * Delete Shop controller 
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-05
 */
@WebServlet("/deleteShop")
public class DeleteShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result = false;
		Long shopId = Long.parseLong(request.getParameter("shopId"));
		ShopService shopService = new ShopService();
		/*
		 * Delete shop
		 */
		if(shopId!=null){
			result =shopService.deleteShop(shopId);
		}
		if(result==false){
			request.getRequestDispatcher("WEB-INF/cannotDeleteShop.jsp").forward(request,response);
		}else{
			response.sendRedirect(request.getContextPath()+"/shop");
		}
	}

}

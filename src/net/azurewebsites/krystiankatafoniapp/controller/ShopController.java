package net.azurewebsites.krystiankatafoniapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.model.Shop;
import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.service.ShopService;

@WebServlet("/shop")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
		List<Shop> shopList = null;
		User userInSession = (User)request.getSession().getAttribute("user");
		ShopService shopService = new ShopService();
		shopList=shopService.getAll(userInSession);
		request.setAttribute("shopList", shopList);
		if(request.getUserPrincipal()!=null){
			request.getRequestDispatcher("WEB-INF/shop.jsp").forward(request, response);
		}else{
			response.sendError(403);
		}
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
}


}

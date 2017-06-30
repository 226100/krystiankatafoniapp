package net.azurewebsites.krystiankatafoniapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.service.CategoryService;
import net.azurewebsites.krystiankatafoniapp.service.ShopService;

/**
 * Servlet implementation class AddShopController
 */
@WebServlet("/addShop")
public class AddShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getUserPrincipal()!=null){
			request.getRequestDispatcher("WEB-INF/shop.jsp").forward(request, response);
		}else{
			response.sendError(403);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		String shopname = request.getParameter("shopname");
		User userInSession = (User)request.getSession().getAttribute("user");
		ShopService shopService = new ShopService();
		shopService.addShop(shopname, userInSession);
		response.sendRedirect(request.getContextPath()+"/shop");
	}

}

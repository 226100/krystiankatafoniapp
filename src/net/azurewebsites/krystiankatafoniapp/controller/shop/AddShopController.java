package net.azurewebsites.krystiankatafoniapp.controller.shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.service.ShopService;

/**
 * Add Shop controller 
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-05
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
		if(request.getUserPrincipal()!=null){
			String shopname = request.getParameter("shopname");
			User userInSession = (User)request.getSession().getAttribute("user");
			ShopService shopService = new ShopService();
			/*
			 * Add shop to database
			 */
			if(shopname!=null&&userInSession!=null){
				shopService.addShop(shopname, userInSession);
			}
			response.sendRedirect(request.getContextPath()+"/shop");
		}else{
			response.sendError(403);
		}
	}

}

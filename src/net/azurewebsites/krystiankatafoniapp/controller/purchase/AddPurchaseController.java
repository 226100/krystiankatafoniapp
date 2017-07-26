package net.azurewebsites.krystiankatafoniapp.controller.purchase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.service.PurchaseService;

/**
 * Add Purchase controller 
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-05
 */

@WebServlet("/addPurchase")
public class AddPurchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getUserPrincipal()!=null){
			request.getRequestDispatcher("WEB-INF/purchase.jsp").forward(request, response);
		}else{
			response.sendError(403);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String purchasename = request.getParameter("purchasename");
		Float price = Float.parseFloat(request.getParameter("price"));
		String categoryname = request.getParameter("categoryname");
		String shopname = request.getParameter("shopname");
		User userInSession = (User)request.getSession().getAttribute("user");
		PurchaseService purchaseService = new PurchaseService();
		/*
		 * Add purchase
		 */
		if(purchasename!=null&&price!=null&&categoryname!=null&&shopname!=null&&userInSession!=null){
			purchaseService.addPurchase(purchasename,categoryname,shopname,price, userInSession);
		}
			response.sendRedirect(request.getContextPath()+"/purchase");
	} 
}

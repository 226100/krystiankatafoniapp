package net.azurewebsites.krystiankatafoniapp.controller.purchase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.model.Purchase;
import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.service.PurchaseService;


@WebServlet("/updatePurchase")
public class UpdatePurchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long purchaseId = Long.parseLong(request.getParameter("id"));
		User userInSession = (User)request.getSession().getAttribute("user");
		String purchasename = request.getParameter("purchasename");
		String categoryname = request.getParameter("categoryname");
		String shopname = request.getParameter("shopname");
		float price = Float.parseFloat(request.getParameter("price"));
		PurchaseService purchaseService = new PurchaseService();
		purchaseService.updatePurchase(purchaseId, purchasename, categoryname, shopname, price, userInSession);
		response.sendRedirect(request.getContextPath()+"/purchase");
		
	}

}

package net.azurewebsites.krystiankatafoniapp.controller.purchase;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.service.PurchaseService;
/**
 * Delete purchase controller 
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-05
 */

@WebServlet("/deletePurchase")
public class DeletePurchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long purchaseId = Long.parseLong(request.getParameter("purchaseId"));
		PurchaseService purchaseService = new PurchaseService();
		/*
		 * Delete purchase
		 */
		if(purchaseId!=null){
			purchaseService.deletePurchase(purchaseId);
		}
		response.sendRedirect(request.getContextPath()+"/purchase");
	}

}

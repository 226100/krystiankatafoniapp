package net.azurewebsites.krystiankatafoniapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.azurewebsites.krystiankatafoniapp.service.UserService;
/**
 * Register controller 
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-05
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/register.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("inputUsername");
		String email = request.getParameter("inputEmail");
		String password = request.getParameter("inputPassword");
		UserService userService = new UserService();
		boolean result=userService.addUser(username, email, password);
		if(!result){
			request.getRequestDispatcher("WEB-INF/registerError.jsp").forward(request,response);
		}
		response.sendRedirect(request.getContextPath()+"/");
	}

}

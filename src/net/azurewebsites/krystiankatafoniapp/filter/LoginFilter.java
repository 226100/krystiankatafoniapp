package net.azurewebsites.krystiankatafoniapp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import net.azurewebsites.krystiankatafoniapp.model.User;
import net.azurewebsites.krystiankatafoniapp.service.UserService;
/**
 * LoginFilter is a filter which is using on each opened jsp page
 * This filter check if user is saved in session, if not method
 * saveUserInSession save it
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-20
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
	/**
	 * doFilter check if user is saved in session
	 * if not save it through saveUserInSession() method
	 * @param request - servlet request 
	 * @param response - servlet response
	 * @param chain - chain to execute filter
	 */ 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest)request;
		if(httpReq.getUserPrincipal()!=null&&httpReq.getSession().getAttribute("user")==null){
			saveUserInSession(httpReq);
		}
		chain.doFilter(request, response);
	}
	/**
	 * saveUserInSession get user name from principal
	 * in next step ask database through UserService about object of this user
	 * if user exist save user
	 * @param httpReq 
	 */
	private void saveUserInSession(HttpServletRequest httpReq){
		UserService userServ = new UserService();
		String userName = httpReq.getUserPrincipal().getName();
		if(userName!=null){
			User userByUserName = userServ.getUserByUsername(userName);
			if(userByUserName!=null){
				httpReq.getSession(true).setAttribute("user", userByUserName);
			}
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	@Override
	public void destroy() {

	}

}

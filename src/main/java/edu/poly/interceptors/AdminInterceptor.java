package edu.poly.interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import edu.poly.entity.Account;


@Component
public class AdminInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws IOException {
		HttpSession session = request.getSession();
		Account	account = (Account) session.getAttribute("account");
	
		if(account.getAdmin() !=1) {
			response.sendRedirect(request.getContextPath() +"/member/search-and-page");
			return false;
		}
		return true;
	}
}

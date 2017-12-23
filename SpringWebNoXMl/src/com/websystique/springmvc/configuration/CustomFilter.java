package com.websystique.springmvc.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.filter.GenericFilterBean;

public class CustomFilter extends GenericFilterBean {
	
	
@Override
public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
	
	
	HttpServletRequest req = (HttpServletRequest)request;
    HttpServletResponse resp = (HttpServletResponse)response;
    HttpSession session = req.getSession(false);

    User user = (session != null) ? (User) session.getAttribute("user") : null;
    
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
if(auth!=null)
	System.out.println(auth.getName());
    
    System.out.println(user);

    
    chain.doFilter(req, resp); // Logged-in user found, so just continue request.
}

}
package com.cs336.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	
    public Register() {
       
    }
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String setUsername = (String) request.getParameter("setUsername");
		String setPassword = (String) request.getParameter("setPassword");
		String confirmPassword = (String) request.getParameter("confirmPassword");
	
		if(setPassword.length()>20 || setUsername.length()>20)
			response.sendRedirect("register.jsp");
		if(!setPassword.equals(confirmPassword))
			response.sendRedirect("register.jsp");
		
		ApplicationDB newUser = new ApplicationDB();
		try {
			newUser.register(setUsername,setPassword);
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

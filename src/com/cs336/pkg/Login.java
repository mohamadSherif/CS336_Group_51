package com.cs336.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
    public Login() {
        
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		
		ApplicationDB loginUser = new ApplicationDB();
		try {
			if(loginUser.login(username, password, userType)==true){
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				if(userType.equals("custRep"))
					response.sendRedirect("customer_rep_dash.jsp");
				else if(userType.equals("admin"))
					response.sendRedirect("adminDash.jsp");
				else
					response.sendRedirect("dashboard.jsp");
			}
			else
				response.sendRedirect("index.jsp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

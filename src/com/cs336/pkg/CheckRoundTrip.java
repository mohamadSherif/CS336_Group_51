package com.cs336.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckRoundTrip")
public class CheckRoundTrip extends HttpServlet {
	
    public CheckRoundTrip() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String flightNumber = request.getParameter("flightNumber");
		String airline = request.getParameter("airline");
		String departTime = request.getParameter("departTime");
		String arriveTime = request.getParameter("arriveTime");
		
		String[] flight = {flightNumber,airline,departTime,arriveTime};
		
		ArrayList<String[]> flights = ((ArrayList<String[]>) session.getAttribute("flights"));
		flights.add(flight);
		session.setAttribute("flights", flights);
		
		if((Boolean) session.getAttribute("roundTrip")==true){
			session.setAttribute("roundTrip", false);
			ResultSet set = null;
			ArrayList<Flight> list = new ArrayList<Flight>();
			
			ApplicationDB searchFlights = new ApplicationDB();
			String[] airport = (String[]) session.getAttribute("airport");
			Date[] date = (Date[])session.getAttribute("date");
			set = searchFlights.get2Flights(airport[1], airport[0], date[1]);
			
			try {
				while(set.next()){
					Flight inst = new Flight(set.getString("flightNumber"),set.getString("airline_name"), set.getString("depart_time"), set.getString("arrive_time"));
					list.add(inst);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
		else{
			response.sendRedirect("reservation.jsp");
		}
	}

}

package com.cs336.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SearchFlights")
public class SearchFlights extends HttpServlet {
	
    public SearchFlights() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationDB searchFlights = new ApplicationDB();
		String departAirport = request.getParameter("departAirport");
		String arriveAirport = request.getParameter("arriveAirport");
		
		java.sql.Date newDepartDate = java.sql.Date.valueOf(request.getParameter("departDate"));
		

		ResultSet set = searchFlights.getFlights(departAirport, arriveAirport, newDepartDate);
		ArrayList<Flight> list = new ArrayList<>();
		
		
		String[] airport = {request.getParameter("departAirport"),request.getParameter("arriveAirport")};
		
		HttpSession session = request.getSession();
		ArrayList<String[]> flightList = new ArrayList<>();
		
		session.setAttribute("flights", flightList); //session object flights contains reservations. reservations are added in CheckRoundTrip servlet
		session.setAttribute("roundTrip", false);
		
		if(request.getParameter("trip").equals("round-trip")){
			java.sql.Date newArriveDate = java.sql.Date.valueOf(request.getParameter("arriveDate"));
			Date[] date = {newDepartDate,newArriveDate};
			session.setAttribute("roundTrip", true);
			session.setAttribute("date", date);
			session.setAttribute("class", request.getParameter("class"));
			session.setAttribute("airport", airport);
		}
		
		
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

}

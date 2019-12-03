package com.cs336.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		String flightType = request.getParameter("trip");		
		
		String departAirport = request.getParameter("departAirport");
		String arriveAirport = request.getParameter("arriveAirport");
		
		java.sql.Date newDepartDate = java.sql.Date.valueOf(request.getParameter("departDate"));
		java.sql.Date newArriveDate = java.sql.Date.valueOf(request.getParameter("arriveDate"));
		String[] tripClass = new String[2];
		tripClass[0] = request.getParameter("trip");
		tripClass[1] = request.getParameter("class");
		
		String[] airport = new String[2];
		airport[0] = request.getParameter("departAirport");
		airport[1] = request.getParameter("arriveAirport");
		
		Date[] date = new Date[2];
		date[0] = newDepartDate;
		date[1] = newArriveDate;
		
		HttpSession session = request.getSession();
		session.setAttribute("tripClass",tripClass);
		session.setAttribute("airport",airport);
		session.setAttribute("date", date);
		session.setAttribute("sentinel", 0);
		//int sent = session.getAttribute("sentinel");
		
		
		ResultSet set = searchFlights.getDepartureFlights(departAirport, arriveAirport,newDepartDate);
		ArrayList<Flight> list = new ArrayList<Flight>();
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

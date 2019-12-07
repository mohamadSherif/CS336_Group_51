package com.cs336.pkg;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditFlight
 */
public class EditFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flightNum = Integer.valueOf(request.getSession(false).getAttribute("flightNum").toString());
		String airline = request.getParameter("airline");
		int firstPrice = Integer.valueOf(request.getParameter("firstPrice"));
		int econPrice = Integer.valueOf(request.getParameter("econPrice"));
		int busPrice = Integer.valueOf(request.getParameter("busPrice"));
		int international = Integer.valueOf(request.getParameter("international"));
		Date departDate = Date.valueOf(request.getParameter("departDate"));
		Date arriveDate = Date.valueOf(request.getParameter("arriveDate"));
		java.sql.Time departTime = Time.valueOf(request.getParameter("departTime"));
		java.sql.Time arriveTime = Time.valueOf(request.getParameter("arriveTime"));
		String departAirport = request.getParameter("departAirport");
		String arriveAirport = request.getParameter("arriveAirport");
		int firstSeats = Integer.valueOf(request.getParameter("firstSeats"));
		int busSeats = Integer.valueOf(request.getParameter("busSeats"));
		int econSeats = Integer.valueOf(request.getParameter("econSeats"));
		int aircraftNum = Integer.valueOf(request.getParameter("aircraftNum"));
		ApplicationDB update = new ApplicationDB();
		update.updateFlight(flightNum,airline,departAirport,arriveAirport,departDate,arriveDate,departTime,arriveTime,firstPrice,econPrice,busPrice,international,firstSeats,busSeats,econSeats,aircraftNum);
		response.sendRedirect("customer_rep_dash.jsp");
	}

}

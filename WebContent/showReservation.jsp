 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.cs336.pkg.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Edit Information</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="./css/styles.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Merriweather:300i,400,900&display=swap" rel="stylesheet">
    </head>
    <body>
	<%
	try {
		ApplicationDB db = new ApplicationDB();		
		int resNum = Integer.valueOf(request.getParameter("resNum"));
		ResultSet result = db.showReservation(resNum);
		out.print("<h1>Reservation " + resNum + " </h1>");
		out.print("<form action='EditReservation' method='post'>");
		out.print("<table class='show'>");
		out.print("<tr>");
		out.print("<td>");	
		out.print("Reservation Number");
		out.print("</td>");
		out.print("<td>");
		out.print("Ticket Number");
		out.print("</td>");
		out.print("<td>");	
		out.print("Flight Number");
		out.print("</td>");
		out.print("<td>");
		out.print("Airline Name");
		out.print("</td>");
		out.print("<td>");	
		out.print("Depart Time");
		out.print("</td>");
		out.print("<td>");
		out.print("Depart Date");
		out.print("</td>");
		out.print("<td>");	
		out.print("Departure Airport");
		out.print("</td>");
		out.print("<td>");
		out.print("Arrive Time");
		out.print("</td>");
		out.print("<td>");	
		out.print("Arrive Date");
		out.print("</td>");
		out.print("<td>");
		out.print("Arrive Airport");
		out.print("</td>");
		out.print("<td>");	
		out.print("Meal Plan");
		out.print("</td>");
		out.print("<td>");
		out.print("Seat Number");
		out.print("</td>");
		out.print("<td>");	
		out.print("Class Type");
		out.print("</td>");
		out.print("</tr>");

		while (result.next()) {
		
			out.print("<tr>");
		
			out.print("<td>");
			out.print("<input type='text' name='resNum' value= '"+ result.getInt("reservation_number")+"' disabled/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='ticketNum' value= '"+ result.getString("ticket_number")+"' disabled/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='flightNumber' value= '"+ result.getInt("flightNumber")+"'disabled/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='airlineName' value= '"+ result.getInt("airline_name")+"'disabled/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='departTime' value= '"+ result.getTime("depart_time")+"'disabled/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='departDate' value= '"+ result.getDate("depart_date")+"'disabled/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='time' name='departAirport' value= '"+ result.getString("depart_airport_name")+"'disabled/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='date' name='arriveTime' value= '"+ result.getTime("arrive_time")+"'disabled/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='arriveDate' value= '"+ result.getDate("arrive_day")+"' disabled/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='time' name='arriveAirport' value=' "+ result.getString("arrive_airport_name")+"' disabled/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='date' name='mealPlan' value= '"+ result.getString("meal_plan")+"'/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='seatNum' value= '"+ result.getInt("seat_number")+"'/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='classType' value= '"+ result.getString("classType")+"'/>");
			out.print("</td>");
		
			out.print("</tr>");

		}
		out.print("</table>");
		out.print("<button type='submit'>Save Changes</button>");
		out.print("</form>");
		

	} catch (Exception e) {
		out.print(e);
	}
	%>
	
	<!-- <script src="" async defer></script> -->
    </body>
</html>
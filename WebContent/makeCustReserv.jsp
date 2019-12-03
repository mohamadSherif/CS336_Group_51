<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Make Customer Reservation</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./css/customer_style.css">
    </head>
    <body>
	<%
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
	    response.setHeader("Pragma", "no-cache");
	    response.setHeader("Expires", "0");
	    
		if(session.getAttribute("username")==null)
			response.sendRedirect("index.jsp");
	%>
        <!--[if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="#">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
        <div class="topnav">
            <h1 style="float: left; margin-left: 20px;">Travel Website - <i><small>${username}</small></i></h1>
            <div class="topnav-right">
                <img src="./img/user.png" style="width: 70px; height: 70px; padding: 10px; margin: 10px;">
            </div>
          </div>
          <div class="cust_rep_dash">
			<button class="button" onclick="window.location.href = 'customer_rep_dash.jsp';">Dashboard</button>
           	<h1>Make a customer reservation</h1>
           	<div class="search">
                    <form action="SearchFlights" method = "post">
                    	<label style="font-size: 20px;" for="uname">Customer Username</label>
                    	<input type="text" name="customerUser" placeholder="Customer Username">
                        <select name="trip" class="choose">
                            <option value="round-trip">Round Trip</option>
                            <option value="one-way">One Way</option>
                        </select>

                        <select name="class" class="choose">
                            <option value="economy">Economy</option>
                            <option value="business">Business</option>
                            <option value="firstClass">First Class</option>
                        </select>
                        </br>
                        <input type="text" name="departAirport" placeholder="From">
                        <input type="text" name="arriveAirport" placeholder="To">
                        <input type="date" name="departDate" placeholder="YYYY-MM-DD">
                        <input type="date" name="arriveDate" placeholder="YYYY-MM-DD">
                    </br>
                        <input type="submit" value="submit">
                </br>
                        
                        </form>
                </div>

                <div class="filter">
                    <select name="filter_price" class="choose" style="border-radius: 5px; margin-bottom:0px; margin-right: 25px;">
                        <option value="">Sort by price</option>
                        <option value="low2high">Low to high</option>
                        <option value="high2low">High to low</option>
                    </select>

                    <select name="filter_stops" class="choose" 
                    style="border-radius: 5px; margin-bottom:0px; margin-right: 45px;">
                            <option value="">Sort by stops</option>
                            <option value="low2high"> &lt; 2 </option>
                            <option value="high2low"> &gt; 2</option>
                        </select>
                    
                    <input type="text" name="filter_airline" placeholder="Filter by airline" style="margin: 0px;">
                </div>
                  
                <div class="result_card">
				<table>
					
					<c:forEach items="${list}" var="flight">
						<tr>
							<th>Flight Number</th>
							<th>Airlines</th>
							<th>Departure Time</th>
							<th>Arrival Time</th>
						</tr>
						<tr>
							<td>${flight.flightNumber}</td>
							<td>${flight.airline_name}</td>
							<td>${flight.departTime}</td>
							<td>${flight.arriveTime}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
            </div>

	<form method="Get" action="Logout">
		<input type="submit" value="Logout" />
	</form>

	<script src="./js/customer_dash_script.js" async defer></script>
        
    </body>
</html>

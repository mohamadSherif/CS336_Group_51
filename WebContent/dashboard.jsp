<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Dashboard</title>
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

       <div class="row">

		<div class="column middle">
			<div class="search">
				<form action="SearchFlights" method="post">
					<select name="trip" class="choose">
						<option value="one-way" selected>One Way</option>
						<option value="round-trip">Round Trip</option>
					</select> <select name="class" class="choose">
						<option value="economy">Economy</option>
						<option value="business">Business</option>
						<option value="firstClass">First Class</option>
					</select> </br> <input type="text" name="departAirport" placeholder="From">
					<input type="text" name="arriveAirport" placeholder="To"> <input
						type="date" name="departDate" placeholder="YYYY-MM-DD"> <input
						type="date" name="arriveDate" placeholder="YYYY-MM-DD"> </br> <input
						type="submit" value="submit"> </br>

				</form>
			</div>

			<div class="filter">
				<select name="filter_price" class="choose"
					style="border-radius: 5px; margin-bottom: 0px; margin-right: 25px;">
					<option value="">Sort by price</option>
					<option value="low2high">Low to high</option>
					<option value="high2low">High to low</option>
				</select> <select name="filter_stops" class="choose"
					style="border-radius: 5px; margin-bottom: 0px; margin-right: 45px;">
					<option value="">Sort by stops</option>
					<option value="low2high">&lt; 2</option>
					<option value="high2low">&gt; 2</option>
				</select> <input type="text" name="filter_airline"
					placeholder="Filter by airline" style="margin: 0px;">
			</div>

			<div class="result_card">
				<form action="CheckRoundTrip" method="POST">
					<table>
						<thead>
							<tr>
								<td width="10%">FLIGHT NUMBER</td>
								<td width="30%">AIRLINES</td>
								<td width="30%">DEPARTURE TIME</td>
								<td width="20%">ARRIVAL TIME</td>
							</tr>
						</thead>

						<tbody>

							<c:forEach items="${list}" var="flight">
								<tr>
									<td align="left"><input type="text" name="flightNumber"
										value="${flight.flightNumber}" readonly /></td>
									<td align="left"><input type="text" name="airline"
										value="${flight.airline_name}" readonly /></td>
									<td align="left"><input type="text" name="departTime"
										value="${flight.departTime}" readonly /></td>
									<td align="left"><input type="text" name="arriveTime"
										value="${flight.arriveTime}" readonly /></td>
									<td align="center"><input type="submit" value="Select" />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>

		</div>
	</div>

	<form method="Get" action="Logout">
		<input type="submit" value="Logout" />
	</form>

	<script src="./js/customer_dash_script.js" async defer></script>
        
    </body>
</html>

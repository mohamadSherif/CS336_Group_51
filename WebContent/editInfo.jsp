<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Edit Information</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Merriweather:300i,400,900&display=swap" rel="stylesheet">
    </head>
    <body>

	<div class="card">
		<div class="content">
			<h4 style="text-align: center; font-size: 35px;">
			
				<button class="button" onclick="window.location.href = 'customer_rep_dash.jsp';">Dashboard</button><br/>
			</h4>
				<b>Edit a flight</b><br/>
			<form action="showFlight.jsp" method="post">
				Flight Number: <input type="text" name="flightNum" maxlength=11 required/><br/>
				<button type="submit" >Edit Flight</button>
			
				
			</form>
			<br/><br/>
			<b>Edit an aircraft</b><br/>
	
			<form action="showAircraft.jsp" method="post">
				Aircraft Number: <input type="text" name="num" maxlength=3 required/><br/>
				<button type="submit" >Edit Aircraft</button>
				
				
				
			</form>
			<br/><br/>
			<b>Edit an airport</b><br/>
			
			<form action="showAirport.jsp" method="post">
				Airport ID: <input type="text" name="airportID" required/><br/>
				<button type="submit" >Edit Airport</button>
				
				
				
			</form>
		</div>

	</div>

	<!-- <script src="" async defer></script> -->
    </body>
</html>
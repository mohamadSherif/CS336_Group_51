<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Edit Customer Reservation</title>
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
           	<h1>Edit a customer reservation</h1>
           	
			<form action="showReservation.jsp" method="post">
				Ticket Number: <input type="text" name="ticketNum" maxlength=11 required/><br/>
				Flight Number: <input type="text" name="flightNum" maxlength=11 required/><br/>
				Airline Name: <input type="text" name=airlineName" required/><br/>
				Depart Date: <input type="date" name="departDate" required/><br/>
				Arrival Date: <input type="date" name="arriveDate" required/><br/>
				<button type="submit" >Edit Reservation</button>
			
				
			</form>
            </div>

	<form method="Get" action="Logout">
		<input type="submit" value="Logout" />
	</form>

	<script src="./js/customer_dash_script.js" async defer></script>
        
    </body>
</html>

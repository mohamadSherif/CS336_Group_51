<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Airport, Aircraft, Flight Information</title>
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
			<button class="button" onclick="window.location.href = 'customer_rep_dash.jsp';">Dashboard</button><br/>
			<button class="button" onclick="window.location.href = 'addFlight.jsp';">Add Flight</button>
			<button class="button" onclick="window.location.href = 'editFlight.jsp';">Edit Flight</button>
			<button class="button" onclick="window.location.href = 'deleteFlight.jsp';">Delete Flight</button><br/><br/>
			
			<button class="button" onclick="window.location.href = 'addFlight.jsp';">Add Aircraft</button>
			<button class="button" onclick="window.location.href = 'editFlight.jsp';">Edit Aircraft</button>
			<button class="button" onclick="window.location.href = 'deleteFlight.jsp';">Delete Aircraft</button><br/><br/>
			
			<button class="button" onclick="window.location.href = 'addFlight.jsp';">Add Airport</button>
			<button class="button" onclick="window.location.href = 'editFlight.jsp';">Edit Airport</button>
			<button class="button" onclick="window.location.href = 'deleteFlight.jsp';">Delete Airport</button><br/><br/>
			
			<form action="editFlight" method="post">
				<input type="text" name="flight" placeholder="Flight Number" required/>
				<button type="submit">Edit</button>
			</form><t/>
			<form action="deleteFlight" method="post">
				<button type="submit">Delete</button>
			</form><t/>
			<form action="addFlight" method="post">
				<button type="submit">Add Flight</button><br/><br/>
			</form>
			<form action="editAircraft" method="post">
				<input type="text" name="aircraft" placeholder="Aircraft Number" required/>
				<button type="submit">Edit</button>
			</form><t/>
			<form action="deletAircraft" method="post">
				<button type="submit">Delete</button>
			</form><t/>
			<form action="addAircraft" method="post">
				<button type="submit">Add Aircraft</button><br/><br/>
			</form>
			<form action="editAirport" method="post">
				<input type="text" name="airport" placeholder="Airport Name" required/>
				<button type="submit">Edit</button>
			</form><t/>
			<form action="deleteAirport" method="post">
				<button type="submit">Delete</button>
			</form><t/>
			<form action="addAirport" method="post">
				<button type="submit">Add Airport</button><br/>
			</form>
	<form method="Get" action="Logout">
		<input type="submit" value="Logout" />
	</form>

	<script src="./js/customer_dash_script.js" async defer></script>
        
    </body>
</html>
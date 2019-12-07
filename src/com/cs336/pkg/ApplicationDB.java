package com.cs336.pkg;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class ApplicationDB {
	
	String url = "jdbc:mysql://cs336.c53p7gmkdybi.us-east-2.rds.amazonaws.com/cs336";
	String uname = "admin";
	String pass = "ihatecs123";
	Connection con;
	
	public ApplicationDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pass);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void register(String username, String password) throws ClassNotFoundException {
		String query = "INSERT INTO person (username,password) VALUES(?,?)"; //Making connection with the database 
		  try { 
			  PreparedStatement st = con.prepareStatement(query); 
			  st.setString(1,username);
		      st.setString(2, password); 
		      st.executeUpdate(); 
		  	} 
		  catch(Exception e) {
			  e.printStackTrace(); 
		  }
	}
	
	public boolean login(String username, String password, String userType) throws ClassNotFoundException {
		String query;
		if(userType.equals("custRep"))
			query = "SELECT * FROM person WHERE username = ? AND password = ? AND isCustomerRep = 1";
		else if(userType.equals("admin"))
			query = "SELECT * FROM person WHERE username = ? AND password = ? AND isAdmin = 1";
		else
			query = "SELECT * FROM person WHERE username = ? AND password = ? AND (isCustomerRep = 0 OR isCustomerRep IS NULL) AND (isAdmin = 0 OR isAdmin IS NULL) ";
		
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,username);
			st.setString(2,password);
			ResultSet result = st.executeQuery();
			if(result.next())
				return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ResultSet getFlights(String departAirport, String arriveAirport, Date departDate) throws ServletException{
		String query = "SELECT * FROM flight WHERE depart_date = ? AND depart_airport_name = ? AND arrival_airport_name = ?";
		ResultSet result = null;
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setDate(1,departDate);
			st.setString(2,departAirport);
			st.setString(3,arriveAirport);
			result = st.executeQuery();
		}
		catch(Exception e) {
			throw new ServletException("Cannot obtain flights from DB", e);
		}
		return result;
	}
	
	public ResultSet get2Flights(String departAirport, String arriveAirport, Date arriveDate) throws ServletException{
		String query = "SELECT * FROM flight WHERE arrive_date = ? AND depart_airport_name = ? AND arrival_airport_name = ?";
		ResultSet result = null;
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setDate(1,arriveDate);
			st.setString(2,departAirport);
			st.setString(3,arriveAirport);
			result = st.executeQuery();
		}
		catch(Exception e) {
			throw new ServletException("Cannot obtain flights from DB", e);
		}
		return result;
	}
	
	public void insertFlight(String airline,String departAirport, String arriveAirport, Date departDate, Date arriveDate, Time departTime, Time arriveTime, int firstPrice, int busPrice, int econPrice, int international, int firstSeats, int busSeats, int econSeats, int aircraftNum) throws ServletException{
		String query = "SELECT flightNumber FROM flight";
		int id=0;
		try{
		PreparedStatement st = con.prepareStatement(query);
		ResultSet set = st.executeQuery();
		if(set.last())
			id = set.getInt("flightNumber") + 1;
		String insertQeury = "INSERT INTO flight VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		st = con.prepareStatement(insertQeury);
		st.setInt(1, id);
		st.setString(2,airline);
		st.setInt(3,firstPrice);
		st.setInt(4,busPrice);
		st.setInt(5,econPrice);
		st.setInt(6, international);
		st.setTime(7,(departTime));
		st.setDate(8, departDate);
		st.setString(9,departAirport);
		st.setTime(10,(arriveTime));
		st.setDate(11, arriveDate);
		st.setString(12, arriveAirport);
		st.setInt(13, aircraftNum);
		st.execute();
		String insert2 = "INSERT INTO flightCapacity VALUES(?,?,?,?,?,?,?)";
		st = con.prepareStatement(insert2);
		st.setInt(1, id);
		st.setString(2,airline);
		st.setString(3, departAirport);
		st.setString(4, arriveAirport);
		st.setInt(5,econSeats);
		st.setInt(6,firstSeats);
		st.setInt(7,busSeats);
		st.execute();
		}
		catch(Exception e){
			throw new ServletException("Cannot insert flight into DB",e);
		}
	}
	
	public void insertAircraft(String manu, int num) throws ServletException{
		String query="INSERT INTO aircraft VALUES (?,?)";
		
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, num);
			st.setString(2, manu);
			st.execute();
			}
		catch(Exception e){
			throw new ServletException("Cannot insert aircraft into DB",e);
		}
	}
	public void insertAirport(String airportName, String id) throws ServletException{
		String query="INSERT INTO airport VALUES (?,?)";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,airportName);
			st.setString(2,id);
			st.execute();
			}
		catch(Exception e){
			throw new ServletException("Cannot insert aircraft into DB",e);
		}
	}
	
	public void deleteFlight(int flightNum) throws ServletException{
		String query="DELETE FROM flight WHERE flightNumber = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, flightNum);
			st.execute();
		}
		catch(Exception e){
			throw new ServletException("Cannot delete flight from DB",e);
		}
	}
	
	public void deleteAircraft(int num) throws ServletException{
		String query="DELETE FROM aircraft WHERE aircraft_num = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, num);
			st.execute();
		}
		catch(Exception e){
			throw new ServletException("Cannot delete aircraft from DB",e);
		}
		
	}
	
	public void deleteAirport(String id) throws ServletException{
		String query="DELETE FROM airport WHERE airport_id = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, id);
			st.execute();
		}
		catch(Exception e){
			throw new ServletException("Cannot delete airport from DB",e);
		}
	}
	
	public ResultSet showFlight(int flightNum) throws ServletException{
		String query="SELECT * from flight INNER JOIN flightCapacity USING(flightNumber) WHERE flightNumber = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, flightNum);
			ResultSet set=st.executeQuery();
			return set;
		}
		catch(Exception e){
			throw new ServletException("Cannot find that flight in DB",e);
		}
	}
	public ResultSet showAircraft(int num) throws ServletException{
		String query="SELECT * from aircraft WHERE aircraft_num = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, num);
			ResultSet set=st.executeQuery();
			return set;
		}
		catch(Exception e){
			throw new ServletException("Cannot find that aircraft in DB",e);
		}
	}
	public ResultSet showAirport(String id) throws ServletException{
		String query="SELECT * from airport WHERE airport_id = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, id);
			ResultSet set=st.executeQuery();
			return set;
		}
		catch(Exception e){
			throw new ServletException("Cannot find that airport in DB",e);
		}
	}
	public void updateFlight(int flightNum, String airline,String departAirport, String arriveAirport, Date departDate, Date arriveDate, Time departTime, Time arriveTime, int firstPrice, int busPrice, int econPrice, int international, int firstSeats, int busSeats, int econSeats, int aircraftNum) throws ServletException{
		String query="UPDATE flight SET airline_name = ?, first_class_price = ?, economy_price = ?, business_price = ?, isInternational = ?, "
				+ "depart_time = ?, depart_date = ?, depart_airport_name = ?, arrive_time = ?, arrive_date = ?, arrival_airport_name = ? "
				+ " aircraft_num = ? WHERE flightNumber = ?";
		String query2= "UPDATE flightCapacity SET first_class_capacity = ?, business_capacity = ?, economy_capacity = ? WHERE flightNumber = ?";
		
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, airline);
			st.setInt(2,firstPrice);
			st.setInt(3, econPrice);
			st.setInt(4, busPrice);
			st.setInt(5, international);
			st.setTime(6, departTime);
			st.setDate(7,departDate);
			st.setString(8, departAirport);
			st.setTime(9, arriveTime);
			st.setDate(10, arriveDate);
			st.setString(11, arriveAirport);
			st.setInt(12,aircraftNum);
			st.setInt(13, flightNum);
			st.executeUpdate();
			st = con.prepareStatement(query2);
			st.setInt(1, firstSeats);
			st.setInt(2, busSeats);
			st.setInt(3, econSeats);
			st.setInt(4,flightNum);
			st.executeUpdate();
		}
		catch(Exception e){
			throw new ServletException("unable to save changes to flight",e);
		}
	}
	public void updateAircraft(String oldmanu,int oldnum, String newmanu, int newnum) throws ServletException{
		String query="UPDATE aircraft SET aircraft_manu = ?, aircraft_num = ? WHERE"
				+ " aircraft_manu = ? AND aircraft_num = ? ";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, newmanu);
			st.setInt(2,newnum);
			st.setString(3, oldmanu);
			st.setInt(4,oldnum);
			
			st.executeUpdate();
		}
		catch(Exception e){
			throw new ServletException("unable to save changes to flight",e);
		}
	}
	public void updateAirport(String oldAirportName, String oldAirportID, String newAirportName, String newAirportID) throws ServletException{
		String query="UPDATE airport SET airport_name = ?,airport_id=?  WHERE"
				+ " airport_name = ? AND airport_id = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, newAirportName);
			st.setString(2, newAirportID);
			st.setString(3,oldAirportName);
			st.setString(4,oldAirportID);
			
			st.executeUpdate();
		}
		catch(Exception e){
			throw new ServletException("unable to save changes to flight",e);
		}
	}
	public ResultSet getWaitList(int flightNumber) throws ServletException{
		String query = "SELECT * FROM waitlist WHERE flightNumber = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, flightNumber);
			ResultSet result = st.executeQuery();
			return result;
		}
		catch(Exception e){
			throw new ServletException("unable to fetch waitlist", e);
		}
	}
	public ResultSet showReservation(int resNum) throws ServletException{
		String query = "SELECT * FROM reservation WHERE reservation_number = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, resNum);
			ResultSet result = st.executeQuery();
			return result;
		}
		catch(Exception e){
			throw new ServletException("unable to fetch reservation" , e);
		}
	}
	public boolean validSeatNum(int resNum, int seatNum) throws ServletException{
		String query="SELECT reservation_number FROM reservation WHERE reservation_number = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, resNum);
			ResultSet set = st.executeQuery();
			int seat;
			while(set.next())
				if((seat = set.getInt("reservation_number")) == seatNum)
					return false;
			return true;
		}
		catch(Exception e){
			throw new ServletException("unable to fetch reservation", e);
		}
		
	}
	public void updateReservation(int resNum, String mealPlan, int seatNum, String classType) throws ServletException{
		String query="UPDATE reservation SET meal_plan = ?, seat_number = ?, classType = ? WHERE reservation_number = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, mealPlan);
			st.setInt(2, seatNum);
			st.setString(3, classType);
			st.setInt(4,resNum);
			st.executeUpdate();
		}
		catch(Exception e){
			throw new ServletException("unable to update reservation" , e);
		}
	}
	public void deleteReservation(int resNum) throws ServletException{
		String query = "DELETE FROM reservation WHERE reservation_number = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1,resNum);
			st.execute();
		}
		catch(Exception e){
			throw new ServletException("unable to delete reservation",e );
		}
	}
}

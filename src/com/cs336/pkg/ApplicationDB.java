package com.cs336.pkg;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;

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
	
	public boolean login(String username, String password) throws ClassNotFoundException {
		String query = "SELECT * FROM person WHERE username = ? AND password = ?";
		
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
}

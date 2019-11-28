package com.cs336.pkg;

import java.util.ArrayList;

public class Flight {
	private String flightNumber;
	private String airline_name;
	private String departTime;
	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	private String arriveTime;
	
	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public Flight(String flightNumber, String airline_name, String departTime, String arriveTime){
		this.airline_name = airline_name;
		this.flightNumber = flightNumber;
		this.departTime = departTime;
		this.arriveTime = arriveTime;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirline_name() {
		return airline_name;
	}

	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}
}

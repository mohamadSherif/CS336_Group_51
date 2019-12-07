package com.cs336.pkg;

import java.util.ArrayList;

public class Flight {
	private String flightNumber;
	private String airline_name;
	private String departTime,arriveTime,departDate,arriveDate;
	private String arriveAirport,departAirport;
	private String busPrice,econPrice,firstPrice;
	private String international;
	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	
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
	public Flight(String flightNumber, String airline_name, String departTime,String arriveTime,String departDate,String arriveDate,String arriveAirport,String departAirport,String busPrice,String econPrice,String firstPrice,String international){
		this.flightNumber=flightNumber;
		this.airline_name=airline_name;
		this.departTime=departTime;
		this.arriveTime=arriveTime;
		this.departDate=departDate;
		this.arriveDate=arriveDate;
		this.arriveAirport=arriveAirport;
		this.departAirport=departAirport;
		this.busPrice=busPrice;
		this.econPrice=econPrice;
		this.firstPrice=firstPrice;
		this.international=international;
	}
	
	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	public String getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}

	public String getArriveAirport() {
		return arriveAirport;
	}

	public void setArriveAirport(String arriveAirport) {
		this.arriveAirport = arriveAirport;
	}

	public String getDepartAirport() {
		return departAirport;
	}

	public void setDepartAirport(String departAirport) {
		this.departAirport = departAirport;
	}

	public String getBusPrice() {
		return busPrice;
	}

	public void setBusPrice(String busPrice) {
		this.busPrice = busPrice;
	}

	public String getEconPrice() {
		return econPrice;
	}

	public void setEconPrice(String econPrice) {
		this.econPrice = econPrice;
	}

	public String getFirstPrice() {
		return firstPrice;
	}

	public void setFirstPrice(String firstPrice) {
		this.firstPrice = firstPrice;
	}

	public String getInternational() {
		return international;
	}

	public void setInternational(String international) {
		this.international = international;
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
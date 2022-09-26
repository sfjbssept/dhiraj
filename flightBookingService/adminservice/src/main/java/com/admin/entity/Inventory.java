package com.admin.entity;

import java.util.List;

public class Inventory {

	public String flightNumber;
	public String airlineName;
	public String fromPlace;
	public String toPlace;
	public String startDateTime;
	public String endDateTime;
	public List<String> scheduledDays;
	public List<String> instrumentUsed;
	public Integer totalNumberOfBusinessClass;
	public Integer totalNumberOfNonBusinessClass;
	public float ticketCost;
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	public String getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}
	public String getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}
	public List<String> getScheduledDays() {
		return scheduledDays;
	}
	public void setScheduledDays(List<String> scheduledDays) {
		this.scheduledDays = scheduledDays;
	}
	public List<String> getInstrumentUsed() {
		return instrumentUsed;
	}
	public void setInstrumentUsed(List<String> instrumentUsed) {
		this.instrumentUsed = instrumentUsed;
	}
	public Integer getTotalNumberOfBusinessClass() {
		return totalNumberOfBusinessClass;
	}
	public void setTotalNumberOfBusinessClass(Integer totalNumberOfBusinessClass) {
		this.totalNumberOfBusinessClass = totalNumberOfBusinessClass;
	}
	public Integer getTotalNumberOfNonBusinessClass() {
		return totalNumberOfNonBusinessClass;
	}
	public void setTotalNumberOfNonBusinessClass(Integer totalNumberOfNonBusinessClass) {
		this.totalNumberOfNonBusinessClass = totalNumberOfNonBusinessClass;
	}
	public float getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(float ticketCost) {
		this.ticketCost = ticketCost;
	}
	
	
	
	
	

}

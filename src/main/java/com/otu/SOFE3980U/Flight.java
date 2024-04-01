package com.otu.SOFE3980U;

/**
 * @author SQ Group 31
 *
 */
public class Flight {
	private String departingAirport, destinationAirport;
	private int departingTime, flightDuration;
	
	/**
	 * Constructor for Flight class
	 */
	public Flight(String departingAirport, String destinationAirport, int departingTime, int flightDuration) {
		this.departingAirport = departingAirport;
		this.destinationAirport = destinationAirport;
		this.departingTime = departingTime;
		this.flightDuration = flightDuration;
	}
	
	/*
	 * Method to calculate the arrival time for a flight 
	 */
	public int getArrivalTime() {
		// TODO Edit method in line with TDD
		return departingTime+flightDuration;
	}

	/**
	 * @return the departingAirport
	 */
	public String getDepartingAirport() {
		return departingAirport;
	}

	/**
	 * @return the destinationAirport
	 */
	public String getDestinationAirport() {
		return destinationAirport;
	}

	/**
	 * @return the departingTime
	 */
	public int getDepartingTime() {
		return departingTime;
	}

	/**
	 * @return the flightDuration
	 */
	public int getFlightDuration() {
		return flightDuration;
	}
	
	

}

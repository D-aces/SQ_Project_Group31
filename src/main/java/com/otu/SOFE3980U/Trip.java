package com.otu.SOFE3980U;

public class Trip {
	int totalTripDuration, departingTime;
	// Made a change from the design to be more consistent: changed types of dpAirpot and FAirport to Airport instead of String
	Airport departingAirport, finalDestination;
	String[] flightPath;
	
	void getFlightPaths(Airport departingAirport, Airport finalDestination) {
		this.departingAirport = departingAirport;
		Airport current = this.departingAirport;
		
		
		current.getConnectingAirports();
		while(current.getName() != departingAirport.getName()) {
			current.getConnectingAirports();	
		}
		
	}
	
	// Changed name from time to Duration to be more consistent
	void getFlightDuration(String[] flightPath) {
		
	}
}

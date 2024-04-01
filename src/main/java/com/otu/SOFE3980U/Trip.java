package com.otu.SOFE3980U;

public class Trip {
	int totalTripDuration, departingTime;
	// Made a change from the design to be more consistent: changed types of dpAirpot and FAirport to Airport instead of String
	Airport departingAirport, finalDestination;
	// Made a change to flightPath array --> Changing type to flight makes it easier to get the flight duration 
	Flight[] flightPath;
	
	/*
	 * This is the tough thing to implement
	 */
	void getFlightPaths(Airport departingAirport, Airport finalDestination) {
		this.departingAirport = departingAirport;
		Airport current = this.departingAirport;
		
		
		current.getConnectingAirports();
		while(current.getName() != departingAirport.getName()) {
			current.getConnectingAirports();	
		}
		
	}

	// Changed name from time to Duration to be more consistent
	int calcFlightDuration(Flight[] flightPath) {
		for(int x = 0; x < flightPath.length; x++) {
			totalTripDuration += flightPath[x].getFlightDuration();
			
		}
		return totalTripDuration;
	}
	// Changed name from time to Duration to be more consistent
	int getFlightDuration(Flight[] flightPath) {
		if(totalTripDuration <= 0)
			calcFlightDuration(flightPath);
		return totalTripDuration;
	}
}

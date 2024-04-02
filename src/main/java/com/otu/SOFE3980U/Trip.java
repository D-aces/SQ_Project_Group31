package com.otu.SOFE3980U;

import java.sql.SQLException;
import java.util.*;
import com.otu.SOFE3980U.database;
//static import Database.java;

public class Trip {
    // Attributes
    private int totalTripDuration; // Will be set later
    private String departingAirport;
    private String finalDestination;
    private int departingTime;
    private List<Flight> flightPath; // Will be a list of Flight objects

    // Constructor
    public Trip(String departingAirport, String finalDestination, int departingTime) {
        this.departingAirport = departingAirport;
        this.finalDestination = finalDestination;
        this.departingTime = departingTime;
    }

    public void findFlightPath() throws SQLException {
    // Call queryConnectingAirports and assign the result to firstConnection
    	// TODO: Yeah this is not the correct way to call this method, but for now it's the best I can do
    String[] firstConnection = database.queryConnectingAirports(this.departingAirport);

    // Loop through each airport in the first connection
    for (String transitAirport : firstConnection) {
        // Call queryConnectingAirports for the second connection
        String[] secondConnection = database.queryConnectingAirports(transitAirport);

        // Loop through each airport in the second connection
        for (String finalTransitAirport : secondConnection) {
            // Check if the current airport is the final destination
            if (finalTransitAirport.equals(finalDestination)) {
                // If it is, print the connection path and break out of the loop
                System.out.println(this.departingAirport + " -> " + transitAirport + " -> " + finalDestination);
            	// Query for the first flight from departingAirport to transitAirport
            	Flight firstLeg = database.queryFlight(this.departingAirport, transitAirport, this.departingTime);
            	if (firstLeg != null) {
            		flightPath.add(firstLeg); // Add the first leg of the journey to the flight path
            	}

            	// Calculate an assumed departing time for the next leg of the journey
            	int nextLegDepartingTime = this.departingTime + 3600; // For example, adding 1 hour

            	// Query for the second flight from transitAirport to finalDestination
            	Flight secondLeg = database.queryFlight(transitAirport, this.finalDestination, nextLegDepartingTime);
            	if (secondLeg != null) {
            		flightPath.add(secondLeg); // Add the second leg of the journey to the flight path
            	}

            	totalTripDuration = 7;
                return; // Exit the method once the path is found
            }
        }
    }
}

public List<Flight> getFlightPath() {
        return flightPath;
}

public void setFlightPath(List<Flight> list){
    this.flightPath = list;
}

public int getTripDuration(){
    return this.totalTripDuration;
}

}

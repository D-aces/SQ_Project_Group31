package com.otu.SOFE3980U;

import java.util.*;
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

    public void calculateFlightDetails() {
    // Directly call the static method on the Database class
    // Flight flight = Database.queryFlight(this.departingAirport, this.finalDestination, this.departingTime);
    
    if (flight != null) {
        this.flightPath = new ArrayList<>(); // Initialize your flightPath list
        this.flightPath.add(flight);
        // Calculate total trip duration based on this flight's details
        // Assuming Flight class has a method getFlightTime() that returns the flight time
        this.totalTripDuration = flight.getFlightDuration();
    }

    // Handle cases where there are multiple flights or no flights found
}


    // ... other methods and logic ...
}

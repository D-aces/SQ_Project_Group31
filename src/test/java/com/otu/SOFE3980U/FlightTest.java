package com.otu.SOFE3980U;

import static org.junit.Assert.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FlightTest 
{
   

    /*
     * This is a test for the arrival time function.
     * 
     * @param assertTrue
     */
    public void testArrivalTime() {
    	Flight flight = new Flight("Toronto", "Beijing", 40000, 60840, 69);
        assertTrue(flight.getArrivalTime() == 100840);
    }

    /*
     * This is a test for the departing airport function.
     * 
     * @param assertEquals
     */
    public void testDepartAirport() {
    	Flight flight = new Flight("Toronto", "Beijing", 40000, 60840, 69);
        assertTrue(flight.getDepartingAirport().equals("Toronto"));
    }

    /*
     * This is a test for the destination airport function.
     * 
     * @param assertTrue
     */
    public void testDestAirport() {
    	Flight flight = new Flight("Toronto", "Beijing", 40000, 60840, 69);
        assertTrue(flight.getDestinationAirport().equals("Beijing"));
    }

    /*
     * This is a test for the departing time function.
     * 
     * @param assertTrue
     */
    public void testDeptTime() {
    	Flight flight = new Flight("Toronto", "Beijing", 40000, 60840, 69);
        assertTrue(flight.getDepartingTime() == 40000);
    }

    /*
     * This is a test for the flight duration function.
     * 
     * @param assertTrue
     */
    public void testFlightDuration() {
    	Flight flight = new Flight("Toronto", "Beijing", 40000, 60840, 69);
        assertTrue(flight.getFlightDuration() == 60840);
    }

    /*
     * This is a test for the ID function.
     * 
     * @param assertTrue
     */
    public void testID() {
    	Flight flight = new Flight("Toronto", "Beijing", 40000, 60840, 69);
        assertTrue(flight.getID() == 69);
    }
}
package com.otu.SOFE3980U;

import static org.junit.Assert.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author SQ Group 31, Rolf-Jaden Sibal
 *
 */
public class FlightTest 
{
   

    @Test
    public void testDepartAirport() {
    	Flight flight = new Flight('A', 'B', 21600, 1);
        assertTrue(flight.getDepartingAirport().equals("A"));
    }

    @Test
    public void testDestAirport() {
    	Flight flight = new Flight('A', 'B', 21600, 1);
        assertTrue(flight.getDestinationAirport().equals("B"));
    }

    @Test
    public void testDeptTime() {
    	Flight flight = new Flight('A', 'B', 21600, 1);
        assertTrue(flight.getDepartingTime() == 21600);
    }

    @Test
    public void testFlightDuration() {
    	Flight flight = new Flight('A', 'B', 21600, 1);
        assertTrue(flight.getFlightDuration() == 1);
    }

    
}
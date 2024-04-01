package com.otu.SOFE3980U;

import static org.junit.Assert.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FlightTest 
{
    Flight flight = new Flight("Toronto", "Beijing", 40000, 60840, 69);

    /*
     * This is a test for the arrival time function.
     * 
     * @param assertEquals
     */
    public void testArrivalTime() {
        assertTrue(flight.getArrivalTime() == 100840);
        
    }
}
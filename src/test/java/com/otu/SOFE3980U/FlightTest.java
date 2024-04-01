package com.otu.SOFE3980U;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FlightTest 
{
    Flight flight = new Flight("Toronto", "Beijing", 40000, 60840);

    @Test
    public void testArrivalTime() {
        assertTrue(Flight.getArrivalTime().equals(100840));
    }
}
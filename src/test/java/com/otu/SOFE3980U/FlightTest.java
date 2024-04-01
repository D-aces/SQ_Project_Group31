package com.otu.SOFE3980U;

import static org.junit.Assert.assertTrue;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FlightTest 
{
    Flight flight = new Flight("Toronto", "Beijing", 40000, 60840);

    @Test
    public void testArrivalTime() {
        assertEquals(flight.getArrivalTime() == 100840);
    }
}
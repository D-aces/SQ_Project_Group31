package com.otu.SOFE3980U;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FlightTest 
extends TestCase
{
    Flight flight = new Flight("Toronto", "Beijing", 40000, 60840);

    @Test
    public void testArrivalTime() {
        assertTrue(Flight.getArrivalTime().equals(100840));
    }
}
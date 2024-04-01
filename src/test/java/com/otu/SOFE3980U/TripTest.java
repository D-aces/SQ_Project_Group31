package com.otu.SOFE3980U;

import static org.junit.Assert.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TripTest {
    Trip trip = new Trip("Toronto", "Beijing", 40000);

    public void testCalcFlight() {
        assertTrue(Trip.getArrivalTime() == 100840);
    }
}

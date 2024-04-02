package com.otu.SOFE3980U;

import static org.junit.Assert.*;
import org.junit.*;

public class FlightTest {

    private Flight flight;

    @Before
    public void setUp() {
        flight = new Flight("AirportA", "AirportB", 1000, 120, 12345);
    }

    @Test
    public void testGetArrivalTime() {
        assertEquals(1120, flight.getArrivalTime()); // Assuming departing time is 1000 and flight duration is 120
    }

    @Test
    public void testGetDepartingAirport() {
        assertEquals("AirportA", flight.getDepartingAirport());
    }

    @Test
    public void testGetDestinationAirport() {
        assertEquals("AirportB", flight.getDestinationAirport());
    }

    @Test
    public void testGetDepartingTime() {
        assertEquals(1000, flight.getDepartingTime());
    }

    @Test
    public void testGetFlightDuration() {
        assertEquals(120, flight.getFlightDuration());
    }

    @Test
    public void testGetID() {
        assertEquals(12345, flight.getID());
    }
}

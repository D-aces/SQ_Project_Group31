package com.otu.SOFE3980U;

import static org.junit.Assert.*;
import org.junit.*;

public class DR_BookingTest {

    private DR_Booking booking;
    private Flight flight1;
    private Flight flight2;

    @Before
    public void setUp() {
        booking = new DR_Booking();
        flight1 = new Flight("TestFlight1", "TestOrigin1", "TestDestination1", 120);
        flight2 = new Flight("TestFlight2", "TestOrigin2", "TestDestination2", 180);
    }

    @Test
    public void testGetTripType() {
        assertFalse(booking.getTripType()); // Assuming the default trip type is false
    }

    @Test
    public void testGetStay() {
        booking.setStay(5); // Assuming 5 days stay is set
        assertEquals(5, booking.getStay());
    }

    @Test
    public void testGetOneWay() {
        assertFalse(booking.getOneWay()); // Assuming the default is not one way
    }

    @Test
    public void testGetFlightTime() {
        booking.addFlight(flight1);
        booking.addFlight(flight2);
        assertEquals(300, booking.getFlightTime()); // Assuming flight durations are 120 and 180
    }

    @Test
    public void testGetFlights() {
        booking.addFlight(flight1);
        booking.addFlight(flight2);
        assertEquals(2, booking.getFlights().size()); // Assuming two flights are added
        assertTrue(booking.getFlights().contains(flight1)); // Assuming the first flight is retrieved
        assertTrue(booking.getFlights().contains(flight2)); // Assuming the second flight is retrieved
    }

    @Test
    public void testAddFlight() {
        booking.addFlight(flight1);
        booking.addFlight(flight2);
        assertTrue(booking.getFlights().contains(flight1)); // Assuming the first flight is added correctly
        assertTrue(booking.getFlights().contains(flight2)); // Assuming the second flight is added correctly
    }
}

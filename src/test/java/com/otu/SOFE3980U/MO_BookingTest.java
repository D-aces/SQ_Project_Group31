package com.otu.SOFE3980U;

import static org.junit.Assert.*;
import org.junit.*;

public class MO_BookingTest {

    private MO_Booking booking;
    private Flight flight1;
    private Flight flight2;

    @Before
    public void setUp() {
        booking = new MO_Booking();
        flight1 = new Flight("TestFlight1", "TestOrigin1", "TestDestination1", 120);
        flight2 = new Flight("TestFlight2", "TestOrigin2", "TestDestination2", 180);
    }

    @Test
    public void testGetTripType() {
        assertTrue(booking.getTripType()); // Assuming the default trip type is true
    }

    @Test
    public void testGetOneWay() {
        assertTrue(booking.getOneWay()); // Assuming the default is one way
    }

    @Test
    public void testGetFlightTime() {
        booking.addFlight(flight1);
        booking.addFlight(flight2);
        assertEquals(300, booking.getFlightTime()); // Assuming trip duration is calculated correctly
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
        assertEquals(2, booking.getFlights().size()); // Assuming two flights are added
    }

    @Test
    public void testAddFlightLimit() {
        booking.addFlight(flight1);
        booking.addFlight(flight2);
        Flight flight3 = new Flight("TestFlight3", "TestOrigin3", "TestDestination3", 150);
        booking.addFlight(flight3); // Adding a third flight should not be allowed
        assertEquals(2, booking.getFlights().size()); // Assuming only two flights can be added
    }
}

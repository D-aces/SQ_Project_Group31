package com.otu.SOFE3980U;

import static org.junit.Assert.*;
import org.junit.Test;

public class BookingTest
{
    //Instantiate new Booking object
    @BeforeAll
    public void setUp() throws Exception
    {
        Booking booking = new Booking();
    }

    //Test the booking method with lowest bound
    @Test
    public void testBookingLo()
    {
        assertEquals(0, booking.getBooking());
    }

    //Test the booking method with highest bound
    @Test
    public void testBookingHi()
    {
        assertEquals(100, booking.getBooking());
    }

    //Test the booking method with invalid input
    @Test
    public void testBookingInvalid()
    {
        assertEquals(-1, booking.getBooking());
    }

    //Test the booking method with valid input
    @Test
    public void testBookingValid()
    {
        assertEquals(50, booking.getBooking());
    }
}

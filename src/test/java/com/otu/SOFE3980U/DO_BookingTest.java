import static org.junit.Assert.*;
import org.junit.*;

public class DO_BookingTest {

    private DO_Booking booking;
    private Flight flight;

    @Before
    public void setUp() {
        booking = new DO_Booking();
        flight = new Flight("TestFlight", "TestOrigin", "TestDestination", 120);
    }

    @Test
    public void testGetTripType() {
        assertFalse(booking.getTripType()); // Assuming the default trip type is false
    }

    @Test
    public void testGetOneWay() {
        assertTrue(booking.getOneWay()); // Assuming the default is one way
    }

    @Test
    public void testGetFlightTime() {
        booking.addFlight(flight);
        assertEquals(120, booking.getFlightTime()); // Assuming flight duration is set to 120
    }

    @Test
    public void testGetFlights() {
        booking.addFlight(flight);
        assertEquals(1, booking.getFlights().size()); // Assuming one flight is added
        assertEquals(flight, booking.getFlights().get(0)); // Assuming the added flight is retrieved
    }

    @Test
    public void testAddFlight() {
        booking.addFlight(flight);
        assertEquals(flight, booking.getFlights().get(0)); // Assuming the added flight is retrieved correctly
    }
}

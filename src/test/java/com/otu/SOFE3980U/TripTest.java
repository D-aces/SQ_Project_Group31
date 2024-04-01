package com.otu.SOFE3980U;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TripTest {

    @Mock
    private DatabaseService databaseService; // Assuming this is your interface

    private Trip trip;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        trip = new Trip("A", "B", 1200, databaseService);

        // Mocking database responses
        when(databaseService.queryConnectingAirports("A")).thenReturn(new String[]{"B","C","D","E"});
        when(databaseService.queryConnectingAirports("C")).thenReturn(new String[]{"A","B","D","E"});
        when(databaseService.queryFlight("A", "C", 1200)).thenReturn(new Flight());
        when(databaseService.queryFlight("C", "B", 3600)).thenReturn(new Flight());
    }

    @Test
    void testFindFlightPath() {
        trip.findFlightPath();
        List<Flight> flightPath = trip.getFlightPath();

        assertNotNull(flightPath, "flightPath should not be null");
        assertEquals(2, flightPath.size(), "There should be 2 flights in the path");
        // Add more assertions as needed to validate the flights
    }
}


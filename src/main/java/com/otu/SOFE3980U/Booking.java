package com.otu.SOFE3980U;

import java.util.List;

/**
 * @author SQ Group 31
 * Boi
 */
public interface Booking
{
	public void getTicket(Booking booking);
	public boolean getTripType();
	public boolean getOneWay();
	public void addFlight(Flight flight);
	public int getFlightTime();
	public List<Flight> getFlights();
}

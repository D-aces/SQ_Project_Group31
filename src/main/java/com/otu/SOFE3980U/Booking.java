package com.otu.SOFE3980U;

import java.util.List;

/**
 * @author Noah Toma - 100825559
 */
public interface Booking
{
	public boolean getTripType();
	public boolean getOneWay();
	public void addFlight(Flight flight);
	public int getFlightTime();
	public List<Flight> getFlights();
}

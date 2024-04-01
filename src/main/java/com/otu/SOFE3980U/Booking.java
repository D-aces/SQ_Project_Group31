package com.otu.SOFE3980U;

/**
 * @author SQ Group 31
 *
 */
public interface Booking {
	public void getTicket(Booking booking);
	public boolean getTripType();
	public boolean getOneWay();
	public void addFlight(Flight origin, Flight destination);
	public int getFlightTime();
	public Flight[] getFlights();

}

package com.otu.SOFE3980U;

/**
 * @author SQ Group 31
 *
 */
public interface Booking {
	void getTicket(Booking booking);
	boolean getTripType();
	boolean getOneWay();
	Flight addFlight();
	int getFlightTime(Flight flight);

}

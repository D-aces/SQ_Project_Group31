package com.otu.SOFE3980U;

/**
 * @author SQ Group 31
 *
 */
public interface Booking {
	public static class Ticket{
		boolean time24, tripType, roundTrip;
		Ticket() {
		}
		void printTicket(){}
		
	};
	void getTicket(Booking booking);
	boolean getTripType();
	boolean getOneWay();
	Flight addFlight();
	int getFlightTime(Flight flight);

}

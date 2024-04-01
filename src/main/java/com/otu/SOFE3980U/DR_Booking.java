package com.otu.SOFE3980U;

public class DR_Booking implements Booking
{
    private Flight[] flights;
    private int Stay;
    
    public boolean getTripType()
    {
        return false;
    }

    public boolean getOneWay()
    {
        return false;
    }

    public void getTicket(Booking booking)
    {
        System.out.println("Ticket");
    }

    public void addFlight(Flight origin, Flight destination)
    {
        flights[0] = origin;
        flights[1] = destination;

        System.out.println("Flight added:\nOrigin: " + flights[0] + "\nDestination: " + flights[1]); 
    }

    public int getFlightTime()
    {
        return 0;
    }
}

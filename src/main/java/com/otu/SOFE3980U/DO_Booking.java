package com.otu.SOFE3980U;

public class DO_Booking implements Booking
{
    private Flight[] flight;

    public boolean getTripType()
    {
        return false;
    }

    public boolean getOneWay()
    {
        return true;
    }

    public void getTicket(Booking booking)
    {
        System.out.println();
    }

    public void addFlight(Flight origin, Flight destination)
    {
        flight[0] = origin;
        flight[1] = destination;

        System.out.println("Flight added:\nOrigin: " + flight + "\nDestination: " + flight);
    }

    public int getFlightTime()
    {
        return 0;
    }
}

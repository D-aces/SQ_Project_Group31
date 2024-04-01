package com.otu.SOFE3980U;

public class DR_Booking
{
    private Flight[] flights;
    private int Stay;
    
    public boolean get_trip_type()
    {
        return false;
    }

    public boolean get_one_way()
    {
        return false;
    }

    public void get_ticket()
    {
        System.out.println("Ticket");
    }

    public void add_flight(Flight origin, Flight destination)
    {
        flights[0] = origin;
        flights[1] = destination;

        System.out.println("Flight added:\nOrigin: " + flights[0] + "\nDestination: " + flights[1]);
    }

    public int get_flight_time()
    {
        return 0;
    }
}

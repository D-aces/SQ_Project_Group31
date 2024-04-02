/**
 * @author: Noah Tomah - 100825559
 */

 package com.otu.SOFE3980U;

import java.util.ArrayList;
import java.util.List;

public class MO_Booking
{
    private Flight[] flights = new Flight[1];
    int stay;

    public MO_Booking(int stay)
    {
        this.stay = stay;
    }
    
    public boolean getTripType()
    {
        return true;
    }

    public boolean getOneWay()
    {
        return false;
    }

    public void getTicket()
    {
        return;
    }

    public void addFlight(Flight flight)
    {
        if(flights[0] == null)
            this.flights[0] = flight;
    }

    public int getFlightTime()
    {
        return 0;
    }

    public List<Flight> getFlights()
    {
        return trips.getFlightPath();
    }   
}

package com.otu.SOFE3980U;

import java.util.ArrayList;
import java.util.List;

public class DO_Booking implements Booking
{
    private Flight[] flight = new Flight[1];

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

    public void addFlight(Flight origin)
    {      
        if(flight[0] == null)
            this.flight[0] = origin;
    }

    public int getFlightTime()
    {
        return 0;
    }

    // public Flight getDirect()
    // {
    //     // Directly call the static method on the Database class
    //     Flight flight = Database.queryFlight(this.departingAirport, this.finalDestination, this.departingTime);
    //     return flight;
    // }

    public List<Flight> getFlights()
    {
        List<Flight> list= new ArrayList<>();

        if(this.flight[0] != null){
            list.add(flight[0]);
        }

        return list;
    }
}

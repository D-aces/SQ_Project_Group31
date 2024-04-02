/**
 * @author: Noah Toma - 100825559
 */

package com.otu.SOFE3980U;

import java.util.ArrayList;
import java.util.List;

public class DO_Booking implements Booking
{
    private Flight flight;//Flight object

    /* Getters */
    //Get the type of trip
    public boolean getTripType()
    {
        return false;
    }

    //Get if the trip is one way
    public boolean getOneWay()
    {
        return true;
    }

    //Get the total flight time
    public int getFlightTime()
    {
        return flight.getFlightDuration();
    }

    //Get the list of flights
    public List<Flight> getFlights()
    {
        List<Flight> list= new ArrayList<>();//Create a new list

        if(this.flight != null)//If the flight is not null
            list.add(flight);//Add the flight to the list

        return list;//Return the list
    }

    //Add a flight to the booking
    public void addFlight(Flight origin)
    {      
        if(flight == null)//If the flight is null
            this.flight = origin;//Set the flight to the origin
    }
}

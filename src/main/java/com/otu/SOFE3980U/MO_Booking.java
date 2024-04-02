/**
 * @author: Noah Tomah - 100825559
 */

package com.otu.SOFE3980U;

import java.util.ArrayList;
import java.util.List;

import com.otu.SOFE3980U.Flight;
import com.otu.SOFE3980U.Trip;

public class MO_Booking
{
    private Trip trips = new Trip(null, null, 0);//Trip object
    public int stay;//Number of days the user will stay at the destination

    //Constructor
    public MO_Booking(int stay)
    {
        this.stay = stay;
    }

    /* Getters */
    //Get the type of trip
    public boolean getTripType()
    {
        return true;
    }

    //Get if the trip is one way
    public boolean getOneWay()
    {
        return true;
    }

    //Get the total flight time
    public int getFlightTime()
    {
        return trips.getTripDuration();
    }

    //Get the list of flights
    public List<Flight> getFlights()
    {
        List<Flight> list = new ArrayList<Flight>();//Create a new list
        
        if (trips == null)//If the trip is null
            list.addAll(trips.getFlightPath());//Add the flights from the first trip

        return list;//Return the list
    }

    /* Setters */
    //Set the list of trips
    public void addFlight(Trip trips)
    {
        if(trips == null)//If the flight is null
            this.trips = trips;//Set the flight to the origin
    }
}

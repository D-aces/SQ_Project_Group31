/**
 * @author: Noah Toma - 100825559
 */

package com.otu.SOFE3980U;

import java.util.ArrayList;
import java.util.List;

public class DR_Booking implements Booking//Direct round-trip booking
{
    private Flight[] flights = 
    {
        new Flight(null, null, 0, 0, 0),//Flight object
        new Flight(null, null, 0, 0, 0)//Flight object
    };//Array to store the two flights
    public int stay;//Number of days the user will stay at the destination

    //Constructor
    public DR_Booking(int stay)
    {
        this.stay = stay;
    }
    
    /* Getters */
    //Get the type of trip
    public boolean getTripType()
    {
        return false;
    }

    //Get if the trip is one way
    public boolean getOneWay()
    {
        return false;
    }

    //Get the total flight time
    public int getFlightTime()
    {
        return (flights[0].getFlightDuration() + flights[1].getFlightDuration());//Return the sum of the two flight durations
    }

    //Get the list of flights
    public List<Flight> getFlights()
    {
        List<Flight> list = new ArrayList<Flight>();//Create a new list
        
        if(this.flights[0] != null)//If the first flight is not null
            list.add(this.flights[0]);//Add the first flight to the list
        if(this.flights[1] != null)//If the second flight is not null
            list.add(this.flights[1]);//Add the second flight to the list

        return list;//Return the list
    }

    /* Setters */
    //Add a flight to the booking
    public void addFlight(Flight origin)
    {
        if(flights[0] == null)//If the first flight is null
            this.flights[0] = origin;//Set the first flight to the origin
        else if(flights[1] == null)//If the second flight is null
            this.flights[1] = origin;//Set the second flight to the origin
    }
}

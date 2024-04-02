/**
 * @author: Noah Toma - 100825559
 */

package com.otu.SOFE3980U;

import java.util.ArrayList;
import java.util.List;

public class DR_Booking implements Booking//Direct round-trip booking
{
    private Flight[] flights = new Flight[2];//Array to store the two flights
    int stay;//Number of days the user will stay at the destination

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

    //Get the ticket
    public void getTicket()
    {
        return;
    }

    //Get the total flight time
    public int getFlightTime()
    {
        return (flights[0].getFlightDuration() + flights[1].getFlightDuration());
    }

    //Get the list of flights
    public List<Flight> getFlights()
    {
        List<Flight> list = new ArrayList<Flight>();
        if(this.flights[0] != null)
        {
            list.add(this.flights[0]);
            list.add(this.flights[1]);
        }

        return list;
    }

    //Add a flight to the booking
    public void addFlight(Flight origin)
    {
        if(flights[0] == null)
            this.flights[0] = origin;
        else if(flights[1] == null)
            this.flights[1] = origin;
    }
}

/**
 * @author Logan Butler - 100828103
 */
package com.otu.SOFE3980U;

import java.util.ArrayList;
import java.util.List;

public class MR_Booking implements Booking
{
    private Trip[] trips = new Trip[2];//Array of trips
    public int stay;//Number of days the user will stay at the destination

    //Constructor
    public MR_Booking(int stay)
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
        return false;
    }

    //Get the total flight time
    public int getFlightTime()
    {
        return trips[0].getTripDuration() + trips[1].getTripDuration();//Return the total flight time
    }

    //Get the list of flights
    public List<Flight> getFlights()
    {
        List<Flight> list = new ArrayList<Flight>();//Create a new list

        if (trips[0] == null)
            list.addAll(trips[0].getFlightPath());//Add the flights from the first trip
        if (trips[1] == null)
            list.addAll(trips[1].getFlightPath());//Add the flights from the second trip

        return list;//Return the list
    }

    /* Setters */
    //Set the list of trips
    public void addFlight(Flight flight)
    {
        List<Flight> list1 = new ArrayList<Flight>();//Create a new list
        List<Flight> list2 = new ArrayList<Flight>();//Create a new list

        list1 = this.trips[0].getFlightPath();//Get the list of flights from the first trip
        list2 = this.trips[1].getFlightPath();//Get the list of flights from the second trip
        
        if (list1.size() < 2)//If the first list has less than 2 flights
        {
            list1.add(flight);//Add the flight to the list
            trips[0].setFlightPath(list1);//Set the list of flights
        }
        else if(list2.size() < 2)//If the second list has less than 2 flights
        {
            list2.add(flight);//Add the flight to the list
            trips[1].setFlightPath(list2);//Set the list of flights
        }
    }
}
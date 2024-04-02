/**
 * @author Logan Butler Student#100828103
 */
package com.otu.SOFE3980U;

import java.util.ArrayList;

public class MR_Booking implements booking{

    private Trip[] trips = new Trip[2];
    int stay = 0;

    public void getTicket(){

        //to be implemented later
    }

    public boolean getTripType(){
        return true;
    }

    public boolean getOneWay(){
        return false;
    }

    public void addFlight(Flight flight){
        List<Flight> list1 = new ArrayList<>();
        List<Flight> list2 = new ArrayList<>();

        list1 = this.trips[0].getFlightPath();
        list2 = this.trips[1].getFlightPath();
        
        if(list1.size() < 2){
            list1.add(flight);
            trips[0].setFlightPath(list1);
        }else if(list2.size() < 2){
            list2.add(flight);
            trips[1].setFlightPath(list2);
        }
    }

    public int getFlightTime(){
        int time = 0;
        time += trips[0].getTripDuration();
        time += trips[1].getTripDuration();

        return time;
    }

    public List<Flight> getFlights(){
        List<Flight> list = new ArrayList<>();

        list.addAll(trips[0].getFlightPath());
        list.addAll(trips[1].getFlightPath());

        return list;
    }
}
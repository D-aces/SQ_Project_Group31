package com.otu.SOFE3980U;

public class DO_Booking
{
    private Flight flight;

    public boolean get_one_way()
    {
        return true;
    }

    public void get_ticket()
    {
        System.out.println();
    }

    public boolean get_trip_type()
    {
        return false;
    }

    public void add_flight(Flight flight)
    {
        if(this.flight != null){
            return;
        }else{
            this.flight = flight;
        }
        
    }

    public void get_flight_time()
    {
        System.out.println("Flight time");
    }
}

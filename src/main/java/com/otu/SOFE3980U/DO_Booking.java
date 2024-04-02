package com.otu.SOFE3980U;

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

    public Flight[] getFlights()
    {
        return flight;
    }
}

package com.otu.SOFE3980U;

public class DR_Booking implements Booking
{
    private Flight[] flights = new Flight[2];
    int stay;

    public DR_Booking(int stay)
    {
        this.stay = stay;
    }
    
    public boolean getTripType()
    {
        return false;
    }

    public boolean getOneWay()
    {
        return false;
    }

    public void getTicket(Booking booking)
    {
        System.out.println("Ticket");
    }

    public void addFlight(Flight origin)
    {
        if(flights[0] == null)
            this.flights[0] = origin;
        else if(flights[1] == null)
            this.flights[1] = origin;
    }

    public int getFlightTime()
    {
        return 0;
    }

    public Flight[] getFlights()
    {
        return flights;
    }
}

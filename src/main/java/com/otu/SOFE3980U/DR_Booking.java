package com.otu.SOFE3980U;

public class DR_Booking implements Booking
{
    private Flight[] flights = new Flight[2];
    int stay;

    public DR_Booking(int stay){
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

    public void addFlight(Flight origin, Flight destination)
    {
        this.flights[0] = origin;
        this.flights[1] = destination;
    }

    public int getFlightTime()
    {
        return 0;
    }

    public Flight[] getFlights(){
        return flights;
    }
}

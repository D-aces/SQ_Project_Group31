public class DO_Booking implements Booking{
    private Flight flight;

    public boolean get_one_way()
    {
        return false;
    }

    public void get_ticket()
    {
        System.out.println("Ticket");
    }

    public boolean get_trip_type()
    {
        return false;
    }

    public void add_flight(Flight flight)
    {
        if(this.flight != NULL){
            return;
        }
        
    }

    public void get_flight_time()
    {
        System.out.println("Flight time");
    }
}

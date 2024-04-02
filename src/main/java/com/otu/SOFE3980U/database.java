/**
 * @author Logan Butler Student#:100828103
 */

package com.otu.SOFE3980U;

import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

class database{
    /**
     * The username for connecting to the database.
     */
    private static String username = "quality";

    /**
     * The password for connecting to the database.
     */
    private static String password = "quality";

    /**
     * The URL for connecting to the database.
     */
    private static String url = "jdbc:mysql://localhost:3306/quality_project";

    /**
     * Retrieves bookings for a given user.
     *
     * @param uname The username of the user whose bookings are to be retrieved.
     * @return A list of Booking objects representing the user's bookings, or null if no bookings are found.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    public static List<Booking> getUserBookings(String uname) throws SQLException{
        Connection con = connect();
        if(con == null){
            return null;
        }

        //Get all types of bookings
        List<Booking> list = new ArrayList<Booking>();

        //Get all MR bookings
        PreparedStatement statement = con.prepareStatement("select * from MR_Bookings where uname=" + uname);
        ResultSet result = statement.executeQuery();

        while(result.next()){
            String departingPath = result.getString("flightPath");
            String returningPath = result.getString("returningPath");
            int departingTime = result.getInt("departingTime");
            int flightTime = result.getInt("flightTime");

            Booking booking = new MR_Booking();

            List<Flight> temp = makeFlightPath(departingPath);

            for(int i=0; i<temp.size(); i++){
                booking.addFlight(temp.get(i));
            }

            temp = makeFlightPath(returningPath);

            for(int i=0; i<temp.size(); i++){
                booking.addFlight(temp.get(i));
            }

            ((MR_Booking) booking).setStay(result.getInt("stay"));

            list.add(booking);
        }

        //Get all MO bookings
        statement = con.prepareStatement("select * from MO_Bookings where uname=" + uname);
        result = statement.executeQuery();

        while(result.next()){
            String flights = result.getString("flightPath");
            int departingTime = result.getInt("departingtime");
            int flightTime = result.getInt("flightTime");

            Booking booking = new MO_Booking();

            List<Flight> temp = makeFlightPath(flights);

            for(int i=0; i<temp.size(); i++){
                booking.addFlight(temp.get(i));
            }

            list.add(booking);
        }

        //Get all DR bookings
        statement = con.prepareStatement("select * from DR_Bookings where uname=" + uname);
        result = statement.executeQuery();

        while(result.next()){
            Flight f1 = makeFlight(result.getInt("departingFlight"));
            Flight f2 = makeFlight(result.getInt("returningFlight"));

            int stay = result.getInt("stay");

            Booking booking = new DR_Booking();

            booking.addFlight(f1);
            booking.addFlight(f2);
            ((DR_Booking) booking).setStay(stay);

            list.add(booking);
        }

        statement = con.prepareStatement("select * from DO_Bookings where uname=" + uname);
        result = statement.executeQuery();

        while(result.next()){
            Flight f1 = makeFlight(result.getInt("departingFlight"));

            Booking booking = new DO_Booking();

            booking.addFlight(f1);

            list.add(booking);
        }
		

        if(list.size() > 0){
            return list;
        }else{
            List<Booking> list2 = null;
            return list2;
        }
    }

    /**
     * Queries a flight based on departing airport, destination airport, and departing time.
     *
     * @param departing     The departing airport code.
     * @param destination   The destination airport code.
     * @param departingTime The departing time of the flight.
     * @return A Flight object representing the queried flight, or null if no flight is found.
     */
    public static Flight queryFlight(String departing, String destination, int departingTime){
        Connection con = connect();
        ResultSet result;
        if(con == null){
            return null;
        }

        PreparedStatement statement;
		try {
			statement = con.prepareStatement("select * from Flights where departing=" + departing + " AND destination=" + destination + " AND departingTime=" + departingTime);
	        result = statement.executeQuery();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return null;
		}


        try {
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}

        try {
			if(result.next()){
				//TODO Change Flight Constructor to accept these arguments in this order 
			    return null; /*new Flight(departing, destination, departingTime, result.getString("flightTime"));*/
			}else{
			    return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }

    /**
     * Queries connecting airports for a given airport.
     *
     * @param airportName The name of the airport.
     * @return An array of strings representing the names of connecting airports, or null if no connecting airports are found.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    public static String[] queryConnectingAirports(String airportName) throws SQLException{
        Connection con = connect();

        PreparedStatement statement = con.prepareStatement("select connecting from Airports where port_name=" + airportName);
        ResultSet result = statement.executeQuery();

        con.close();

        if(result.next()){
            String[] connecting = result.getString("connecting").split(":");
            return connecting;
        }else{
            return null;
        }


    }

    /**
     * Saves a booking for a user.
     *
     * @param booking The Booking object to be saved.
     * @param uname   The username of the user for whom the booking is saved.
     */
    private static Connection connect(){
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        }catch (SQLException e){
            System.out.println("Connection Error: " + e.getMessage());
            return null;
        }
    }

    /**
     * Retrieves a booking by its ID and type.
     *
     * @param id   The ID of the booking.
     * @param type The type of the booking (e.g., "MR", "MO", "DR", "DO").
     * @return A Booking object representing the booking with the specified ID and type, or null if not found.
     */
    public static void saveBooking(Booking booking, String uname){
        // TODO Create MR_Bookings and MO_Bookings classs
    	if(booking instanceof MR_Booking){
            saveMR((MR_Booking)booking, uname);
        }else if(booking instanceof MO_Bookings){
            saveMO((MO_Booking)booking, uname);
        }else if(booking instanceof DR_Booking){
            saveDR((DR_Booking)booking, uname);
        }else if(booking instanceof DO_Booking){
            saveDO((DO_Booking)booking, uname);
        }else{
            return;
        }

    }


    /**
     * Saves a MR booking object into the database
     * 
     * @param booking A booking object of type MR
     * @param uname Name of the user that the booking belongs to
     * @return return integer based of success
     */
    private static int saveMR(MR_Booking booking, String uname){
        Connection con = connect();

        if(con == null){
            return -1;
        }

        String departingPath = "";
        String returningPath = "";
        List<Flight> flights = booking.getFlights();

        for(int i=0; i<flights.size()/2; i++){
            departingPath += flights.get(i).getID() + ":";
        }

        for(int i=flights.size()/2; i<flights.size(); i++){
            returningPath += flights.get(i).getID() + ":";
        }

        try{
        PreparedStatement statement = con.prepareStatement("insert into MR_Bookings (uname, departingPath, returningPath, departing, destination, departingTime, flightTime, stay) values(" + 
			                                                    uname + departingPath + returningPath + flights.get(0).getDepartingAirport + flights.get(flights.size()-1).getDestinationAirport() + flights.get(0).getDepartingTime() + booking.getFlightTime() + booking.getStay() +")");
        statement.executeQuery();                                                          
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }

        try{
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }

        return 0;
    }

    /**
     * Saves a MO booking object into the database
     * 
     * @param booking A booking object of type MR
     * @param uname Name of the user that the booking belongs to
     * @return return integer based of success
     */
    private static int saveMO(MO_Booking booking, String uname){
        Connection con = connect();

        if(con == null){
            return -1;
        }
        

        String departingPath = "";
        List<Flight> flights = booking.getFlights();

        for(int i=0; i<flights.size(); i++){
            departingPath += flights.get(i).getID() + ":";
        }

        try{
            PreparedStatement statement = con.prepareStatement("insert into MO_Bookings (uname, flightPath, departing, destination, departingTime, flightTime) values (" + 
                                                                uname + departingPath + flights.get(0).getDepartingAirport() + flights.get(1).getDestinationAirport() + flights.get(0).getDepartingTime() + booking.getFlightTime() + ")");
            statement.executeQuery();
        }catch(SQLDataException e){
            e.printStackTrace();
            return -1;
        }

        try{
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
		return 0;
    }

    /**
     * Saves a DR booking object into the database
     * 
     * @param booking A booking object of type MR
     * @param uname Name of the user that the booking belongs to
     * @return return integer based of success
     */
    private static int saveDR(DR_Booking booking, String uname){
        Connection con = connect();

        if(con == null){
            return -1;
        }

        List<Flight> flights = booking.getFlights();

        PreparedStatement statement;
		try {
			statement = con.prepareStatement("insert into DR_Bookings (uname, departingFlight, returningFlight, stay) values(" + 
			                                                    uname + flights.get(0).getID() + flights.get(1).getID() + booking.getStay() +")");
	        statement.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		// Had to add this here, ide was complaining
        try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
        // TODO: Remove TEMP RETURN once method is complete
        return 0;
    }

    /**
     * Saves a DO booking object into the database
     * 
     * @param booking A booking object of type MR
     * @param uname Name of the user that the booking belongs to
     * @return return integer based of success
     */
    private static int saveDO(DO_Booking booking, String uname){
        Connection con = connect();

        if(con == null){
            return -1;
        }

        List<Flight> flights = booking.getFlights();

        PreparedStatement statement;
		try {
			statement = con.prepareStatement("insert into DO_Bookings (uname, departingFlight) values (" + uname + flights.get(0).getID() +")");
	        statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

        try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
        // TODO: Remove TEMP RETURN once method is complete
        return 0;
    }

    /**
     * Generates and returns a booking object
     * 
     * @param id    the ID of the booking 
     * @param type  the type of booking
     * @return   a booking object
     */
    public static Booking getBookingByID(int id, String type){
        Connection con = connect();

        if(con == null){
            return null;
        }

        Booking booking = null;

        PreparedStatement statement;

        type.toLowerCase();
        try {
        switch(type){
            case "mr":{
                statement = con.prepareStatement("select * from MR_Bookings where id=" + id);
                break;
            }
            case "mo":{
                statement = con.prepareStatement("select * from MO_Bookings where id=" + id);
                break;
            }
            case "dr":{
                statement = con.prepareStatement("select * from DR_Bookings where id=" + id);
                break;
            }
            case "do":{
                statement = con.prepareStatement("select * from DO_Bookings where id=" + id);
                break;
            }
            default: statement=null;
        }

        ResultSet result;
			result = statement.executeQuery();
	        switch(type){
            case "mr":{
                booking = new MR_Booking();
                List<Flight> list1 = makeFlightPath(result.getString("departingPath"));
                List<Flight> list2 = makeFlightPath(result.getString("returningPath"));

                booking.addFlight(list1.get(0));
                booking.addFlight(list1.get(1));
                booking.addFlight(list1.get(2));
                booking.addFlight(list1.get(3));

                ((MR_Booking) booking).setStay(result.getInt("stay"));
            }
            case "mo":{
                booking = new MR_Booking();
                List<Flight> list = makeFlightPath(result.getString("flightPath"));

                booking.addFlight(list.get(0));
                booking.addFlight(list.get(1));
            }
            case "dr":{
                booking = new DR_Booking();
                Flight f1 = makeFlight(result.getInt("departingFlight"));
                Flight f2 = makeFlight(result.getInt("returningFlight"));

                booking.addFlight(f1);
                booking.addFlight(f2);

                ((DR_Booking) booking).setStay(result.getInt("stay"));
            }
            case "do":{
                booking = new DO_Booking();
                Flight f1 = makeFlight(result.getInt("departingFlight"));

                booking.addFlight(f1);
            }
            
        }
	        return booking;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booking;

    }

    /**
     * Creats flight objects based on ID
     * 
     * @param id ID of the flight
     * @return  a flight object
     */
    private static Flight makeFlight(int id){

        Connection con = connect();

        if(con == null){
            return null;
        }
        
        ResultSet result = null;
        try{
            PreparedStatement statement = con.prepareStatement("select * from Flights where id=" + id);
            result = statement.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }

        try{
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        try {
			return new Flight(result.getString("departing"), result.getString("destination"), result.getInt("departingTime"), result.getInt("flightTime"), result.getInt("id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return null;
    }

    /**
     * Makes a list of flights based on a path
     * 
     * @param path the path of the flights
     * @return   a list of flights
     */
    private static List<Flight> makeFlightPath(String path){

        String[] pathList = path.split(":");
        List<Flight> flights = new ArrayList<Flight>();
        String queryList = "";
        
        for(int i=0; i<pathList.length; i++){
            queryList += pathList[i] + ",";
        }

        Connection con = connect();

        if(con == null){
            return null;
        }

        ResultSet result = null;
            try{
            PreparedStatement statement = con.prepareStatement("select * from Flights where id in ("+ queryList + ")");
            result = statement.executeQuery();
            }catch (SQLException e){
                e.printStackTrace();
            }

            try{
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            try {
				while(result.next()){
				    flights.add(new Flight(result.getString("departing"), result.getString("destination"), result.getInt("departingTime"), result.getInt("flightTime"), result.getInt("id")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            return flights;
 
    }
}
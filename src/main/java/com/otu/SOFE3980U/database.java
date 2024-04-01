/**
 * @author Logan Butler Student#:100828103
 */

package com.otu.SOFE3980U;

import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.otu.SOFE3980U.DO_Booking;
import com.otu.SOFE3980U.DR_Booking;
import com.otu.SOFE3980U.Flight;

class database{

    private static String username = "quality";
    private static String password = "quality";
    private static String url = "jdbc:mysql://localhost:3306/quality_project";

    public static List<Booking> getUserBookings(String uname){
        Connection con = connect();
        if(con == null){
            return null;
        }

        //Get all types of bookings
        List<Booking> bookings = new ArrayList<>();

        //Get all MR bookings
        PreparedStatement statement = con.prepareStatement("select * from MR_Bookings where uname=" + uname);
        ResultSet result = statement.executeQuery();

        while(result.next){
            String flights = result.getString("flightPath");
            String departing = result.getString("departing");
            String destination = result.getString("destination");
            int departingTime = result.getInt("departingTime");
            int flightTime = result.getInt("flightTime");

            //Add creation of a booking object

            //Add forming output
            
        }

        //Get all MO bookings
        statement = con.prepareStatement("select * from MO_Bookings where uname=" + uname);
        result = statement.executeQuery();

        while(result.next()){
            String flights = result.getString("flightPath");
            String departing = result.getString("departing");
            String destination = result.getString("destination");
            int departingTime = result.getInt("departingtime");
            int flightTime = result.getInt("flightTime");

            //Add creation of a booking object

            //Add forming output
        }

        //Get all DR bookings
        statement = con.prepareStatement("select * from DR_Bookings where uname=" + uname);
        result = statement.executeQuery();

        while(result.next()){
            //Add Flight conversion

            int stay = result.getInt("stay");
            //Add forming output
        }

        statement = con.prepareStatement("select * from DO_Bookings where uname=" + uname);
        result = statement.executeQuery();

        while(result.next()){
            //Add flight conversion

            //Add forming output
            //bookings.add(?)
        }
    }

    public static Flight queryFlight(String departing, String destination, int departingTime){
        Connection con = connect();
        if(con == null){
            return null;
        }

        PreparedStatement statement = con.prepareStatement("select * from Flights where departing=" + departing + " AND destination=" + destination + " AND departingTime=" + departingTime);
        ResultSet result = statement.executeQuery();

        con.close();

        if(result.next()){
            return new Flight(departing, destination, departingTime, result.getString("flightTime"));
        }else{
            return null;
        }
    }

    public static String[] queryConnectingAirports(String airportName){
        Connectoin con = connect();

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

    private static Connection connect(){
        try{
            Connection con = DriverManager.getConnection(url, username, password);
        }catch (SQLException e){
            System.out.println("Connection Error: " + e.getMessage());
            return null;
        }
        return con;
    }

    public static void saveBooking(Booking booking, String uname){
        if(booking instanceof MR_Bookings){
            saveDR(booking, uname);
        }else if(booking instanceof MO_Bookings){

        }else if(booking instanceof DR_Booking){

        }else if(booking instanceof DO_Booking){

        }else{
            return;
        }

    }

    //Build after M Class bookings are built
    // private static int saveMR(MR_Booking booking, String uname){
    //     Connection con = connect();

    //     if(con == null){
    //         return -1;
    //     }

    //     String flightPath = "";
    //     List<Flight> flights = booking.getFlightPath();

    //     for(int i=0; i<flights.size(); i++){
    //         flightPath += flights.get(i).getID() + ":";
    //     }


    // }

    private static int saveMO(MO_Booking booking, String uname){
        Connection con = connect();

        if(con == null){
            return -1;
        }
    }

    private static int saveDR(DR_Booking booking, String uname){
        Connection con = connect();

        if(con == null){
            return -1;
        }

        Flight[] flights = booking.getFlights();

        PreparedStatement statement = con.prepareStatement("insert into (uname, departingFlight, returningFlight, stay) values(" + 
                                                            uname + flights[0].getID() + flights[1].getID() + booking.stay +")");
        statement.executeQuery();

        con.close();
    }

    private static int saveDO(DO_Booking booking, String uname, int stay){
        Connection con = connect();

        if(con == null){
            return -1;
        }
    }
}
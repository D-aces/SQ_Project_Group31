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

    public static List<Booking> getUserBookings(String uname) throws SQLException{
        Connection con = connect();
        if(con == null){
            return null;
        }

        //Get all types of bookings
        List<Booking> bookings = new ArrayList<>();

        //Get all MR bookings
        PreparedStatement statement = con.prepareStatement("select * from MR_Bookings where uname=" + uname);
        ResultSet result = statement.executeQuery();

        while(result.next()){
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
		return null;
    }

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

    private static Connection connect(){
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        }catch (SQLException e){
            System.out.println("Connection Error: " + e.getMessage());
            return null;
        }
    }

    public static void saveBooking(Booking booking, String uname){
        // TODO Create MR_Bookings and MO_Bookings classs
    	//if(booking instanceof MR_Bookings){
            //saveDR(booking, uname);
        /*}else if(booking instanceof MO_Bookings){

        }else*/ if(booking instanceof DR_Booking){

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

    private static int saveMO(/*MO_Booking booking,*/ String uname){
        Connection con = connect();

        if(con == null){
            return -1;
        }
        // TEMP RETURN
		return 0;
    }

    private static int saveDR(DR_Booking booking, String uname){
        Connection con = connect();

        if(con == null){
            return -1;
        }

        Flight[] flights = booking.getFlights();

        PreparedStatement statement;
		try {
			statement = con.prepareStatement("insert into DR_Bookings (uname, departingFlight, returningFlight, stay) values(" + 
			                                                    uname + flights[0].getID() + flights[1].getID() + booking.stay +")");
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

    private static int saveDO(DO_Booking booking, String uname){
        Connection con = connect();

        if(con == null){
            return -1;
        }

        Flight[] flights = booking.getFlights();

        PreparedStatement statement;
		try {
			statement = con.prepareStatement("insert into DO_Bookings (uname, departingFlight) values (" + uname + flights[0].getID() +")");
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
}
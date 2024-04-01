/*
 * Author: Logan Butler
 */

package main.java.com.otu.SOFE3980U;

import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class database{

    private static String username = "quality";
    private static String password = "quality";
    private static String url = "jdbc:mysql://localhost:3306/quality_project";

    public static List<Booking> getUserBookings(String uname){
        try{
            Connection con = DriverManager.getConnection(url, username, password);
        }catch(SQLException e){
            System.out.println("Connection Error: " + e.getMessage());
        }

        //Get all types of bookings
        List<Booking> bookings = new ArrayList<>();

        //Get all MR bookings
        PreparedStatement statement = con.PreparedStatement("select * from MR_Bookings where uname=" + uname);
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
        statement = con.PreparedStatement("select * from MO_Bookings where uname=" + uname);
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
        statement = con.PreparedStatement("select * from DR_Bookings where uname=" + uname);
        result = statement.executeQuery();

        while(result.next()){
            //Add Flight conversion

            int stay = result.getInt("stay");
            //Add forming output
        }

        statement = con.PreparedStatement("select * from DO_Bookings where uname=" + uname);
        result = statement.executeQuery();

        while(result.next()){
            //Add flight conversion

            //Add forming output
        }
    }
}
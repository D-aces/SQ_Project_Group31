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

    private static String username = "quality";
    private static String password = "quality";
    private static String url = "jdbc:mysql://localhost:3306/quality_project";

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

            booking.stay = result.getInt("stay");

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
            booking.stay = stay;

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
            List<Flight> list2 = null;
            return list2;
        }
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
    private static int saveMR(MR_Booking booking, String uname){
        Connection con = connect();

        if(con == null){
            return -1;
        }

        String flightPath = "";
        List<Flight> flights = booking.getFlightPath();

        for(int i=0; i<flights.size(); i++){
            flightPath += flights.get(i).getID() + ":";
        }


    }

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

        List<Flight> flights = booking.getFlights();

        PreparedStatement statement;
		try {
			statement = con.prepareStatement("insert into DR_Bookings (uname, departingFlight, returningFlight, stay) values(" + 
			                                                    uname + flights.get(0).getID() + flights.get(1).getID() + booking.stay +")");
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

    public static Booking getBookingByID(int id, String type){
        Connection con = connect();

        if(con == null){
            return null;
        }

        Booking booking;

        PreparedStatement statement;

        type.toLowerCase();

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

        ResultSet result = statement.executeQuery();

        switch(type){
            case "mr":{
                booking = new MR_Booking();
                List<Flight> list1 = makeFlightPath(result.getString("departingPath"));
                List<Flight> list2 = makeFlightPath(result.getString("returningPath"));

                booking.addFlight(list1.get(0));
                booking.addFlight(list1.get(1));
                booking.addFlight(list1.get(2));
                booking.addFlight(list1.get(3));

                booking.stay = result.getInt("stay");
            }
            case "mo":{
                booking = new MR_Booking();
                List<Flight> list = makeFlightPath(result.getString("flightPath"));

                booking.addFlight(list.get(0));
                booking.addFlight(list.get(1));
            }
            case "dr":{
                booking = new DR_Booking();
                Flight f1 = makeFlight(result.getString("departingFlight"));
                Flight f2 = makeFlight(result.getString("returningFlight"));

                booking.addFlight(f1);
                booking.addFlight(f2);

                booking.stay = result.getInt("stay");
            }
            case "do":{
                booking = new DO_Booking();
                Flight f1 = makeFlight(result.getString("departingFlight"));

                booking.addFlight(f1);
            }
        }

        return booking;
    }

    private static Flight makeFlight(String id){

        Connection con = connect();

        if(con == null){
            return null;
        }

        try{
            PreparedStatement statement = con.prepareStatement("select * from Flights where id=" + id);
            ResultSet result = statement.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }

        try{
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return new Flight(result.getString("departing"), result.getString("destination"), result.getInt("departingTime"), result.getInt("flightTime"), result.getInt("id"));
    }

    private static List<Flight> makeFlightPath(String path){

        String[] pathList = path.split(":");
        List<Flights> flights = new ArrayList<Flight>();
        String queryList;
        
        for(int i : pathList){
            queryList += pathlist[i] + ",";
        }

        Connection con = connect();

        if(con == null){
            return null;
        }


            try{
            PreparedStatement statement = con.prepareStatement("select * from Flights where id in ("+ queryList + ")");
            ResultSet result = statement.executeQuery();
            }catch (SQLException e){
                e.printStackTrace();
            }

            try{
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            while(result.next()){
                flights.add(new Flight(result.getString("departing"), result.getString("destination"), result.getInt("departingTime"), result.getInt("flightTime"), result.getInt("id")));
            }

            return flights;
 
    }
}
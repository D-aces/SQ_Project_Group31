package com.otu.SOFE3980U;

public class Trip {
<<<<<<< Updated upstream
	int totalTripDuration, departingTime;
	// Made a change from the design to be more consistent: changed types of dpAirpot and FAirport to Airport instead of String
	Airport departingAirport, finalDestination;
	// Made a change to flightPath array --> Changing type to flight makes it easier to get the flight duration 
	Flight[] flightPath;
	
	/*
	 * This is the tough thing to implement
	 */
	void getFlightPaths(Airport departingAirport, Airport finalDestination) {
		this.departingAirport = departingAirport;
		Airport current = this.departingAirport;
		
		
		current.getConnectingAirports();
		while(current.getName() != departingAirport.getName()) {
			current.getConnectingAirports();	
		}
		
	}

	// Changed name from time to Duration to be more consistent
	int calcFlightDuration(Flight[] flightPath) {
		for(int x = 0; x < flightPath.length; x++) {
			totalTripDuration += flightPath[x].getFlightDuration();
			
		}
		return totalTripDuration;
	}
	// Changed name from time to Duration to be more consistent
	int getFlightDuration(Flight[] flightPath) {
		if(totalTripDuration <= 0)
			calcFlightDuration(flightPath);
		return totalTripDuration;
	}
=======

    // Attributes
    private int totalTripDuration; // Will be set later
    private String departingAirport;
    private String finalDestination;
    private int departingTime;
    private String[] flightPath; // will be an array of strings that hold the airport names

	// Constructor, This called by the flightclass and the mr and mo booking
	   public Trip(String departingAirport, String finalDestination, int departingTime) {
        this.departingAirport = departingAirport;
        this.finalDestination = finalDestination;
        this.departingTime = departingTime;
		// this.totalTripDuration = totalTripDuration; later calculated
        // flightPath can be initialized later using the generateFlightPaths
    }

	 public void calculateFlightDetails() {
        // Generate flight path here, for example, based on some algorithm or data
        this.flightPath = generateFlightPaths(this.departingAirport, this.finalDestination);
        
        // Calculate total trip duration here, perhaps summing durations between each stop on the flight path
        this.totalTripDuration = calculateTotalDuration(this.flightPath);
    }

	private String[] generateFlightPaths(String departingAirport, String finalDestination) {
        List<String> flightPaths = new ArrayList<>();
        flightPaths.add(departingAirport); // Start with the departing airport

        // Keep track of airports to visit
        List<String> toVisit = new ArrayList<>();
        toVisit.add(departingAirport);

        // Keep track of airports already visited to avoid cycles
        List<String> visited = new ArrayList<>();

        // Loop until we either find the final destination or there are no more airports to visit
        while (!toVisit.isEmpty()) {
            String currentAirport = toVisit.remove(0); // Get the first airport to visit

            // Avoid revisiting the same airport
            if (visited.contains(currentAirport)) {
                continue;
            }
            visited.add(currentAirport);

            // Query the database for the current airport's connections
            String[] connections = getConnectionsForAirport(currentAirport);

            // Check if the final destination is in the connections
            for (String connection : connections) {
                if (connection.equals(finalDestination)) {
                    flightPaths.add(connection); // Final destination found
                    return flightPaths.toArray(new String[0]);
                } else if (!visited.contains(connection)) {
                    toVisit.add(connection); // Add to the list of airports to visit
                }
            }
        }
        // If the final destination was not found, return an empty path
        return new String[] {};
    }

	private String[] getConnectionsForAirport(String airport) {
        // Placeholder for database connection URL, username, and password
        String dbUrl = "jdbc:mysql://your_database_url";
        String dbUser = "your_username";
        String dbPass = "your_password";
        
        String query = "SELECT connecting FROM Airports WHERE port_name = ?";
        List<String> connections = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement ps = conn.prepareStatement(query)) {

            // Set the parameters for the prepared statement
            ps.setString(1, airport);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String connectingAirports = rs.getString("connecting");
                    // Split the connecting airports string into an array
                    connections = List.of(connectingAirports.split(":"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
        return connections.toArray(new String[0]);
    }
    
    // ... (other methods)
    
>>>>>>> Stashed changes
}

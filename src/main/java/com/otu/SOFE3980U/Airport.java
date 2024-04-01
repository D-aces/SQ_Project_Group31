package com.otu.SOFE3980U;

// this is a change
public class Airport {
	private String name;
	private Airport[] connectingAirports;
	

	public Airport(String name, Airport[] connectingAirports) {
		this.name = name;
		this.connectingAirports = connectingAirports;
	}

	/**
	 * @return the airport name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the connectingAirports
	 */
	public Airport[] getConnectingAirports() {
		return connectingAirports;
	}

}

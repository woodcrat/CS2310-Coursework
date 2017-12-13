package mtr;

import java.util.HashMap;

public class Network {
	//The HashMap holding all of the Line objects and their names
	//making up the Network.
	private HashMap<String, Line> network;
	//The HashMap holding all of the Station objects and their
	//names making up the Network.
	private HashMap<String, Station> stationList;
	
	public Network(){
		network = new HashMap<>();
		stationList = new HashMap<>();
	}
	
	/**
	 * Allows you to add a Line to the network.
	 * @param lineName The name to be associated with the Line, as a String.
	 * @param line The Line object being added (holding the Line's info/details).
	 */
	public void addLine(String lineName, Line line){
		network.put(lineName, line);
	}
	
	/**
	 * Allows you to add an individual station to the network.
	 * @param stationName The name to be associated with the Station, as a String.
	 * @param station The Station object being added (holding the Station's info/details).
	 * 	 
	 */
	public void addStation(String stationName, Station station){
		stationList.put(stationName, station);
	}
	
	/**
	 * Gets all of the Lines within the network object.
	 * @return The HashMap containing all of the Lines, accessible via their names as their keys. 
	 */
	public HashMap<String, Line> getLines(){
		return network;
	}
	
	/**
	 * Get all of the stations within the network object.
	 * @return The HashMap containing all of the Stations within the network, accessible via their names as their keys.  
	 */
	public HashMap<String, Station> getAllStations(){
		return stationList;
	}
}

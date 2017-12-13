package mtr;

import java.util.ArrayList;
import java.util.HashSet;

public class Station {
	
	private String name;
	//The neighbouring Stations are the Stations that are connected to this one,
	//to be used for traversing the Network when path finding.
	private HashSet<Station> neighbouringStations;
	//The linesBelongingTo variable holds the collection of the different Lines
	//that the Station belongs to. To be used in finding one Lines other Line connections.
	private ArrayList<Line> linesBelongingTo;
	//Holds the current "search number" of the Station - can be used to identify
	//whether the Station has already been checked or not in path finding.
	private int stationSearchNumber;
	
	public Station(String name){
		this.name = name;
		neighbouringStations = new HashSet<>(4);
		linesBelongingTo = new ArrayList<>(2);
		stationSearchNumber = 0;
	}
	
	/**
	 * Add a neighbouring station to this station.
	 * @param Neighbour the Station object that you want to add as a neighbouring station.
	 */
	public void addNeighbour(Station neighbour){
		neighbouringStations.add(neighbour);
	}
	
	/**
	 * Add a line that this station belongs to.
	 * @param The line object that this station is on.
	 */
	public void addLineBelongingTo(Line line){
		linesBelongingTo.add(line);
	}	
	
	/**
	 * Get the name of the station.
	 * @return The String representation of the name of this station object.
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Sets the value of the stationSearchNumber field to whatever number is passed in, providing a way
	 * for the path finder to determine whether this station has already been explored or not when traversing.
	 * It uses a number rather than a boolean to allow for an O(1) reset rather than O(n).
	 * @param stationSearchNumber The int value that the station's search number should be set to.
	 */
	public void setExplored(int stationSearchNumber){
		this.stationSearchNumber = stationSearchNumber;
	}
	
	/**
	 * Gets all of the neighbouring stations of this station that haven't been explored so far when path
	 * finding. 
	 * @return An ArrayList of station objects holding those that are connected to this station
	 * but haven't been explored on this iteration of path finding.
	 * @param searchNumber The int that is being used for this iteration.
	 */
	public ArrayList<Station> getUnexploredNeighbouringStations(int searchNumber){
		ArrayList<Station> toReturn = new ArrayList<>();
		//if the station has already been explored then it's stationSaearchNumber 
		//should already be the value of searchNumber and so shouldn't be added
		//to the unexplored Stations list.
		for(Station station : neighbouringStations){
			if(station.stationSearchNumber != searchNumber){
				toReturn.add(station);
			}
		}
		return toReturn;
	}
	
	/**
	 * Gets all of the lines that this station is on.
	 * @return An ArrayList holding Line objects that this Station belongs to. 
	 */
	public ArrayList<Line> getLinesBelongingTo(){
		return linesBelongingTo;
	}
}
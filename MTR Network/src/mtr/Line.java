package mtr;

import java.util.ArrayList;

public class Line {

	private String name;
	//Holds all of the Station objects that are part of this Line.
	private ArrayList<Station> linesStations;
	
	public Line(String name){
		this.name = name;
		linesStations = new ArrayList<>(18);
	}
	
	/**
	 * Lets you add a Station object to the Line.
	 * @param toAdd The Station object that you're adding to the Line.
	 */
	public void addStation(Station toAdd){
		linesStations.add(toAdd);
	}
	
	/**
	 * Gets you all of the stations in the Line.
	 * @return The ArrayList containing all of the Station objects of this Line. 
	 */
	public ArrayList<Station> getStations(){
		return linesStations;
	}	
	
	/**
	 * Gets the name of the Line object.
	 * @return The name of the Line object as a String. 
	 */
	public String getName(){
		return name;
	}
}

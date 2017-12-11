package mtr;

import java.util.ArrayList;

public class Line {

	private String name;
	private ArrayList<Station> linesStations;
	
	public Line(String name){
		this.name = name;
		linesStations = new ArrayList<>();
	}
	
	public void addStation(Station toAdd){
		linesStations.add(toAdd);
	}
	
	public ArrayList<Station> getStations(){
		return linesStations;
	}	
	
	public String getName(){
		return name;
	}
}
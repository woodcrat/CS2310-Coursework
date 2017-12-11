package mtr;

import java.util.HashMap;

public class Network {
	
	private HashMap<String, Line> network;
	private HashMap<String, Station> stationList;
	
	public Network(){
		network = new HashMap<>();
		stationList = new HashMap<>();
	}
	
	public void addLine(String lineName, Line line){
		network.put(lineName, line);
	}
	
	public void addStation(String stationName, Station station){
		stationList.put(stationName, station);
	}
	
	public HashMap<String, Line> getLines(){
		return network;
	}
	
	public HashMap<String, Station> getAllStations(){
		return stationList;
	}
}

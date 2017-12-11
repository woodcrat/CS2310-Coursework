package mtr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileImporter {

	private BufferedReader input;
	private String lineProcessing;
	private String[] lineBreakdown;
	private Network mtrNetwork;
	private boolean carryOnProcessing;
	
	public FileImporter(String fileName){
		try {
			input = new BufferedReader(new FileReader(new File(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		carryOnProcessing = true;
		mtrNetwork = new Network();
	}
	
	public Network getFromFile(){
		
		while(carryOnProcessing){
			try {
				lineProcessing = input.readLine();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
			if(lineProcessing == null){
				carryOnProcessing = false;
			}
			else{
				lineBreakdown = lineProcessing.split(",");
				Line line = new Line(lineBreakdown[0]);
				
				for(int i=1; i<lineBreakdown.length; i++){
					Station station;					
					if(mtrNetwork.getAllStations().get(lineBreakdown[i]) != null){
					station = mtrNetwork.getAllStations().get(lineBreakdown[i]);
					}
					else{
						station = new Station(lineBreakdown[i]);
					}
					station.addLineBelongingTo(line);
					line.addStation(station);
					mtrNetwork.addStation(station.getName(), station);
				}
					mtrNetwork.addLine(line.getName(), line);
			}
		}

		HashMap<String, Line> theNetworksLines = mtrNetwork.getLines();
		for(Map.Entry<String, Line> cursor : theNetworksLines.entrySet()){
			ArrayList<Station> theLinesStations = cursor.getValue().getStations();
			int index = 0;
			while(index < theLinesStations.size()){
				if((index-1) >= 0){
					theLinesStations.get(index).addNeighbour(theLinesStations.get(index-1));
				}
				if((index+1) <= (theLinesStations.size()-1)){
					theLinesStations.get(index).addNeighbour(theLinesStations.get(index+1));
				}
				index++;
			}
		}
		
		return mtrNetwork;
	}
}

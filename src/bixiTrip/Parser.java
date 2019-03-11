package bixiTrip;

import java.io.File;
import java.util.Scanner;

public class Parser {
	
	public PastTrips parsePastTrips(String dirPath) {
		
		PastTrips pastTrips = PastTrips.getInstance();
		
		File folder = new File(dirPath);
		File[] listOfFiles = folder.listFiles();
		
		for (File file : listOfFiles) {
			if (file.isFile()) {
				try {
					Scanner input = new Scanner(file);
					input.nextLine();
					while (input.hasNext()) {
						String trip = input.nextLine();
						String[] tempArray = trip.split(",");
						
						int startStation = Integer.parseInt(tempArray[1]);
						int endStation = Integer.parseInt(tempArray[3]);
						int duration = Integer.parseInt(tempArray[4]);
						
						pastTrips.addTrip(new PastTrip(startStation, endStation, duration));
						
					}
				}
			}
		}

		return pastTrips;
	}
	
	public Stations parseStations(String filePath) {

		Stations stations = Stations.getInstance();
		
		File file = new File(filePath);
		
		try {
			Scanner input = new Scanner(file);
			input.nextLine();
			while (input.hasNext()) {
				String station = input.nextLine();
				String[] tempArray1 = station.split(",");
				
				int code = Integer.parseInt(tempArray1[0]);
				
				String name = tempArray1[1];
				
				double latitude = Double.parseDouble(tempArray1[2]);
				double longitude = Double.parseDouble(tempArray1[3]);
				Coord coords = new Coord(latitude, longitude);
				
				stations.addStation(new Station(code, name, coords));
			}
		}
		return stations;
	}
}

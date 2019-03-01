package bixiTrip;

import java.util.ArrayList;

/** 
 * A singleton datatype to store and perform operations
 * on a list of Stations.
 * 
 * @author Jonathan Janzen
 *
 */

public class Stations {

	private static Stations single_instance = null;
	
	private ArrayList<Station> stations = new ArrayList<Station>();
	
	public static Stations Stations()
	{
		if (single_instance == null)
			single_instance = new Stations();
		return single_instance;
	}
	
	private void addStation(Station station) {
		stations.add(station);
	}
	
	private ArrayList<Station> getStations()
	{
		return stations;
	}
	
	public static void main(String args[]) {
		Stations stations = Stations.Stations();
		Station test = new Station(4561, "Test Station 1", null);
		Station test2 = new Station(3920, "Test Station 2", null);
		stations.addStation(test);
		stations.addStation(test2);
		ArrayList<Station> stationsArray = stations.getStations();
		for (int i = 0; i < stationsArray.size(); i++) {
			System.out.println(stationsArray.get(i).getName());
		}

	}
}

package bixiTrip;

import java.util.ArrayList;

/**
 * A singleton datatype to store and perform operations on a list of Stations.
 * Singleton implementation based on information found at:
 * https://www.geeksforgeeks.org/singleton-class-java/
 * 
 * @author Jonathan Janzen
 *
 */

public class Stations {

	private static Stations single_instance = null;
	private boolean isSorted = true;
	private ArrayList<Station> stations = new ArrayList<Station>();

	/**
	 * Constructor for a singleton Stations() object.
	 * 
	 * @return Returns a single instance of the Stations object, whether one already
	 *         exists or not.
	 */
	public static Stations Stations() {
		if (single_instance == null)
			single_instance = new Stations();
		return single_instance;
	}
	
	Station getStation(Integer code)
	{
		if (!isSorted) {
			//SORT
		}
		return null;
	}
	
	/**
	 * Add a Station object to Stations.
	 * 
	 * @param station A Station object to be added to the Stations data type.
	 */
	void addStation(Station station) {
		//add station to object
		stations.add(station);
		isSorted = false;
	}

	/**
	 * Function to return the stations stored in the instance of Stations.
	 * 
	 * @return Returns ArrayList<Stations> of stations stored.
	 */
	ArrayList<Station> getStations() {
		//sort list if not sorted
		if (!isSorted) {
			//SORT
		}
		return stations;
	}
	
	//TEMPORARY TESTING FUNCTION
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

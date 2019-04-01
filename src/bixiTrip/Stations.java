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

	private static Stations instance = null;
	private boolean isSorted = true;
	private final ArrayList<Station> stations = new ArrayList<Station>();

	/**
	 * Constructor for a singleton Stations() object.
	 * 
	 * @return Returns a single instance of the Stations object, whether one already
	 *         exists or not.
	 */
	public static Stations getInstance() {
		if (instance == null)
			instance = new Stations();
		return instance;
	}

	/**
	 * Private method to sort the Stations stored in the object.
	 */
	private void sortStations() {
		algs.StationsMergesort.sort(stations);
		isSorted = true;
	}

	/**
	 * Function to find a station based on its code in a Stations object.
	 * 
	 * @param code Integer code that represents the station to be found.
	 * @return Returns the station with the equivalent code.
	 */
	public Station getStationByCode(int code) {
		if (!isSorted) {
			sortStations();
		}
		int index = algs.BinarySearch.stationSearch(stations, code);
		try {
			return stations.get(index);
		} catch (ArrayIndexOutOfBoundsException e) {
			// catch out-of-bounds exception
			throw e;
		}
	}

	/**
	 * Function to find a station based on its code in a Stations object.
	 * 
	 * @param index Integer code that represents the index position of the station
	 *              requested.
	 * @return Returns the station at the given index.
	 */
	public Station getStationByIndex(int index) {
		if (!isSorted) {
			sortStations();
		}
		try {
			return stations.get(index);
		} catch (Exception e) {
			// catch out-of-bounds exception
			throw e;
		}
	}

	/**
	 * Function to find a station's index in a Stations object.
	 * 
	 * @param code Integer code that represents the station to be found.
	 * @return Returns an int representing the index position.
	 */
	public int getIndex(int code) {
		if (!isSorted) {
			sortStations();
		}
		// convert to an array to be searched
		int index = algs.BinarySearch.stationSearch(stations, code);
		if (index < 0)
			throw new IndexOutOfBoundsException("Station not found.");
		return index;
	}

	/**
	 * Add a Station object to Stations.
	 * 
	 * @param station A Station object to be added to the Stations data type.
	 */
	public void addStation(Station station) {
		// add station to object
		stations.add(station);
		isSorted = false;
	}

	/**
	 * Function to return the stations stored in the instance of Stations.
	 * 
	 * @return Returns ArrayList of stations stored.
	 */
	public ArrayList<Station> getStations() {
		// sort list if not sorted
		if (!isSorted) {
			sortStations();
		}
		return stations;
	}

	/**
	 * Function to return the number of stations stored in the instance of Stations.
	 * 
	 * @return Returns number of stations stored.
	 */
	public int size() {
		return stations.size();
	}
}

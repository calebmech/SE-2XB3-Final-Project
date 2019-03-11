package bixiTrip;

import java.util.ArrayList;
import algs.PastTripsBUMergeSort;

/**
 * Class that contains the access to different trips
 * 
 * @author matthewbraden
 *
 */
public class PastTrips {

	private static PastTrips instance = null;
	private boolean isSorted = true;
	private ArrayList<PastTrip> pastTrips = new ArrayList<PastTrip>();

	/**
	 * Function that constructs a singleton PastTrips()
	 * 
	 * @return returns an instance of the PastTrips() object
	 */
	public static PastTrips getInstance() {
		if (instance == null) {
			instance = new PastTrips();
		}
		return instance;
	}
	
	private void sortPastTrips() {
		algs.PastTripsBUMergeSort.sort(pastTrips);
	}

	/**
	 * 
	 * Function that returns a list of past trips between two stations
	 * 
	 * @param start The starting station of the trip
	 * @param end   The end station of the trip
	 * @return List of past trips
	 */
	public ArrayList<PastTrip> getTrips(Station start, Station end) {
		sortPastTrips();
		return pastTrips;
	}

	/**
	 * Function that adds a trip to the list
	 * 
	 * @param trip A new single trip
	 */
	public void addTrip(PastTrip trip) {
		pastTrips.add(trip);
		
	}
}

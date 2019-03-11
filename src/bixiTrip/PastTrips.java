package bixiTrip;

import java.util.ArrayList;

/**
 * Class that contains the access to different trips
 * 
 * @author matthewbraden
 *
 */
public class PastTrips {

	private static PastTrips instance = null;
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

	/**
	 * Function that sorts a list of pastTrips
	 */
	private void sortPastTrips() {
		algs.PastTripsBUMergeSort.sort(pastTrips);
	}

	/**
	 * 
	 * Function that returns a next list of past trips between two stations
	 * 
	 * @return List of past trips
	 */
	public ArrayList<PastTrip> getNextPath() {
		sortPastTrips();
		getInstance();
		//pastTrips = pastTrips.remove(instance);
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

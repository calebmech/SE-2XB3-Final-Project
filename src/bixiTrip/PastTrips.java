package bixiTrip;

import java.util.ArrayList;
import bixiTrip.PastTrip;

/**
 * Class that contains the access to different trips
 * 
 * @author Matthew Braden
 *
 */
public class PastTrips {

	private static PastTrips instance = null;
	private boolean isSorted = true;
	private ArrayList<PastTrip> pastTrips = new ArrayList<PastTrip>();
	private int i = 0;
	
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
		isSorted = true;
	}

	/**
	 * 
	 * Function that returns a next list of past trips between two stations
	 * 
	 * @return List of past trips
	 */
	public ArrayList<PastTrip> getNextPath() {
		ArrayList<PastTrip> nextTrips = new ArrayList<PastTrip>();
		if (!isSorted) {
			sortPastTrips();
		}
		if (pastTrips.isEmpty()) {
			return null;
		}
		int start = pastTrips.get(i).getStartCode();
		int end = pastTrips.get(i).getEndCode();
		while (start == pastTrips.get(i).getStartCode() && end == pastTrips.get(i).getEndCode()) {
			nextTrips.add(i, pastTrips.get(i));;
			i++;
		}
		return nextTrips;
	}

	/**
	 * Function that adds a trip to the list
	 * 
	 * @param trip A new single trip
	 */
	public void addTrip(PastTrip trip) {
		pastTrips.add(trip);
		isSorted = false;
	}
}

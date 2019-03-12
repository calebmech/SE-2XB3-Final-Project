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
		int start = pastTrips.get(0).getStartCode();
		int end = pastTrips.get(0).getEndCode();
		int i = 0;
		while (i < pastTrips.size()) {
			int next_start = pastTrips.get(i).getStartCode();
			int next_end = pastTrips.get(i).getEndCode();
			if (start == next_start) {
				if (end == next_end) {
					nextTrips.addAll(i, pastTrips);
					pastTrips.remove(i);
				}
			}
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

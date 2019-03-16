package bixiTrip;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Class that contains the access to different trips
 * 
 * @author Matthew Braden & Jonathan Janzen
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
	 * Function that returns the next list of past trips between two shared stations. For example, an
	 * ArrayList of all past trips that have the same start and end station.
	 * 
	 * @return List of past trips
	 */
	public ArrayList<PastTrip> getNextPath() {
		ArrayList<PastTrip> nextTrips = new ArrayList<PastTrip>();
		if (!isSorted) {
			sortPastTrips();
		}
		int start = pastTrips.get(i).getStartCode();
		int end = pastTrips.get(i).getEndCode();
		while (start == pastTrips.get(i).getStartCode() && end == pastTrips.get(i).getEndCode()
				&& i < (pastTrips.size() - 1)) {
			nextTrips.add(pastTrips.get(i));
			i++;
		}
		if (i >= (pastTrips.size() - 1) && nextTrips.size() < 1) {
//			System.out.println(
//					NumberFormat.getNumberInstance(Locale.US).format(pastTrips.size()) + " past trips parsed.");
			return null;
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

	/**
	 * Function to move the count variable back to the first index.
	 */
	public void initialize() {
		i = 0;
	}
}

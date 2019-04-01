package bixiTrip;

import java.util.ArrayList;

/**
 * Class that contains the access to different trips
 * 
 * @author Matthew Braden and Jonathan Janzen
 *
 */
public class PastTrips {

	private static PastTrips instance = null;
	private boolean isSorted = true;
	private final ArrayList<PastTrip> pastTrips = new ArrayList<PastTrip>();
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
	 * Function that returns the next list of past trips between two shared
	 * stations. For example, an ArrayList of all past trips that have the same
	 * start and end station.
	 * 
	 * @return List of past trips
	 */
	public ArrayList<PastTrip> getNextPath() {
		ArrayList<PastTrip> nextTrips = new ArrayList<PastTrip>();
		if (!isSorted) {
			sortPastTrips();
		}

		if (i >= pastTrips.size() && nextTrips.size() < 1) {
//			System.out.println(
//					NumberFormat.getNumberInstance(Locale.US).format(pastTrips.size()) + " past trips parsed.");
			return null;
		}
		
		int start = pastTrips.get(i).getStartCode();
		int end = pastTrips.get(i).getEndCode();
		while (i < pastTrips.size() &&
			   start == pastTrips.get(i).getStartCode() &&
			   end == pastTrips.get(i).getEndCode()) 
		{
			nextTrips.add(pastTrips.get(i));
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

	/**
	 * Function to move the count variable back to the first index.
	 */
	public void initialize() {
		i = 0;
	}
}

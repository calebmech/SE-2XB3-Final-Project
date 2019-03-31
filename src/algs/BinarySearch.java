package algs;

import java.util.ArrayList;

import bixiTrip.Path;
import bixiTrip.Station;

public class BinarySearch {

	/**
	 * Implementation of binary search using code from Sedgewick and Wayne's
	 * "Algorithms: Fourth Edition" on page 9. Minor modifications have been made to
	 * implement searching on Stations based on an integer, in order to match the
	 * API.
	 * 
	 * @param a    An arraylist of type Station to be searched.
	 * @param code An integer code to search for
	 * @return the mid value in the ArrayList
	 */
	public static int stationSearch(ArrayList<Station> a, Integer code) {
		int lo = 0;
		int hi = a.size() - 1;
		while (lo <= hi) { // Searching the arraylist
			int mid = lo + (hi - lo) / 2; // Changes the mid value
			if (code < a.get(mid).getCode())
				hi = mid - 1; // changes the high value
			else if (code > a.get(mid).getCode())
				lo = mid + 1; // changes the low value
			else
				return mid; // returns the mid value
		}
		return -1; // if not in the list return -1
	}

	/**
	 * 
	 * Implementation of binary search using code from Sedgewick and Wayne's
	 * "Algorithms: Fourth Edition" on page 9. Minor modifications have been made to
	 * implement searching on Stations based on an integer, in order to match the
	 * API.
	 * 
	 * @param a    An arraylist of type Path to be searched.
	 * @param code Path code in the arraylist
	 * @return the mid value in the arraylist
	 */
	public static int pathSearch(ArrayList<Path> a, int code) {
		int lo = 0;
		int hi = a.size() - 1;
		while (lo <= hi) { // Searching the arraylist
			int mid = lo + (hi - lo) / 2; // Changes the mid value
			if (code < a.get(mid).getEndCode())
				hi = mid - 1; // changes the high value
			else if (code > a.get(mid).getEndCode())
				lo = mid + 1; // changes the low value
			else
				return mid; // returns the mid value
		}
		return -1; // if not in the list return -1
	}
}

package algs;

import java.util.ArrayList;

/**
 * Implementation of Binary Search using code from Sedgewick & Wayne's
 * "Algorithms: Fourth Edition". Individual functions have been cited
 * appropriately.
 * 
 * @author Jonathan Janzen
 *
 */

import java.util.Arrays;

import bixiTrip.Station;

public class BinarySearch {

	/**
	 * Implementation of binary search using code from Sedgewick & Wayne's
	 * "Algorithms: Fourth Edition" on page 9. Minor modifications have been made to
	 * implement searching on Stations based on an integer, in order to match the
	 * API.
	 * 
	 * @param a   An arraylist of type Station to be searched.
	 * @param key An integer code to search for
	 * @return
	 */
	public static int stationSearch(ArrayList<Station> a, Integer code) {
		int lo = 0;
		int hi = a.size() - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (code < a.get(mid).getCode())
				hi = mid - 1;
			else if (code > a.get(mid).getCode())
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}
}

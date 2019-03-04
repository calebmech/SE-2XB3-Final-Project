package algs;

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
	 * "Algorithms: Fourth Edition" on page 9. Minor modifications have been
	 * made to implement searching on Stations based on an integer, in order
	 * to match the API.
	 * @param a An array of type Comparable to be searched.
	 * @param key A comparable object to search for.
	 * @return
	 */
	public static int stationSearch(Station[] a, Integer key) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid].getCode()) hi = mid - 1;
			else if (key > a[mid].getCode()) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
}

package algs;

import java.util.ArrayList;

import bixiTrip.Station;

/**
 * Class containing code for mergesort. Code taken from Sedgewick and Wayne's
 * "Algorithms: Fourth Edition". Each function has been cited individually from
 * the textbook.
 * 
 * @author Jonathan Janzen
 *
 */

public class StationsMergesort {

	private static Station[] aux, aux2;

	/**
	 * Code for less taken from page 245 of "Algorithms: Fourth Edition" by
	 * Sedgewick and Wayne.
	 * 
	 * @param v A comparable object.
	 * @param w A comparable object.
	 * @return Return true if v is less than w, false otherwise.
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * Function to merge. Code based on Sedgewick & Wayne's "Algorithms: Fourth
	 * Edition" on page 271, but modified to implement the Station type.
	 * 
	 * @param a   An ArrayList of type <Station>.
	 * @param lo  Low index position.
	 * @param mid Mid index position.
	 * @param hi  High index position.
	 */
	private static void merge(ArrayList<Station> a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;

		for (int k = lo; k <= hi; k++)
			aux[k] = a.get(k);
		for (int k = lo; k <= hi; k++)
			if (i > mid)
				a.set(k, aux[j++]);
			else if (j > hi)
				a.set(k, aux[i++]);
			else if (less(aux[j], aux[i]))
				a.set(k, aux[j++]);
			else
				a.set(k, aux[i++]);
	}

	/**
	 * Sorting function intial call. Code based from Sedgewick and Wayne's
	 * "Algorithms: Fourth Edition" on page 278, but modified to fit the Station
	 * datatype.
	 * 
	 * @param a An ArrayList of type Station.
	 */
	public static void sort(ArrayList<Station> a) {
		int n = a.size();
		aux = new Station[n];
		for (int len = 1; len < n; len *= 2)
			for (int lo = 0; lo < n - len; lo += len + len)
				merge(a, lo, lo + len - 1, Math.min(lo + len + len - 1, n - 1));
	}

	/**
	 * Function to merge. Code based on Sedgewick & Wayne's "Algorithms: Fourth
	 * Edition" on page 271, but modified to implement the Station type and sort by
	 * name.
	 * 
	 * @param a   An ArrayList of type <Station>.
	 * @param lo  Low index position.
	 * @param mid Mid index position.
	 * @param hi  High index position.
	 */
	private static void mergeByName(ArrayList<Station> a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;

		for (int k = lo; k <= hi; k++)
			aux2[k] = a.get(k);
		for (int k = lo; k <= hi; k++)
			if (i > mid)
				a.set(k, aux2[j++]);
			else if (j > hi)
				a.set(k, aux2[i++]);
			else if ((aux2[j].getName()).compareTo(aux2[i].getName()) < 0)
				a.set(k, aux2[j++]);
			else
				a.set(k, aux2[i++]);
	}

	/**
	 * Function to sort an ArrayList of Stations based on name. Returns a duplicate
	 * of the original input ArrayList.
	 * 
	 * @param a The original ArrayList to sort.
	 * @return Returns a duplicate ArrayList sorted by name.
	 */
	public static ArrayList<Station> sortByName(ArrayList<Station> a) {
		ArrayList<Station> temp = new ArrayList<Station>();
		for (int i = 0; i < a.size(); i++) {
			temp.add(a.get(i));
		}
		int n = a.size();
		aux2 = new Station[n];
		for (int len = 1; len < n; len *= 2)
			for (int lo = 0; lo < n - len; lo += len + len)
				mergeByName(temp, lo, lo + len - 1, Math.min(lo + len + len - 1, n - 1));
		return temp;
	}

}

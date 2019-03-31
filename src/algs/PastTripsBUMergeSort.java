package algs;

import java.util.ArrayList;

import bixiTrip.PastTrip;

/**
 * Class that MergeSorts the ArrayList of PastTrips in terms of Stations
 * 
 * @author Matthew Braden
 *
 */

public class PastTripsBUMergeSort {

	private static PastTrip[] aux;

	/**
	 * Function that compares the two values in the array This is found in the
	 * Sedgewick and Wayne "Algorithms Fourth Edition" textbook on page 245
	 * 
	 * @param v Value from ArrayList being compared
	 * @param w Value from ArrayList being compared
	 * @return returns true depending on if v > w
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * Function that merges the two arrays together, This is found in the Sedgewick
	 * and Wayne "Algorithms Fourth Edition" textbook on page 271
	 * 
	 * @param a   ArrayList to be sorted
	 * @param lo  The low index value in the array
	 * @param mid The middle index value in the array
	 * @param hi  The high index value in the array
	 */

	public static void merge(ArrayList<PastTrip> a, int lo, int mid, int hi) {
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
	 * Function that sorts the ArrayList using BU mergesort This is found in the
	 * Sedgewick and Wayne "Algorithms Fourth Edition" textbook on page 278
	 * 
	 * @param a ArrayList to be sorted
	 */
	public static void sort(ArrayList<PastTrip> a) {
		int n = a.size();
		aux = new PastTrip[n];
		for (int sz = 1; sz < n; sz = sz + sz) {
			for (int lo = 0; lo < n - sz; lo += sz + sz) {
				merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
			}
		}
	}

}

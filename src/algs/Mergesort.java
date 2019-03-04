package algs;

/**
 * Class containing code for mergesort. Code taken from Sedgewick & Wayne's
 * "Algorithms: Fourth Edition". Each function has been cited individually from
 * the textbook.
 * 
 * @author Jonathan Janzen
 *
 */

public class Mergesort {

	private static Comparable[] aux;

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
	 * Function to merge. Code taken from Sedgewick & Wayne's "Algorithms: Fourth
	 * Edition" on page 271.
	 * 
	 * @param a   An array of type Comparable[].
	 * @param lo  Low index position.
	 * @param mid Mid index position.
	 * @param hi  High index position.
	 */
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;

		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		for (int k = lo; k <= hi; k++)
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
	}

	/**
	 * Sorting function intial call. Code taken from Sedgewick & Wayne's
	 * "Algorithms: Fourth Edition" on page 278.
	 * 
	 * @param a An array of a Comparable type.
	 */
	public static void sort(Comparable[] a) {
		int n = a.length;
		aux = new Comparable[n];
		for (int len = 1; len < n; len *= 2)
			for (int lo = 0; lo < n - len; lo += len + len)
				merge(a, lo, lo + len - 1, Math.min(lo + len + len - 1, n - 1));
	}

}

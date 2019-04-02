// Taken from https://algs4.cs.princeton.edu/code/

package algs;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Minimum oriented indexed priority queue
 * 
 * @author Caleb Mech
 *
 * @param <Key> Type of key
 */
public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {
	private int maxN;
	private int n;
	private int[] pq;
	private int[] qp;
	private Key[] keys;

	/**
	 * Constructor for priority queue (PQ)
	 * 
	 * @param maxN Max index value
	 * @throws IllegalArgumentException Thrown if max is less than 0
	 */
	public IndexMinPQ(int maxN) {
		if (maxN < 0)
			throw new IllegalArgumentException();
		this.maxN = maxN;
		n = 0;
		keys = (Key[]) new Comparable[maxN + 1];
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		for (int i = 0; i <= maxN; i++)
			qp[i] = -1;
	}

	/**
	 * Check if PQ is empty
	 * 
	 * @return Whether PQ is empty
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * Check if PQ contains value at given index
	 * 
	 * @param i Index to look at
	 * @return Whether PQ contains value at index
	 */
	public boolean contains(int i) {
		if (i < 0 || i >= maxN)
			throw new IllegalArgumentException();
		return qp[i] != -1;
	}

	/**
	 * Size of PQ
	 * 
	 * @return Number of keys in PQ
	 */
	public int size() {
		return n;
	}

	/**
	 * Insert key into PQ at given index
	 * 
	 * @param i Index to insert at
	 * @param key Key to insert
	 * @throws IllegalArgumentException Thrown if index is invalid or there is
	 * already a value at i
	 */
	public void insert(int i, Key key) {
		if (i < 0 || i >= maxN)
			throw new IllegalArgumentException();
		if (contains(i))
			throw new IllegalArgumentException("index is already in the priority queue");
		n++;
		qp[i] = n;
		pq[n] = i;
		keys[i] = key;
		swim(n);
	}

	/**
	 * Value at index of minimum key
	 * 
	 * @return Index of smallest key
	 * @throws NoSuchElementException Thrown if PQ is empty
	 */
	public int minIndex() {
		if (n == 0)
			throw new NoSuchElementException("Priority queue underflow");
		return pq[1];
	}

	/**
	 * Value of minimum key
	 * 
	 * @return Value of minimum key
	 * @throws NoSuchElementException Thrown if PQ is empty
	 */
	public Key minKey() {
		if (n == 0)
			throw new NoSuchElementException("Priority queue underflow");
		return keys[pq[1]];
	}

	/**
	 * Delete minimum element
	 * 
	 * @return Index of deleted element
	 * @throws NoSuchElementException Thrown if PQ is empty
	 */
	public int delMin() {
		if (n == 0)
			throw new NoSuchElementException("Priority queue underflow");
		int min = pq[1];
		exch(1, n--);
		sink(1);
		assert min == pq[n + 1];
		qp[min] = -1; // delete
		keys[min] = null; // to help with garbage collection
		pq[n + 1] = -1; // not needed
		return min;
	}

	/**
	 * Key found at index
	 * 
	 * @param i Index to look at
	 * @return Key at given index
	 * @throws IllegalArgumentException Thrown if index is invalid
	 * @throws NoSuchElementException Thrown if there is no key
	 * at the given index
	 */
	public Key keyOf(int i) {
		if (i < 0 || i >= maxN)
			throw new IllegalArgumentException();
		if (!contains(i))
			throw new NoSuchElementException("index is not in the priority queue");
		else
			return keys[i];
	}

	/**
	 * Change key at a given index
	 * 
	 * @param i Index to change at
	 * @param key Key to change to
	 * @throws IllegalArgumentException Thrown if index is invalid
	 * @throws NoSuchElementException Thrown if there is no key
	 * at the given index
	 */
	public void changeKey(int i, Key key) {
		if (i < 0 || i >= maxN)
			throw new IllegalArgumentException();
		if (!contains(i))
			throw new NoSuchElementException("index is not in the priority queue");
		keys[i] = key;
		swim(qp[i]);
		sink(qp[i]);
	}

	/**
	 * Decrease key at a given index
	 * 
	 * @param i Index to change at
	 * @param key Key to change to
	 * @throws IllegalArgumentException Thrown if index is invalid
	 * @throws NoSuchElementException Thrown if there is no key
	 * at the given index
	 * @throws IllegalArgumentException Thrown if the key would not be decreased
	 */
	public void decreaseKey(int i, Key key) {
		if (i < 0 || i >= maxN)
			throw new IllegalArgumentException();
		if (!contains(i))
			throw new NoSuchElementException("index is not in the priority queue");
		if (keys[i].compareTo(key) <= 0)
			throw new IllegalArgumentException(
					"Calling decreaseKey() with given argument would not strictly decrease the key");
		keys[i] = key;
		swim(qp[i]);
	}

	/**
	 * Increase key at a given index
	 * 
	 * @param i Index to change at
	 * @param key Key to change to
	 * @throws IllegalArgumentException Thrown if index is invalid
	 * @throws NoSuchElementException Thrown if there is no key
	 * at the given index
	 * @throws IllegalArgumentException Thrown if the key would not be increased
	 */
	public void increaseKey(int i, Key key) {
		if (i < 0 || i >= maxN)
			throw new IllegalArgumentException();
		if (!contains(i))
			throw new NoSuchElementException("index is not in the priority queue");
		if (keys[i].compareTo(key) >= 0)
			throw new IllegalArgumentException(
					"Calling increaseKey() with given argument would not strictly increase the key");
		keys[i] = key;
		sink(qp[i]);
	}

	/**
	 * Delete key at a given index
	 * 
	 * @param i Index to delete at
	 * @throws IllegalArgumentException Thrown if index is invalid
	 * @throws NoSuchElementException Thrown if there is no key
	 * at the given index
	 */
	public void delete(int i) {
		if (i < 0 || i >= maxN)
			throw new IllegalArgumentException();
		if (!contains(i))
			throw new NoSuchElementException("index is not in the priority queue");
		int index = qp[i];
		exch(index, n--);
		swim(index);
		sink(index);
		keys[i] = null;
		qp[i] = -1;
	}

	/**
	 * Check if key at i is greater than key at j
	 * 
	 * @param i Index to compare with
	 * @param j Index to compare to
	 * @return Whether key at i is greater than key at j
	 */
	private boolean greater(int i, int j) {
		return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
	}

	/**
	 * Exchange keys of i and j
	 * 
	 * @param i First index
	 * @param j Second index
	 */
	private void exch(int i, int j) {
		int swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}

	/**
	 * Swim up key at k
	 * 
	 * @param k Index to swim up at
	 */
	private void swim(int k) {
		while (k > 1 && greater(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	/**
	 * Sink down key at k
	 * 
	 * @param k Index to swim down at
	 */
	private void sink(int k) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && greater(j, j + 1))
				j++;
			if (!greater(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}

	/**
	 * Iterator that iterates over keys in PQ
	 */
	public Iterator<Integer> iterator() {
		return new HeapIterator();
	}

	private class HeapIterator implements Iterator<Integer> {
		// create a new pq
		private IndexMinPQ<Key> copy;

		// add all elements to copy of heap
		// takes linear time since already in heap order so no keys move
		public HeapIterator() {
			copy = new IndexMinPQ<Key>(pq.length - 1);
			for (int i = 1; i <= n; i++)
				copy.insert(pq[i], keys[pq[i]]);
		}

		public boolean hasNext() {
			return !copy.isEmpty();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Integer next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return copy.delMin();
		}
	}

}

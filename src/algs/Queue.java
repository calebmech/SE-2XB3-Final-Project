/**
 * Meghan Mazer
 * This code was sourced from the Princeton Algorithms textbook
 * and modified for implementation in this assignment
 */

package algs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int n;

	/**
	 * Initializes an empty queue
	 */
	private class Node {
		Item item;
		Node next;
	}

	/**
	 * Returns true if this queue is empty.
	 *
	 * @return True if queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the number of items in the queue
	 *
	 * @return the number of items in the queue
	 */
	public int size() {
		return n;
	}

	/**
	 * Adds item to queue
	 *
	 * @param item the item to add
	 */
	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty())
			first = last;
		else
			oldlast.next = last;
		n++;
	}

	/**
	 * Removes least recent item and returns it
	 *
	 * @return the item on this queue that was least recently added
	 * @throws NoSuchElementException if queue is empty
	 */
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		n--;
		if (isEmpty())
			last = null;
		return item;
	}

	/**
	 * Returns iterator that iterates over items in the queue
	 *
	 * @return an iterator that iterates in FIFO order
	 */
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	/**
	 * Iterator that does not implement remove()
	 * 
	 * @return item The next item in the queue
	 *
	 */
	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}

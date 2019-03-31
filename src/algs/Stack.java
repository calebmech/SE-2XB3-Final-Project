package algs;

import java.util.Iterator;

/**
 * 
 * Class that creates a stack of items
 *
 * @param <Item> Item in the stack
 */
public class Stack<Item> implements Iterable<Item> {
	private Node first;
	private int n;

	/**
	 * 
	 * Class that creates a node for a linked list
	 *
	 */
	private class Node {
		Item item; // Declaring the parts of each node
		Node next;
	}

	/**
	 * Function that returns if the stack is empty
	 * 
	 * @return if stack is empty
	 */
	public boolean isEmpty() {
		return first == null; // Finding if the list is empty
	}

	/**
	 * Function that returns the size of the stack
	 * 
	 * @return size of stack
	 */
	public int size() {
		return n; // returns an int
	}

	/**
	 * Function that adds a certain item to the stack
	 * 
	 * @param item Item to be added to stack
	 */
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node(); // Declaring a first node
		first.item = item; // adding an item
		first.next = oldfirst; // adding a next
		n++;
	}

	/**
	 * Function that removes the top item in the stack
	 * 
	 * @return The item being removed
	 */
	public Item pop() {
		Item item = first.item;
		first = first.next; // replaces the first next value
		n--;
		return item; // returns the item
	}

	/**
	 * Returns a new list iterator
	 */
	public Iterator<Item> iterator() {
		return new ListIterator(); // returns an iterator
	}

	/**
	 * 
	 * Class that implements an iterator
	 *
	 */
	private class ListIterator implements Iterator<Item> {
		private Node current = first; // declares a current node

		/**
		 * returns if the list has a next value
		 */
		public boolean hasNext() {
			return current != null; // checks if current is null
		}

		/**
		 * removes a value from the list
		 */
		public void remove() {
		}

		/**
		 * Returns the next item in the list
		 */
		public Item next() {
			Item item = current.item;
			current = current.next; // adding current to current.next
			return item; // returns an item
		}
	}
}

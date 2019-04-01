// Taken from page 643 of Algorithms (Fourth Edition), Sedgewick and Wayne

package algs;

import java.util.ArrayList;

import bixiTrip.Path;

/**
 * Graph data structure class
 * 
 * @author Caleb Mech
 *
 */
public class Graph {
	private final int V; // number of vertices
	private int E; // number of edges
	private ArrayList<Path>[] adj; // adjacency lists

	/**
	 * Constructor for Graph
	 */
	public Graph() {
		this.V = 10003;
		this.E = 0;
		
		// Create an empty adjacency list for each node in graph
		// Use ArrayList instead of bag because of large number of 
		// adjacent edges
		adj = (ArrayList<Path>[]) new ArrayList[V];
		for (int v = 0; v < V; v++)
			adj[v] = new ArrayList<Path>();
	}

	/**
	 * Getter for number of nodes
	 * 
	 * @return Number of nodes in graph
	 */
	public int V() {
		return V;
	}

	/**
	 * Getter for number of edges
	 * 
	 * @return Number of edges in graph
	 */
	public int E() {
		return E;
	}

	/**
	 * Add path to graph
	 * 
	 * @param p Path to add to graph
	 */
	public void addPath(Path p) {
		// Add path to start of path's adjacency list
		adj[p.getStartCode()].add(p);
		E++;
	}

	/**
	 * Get reference to path in graph
	 * 
	 * @param startIndex Index of start of path
	 * @param endIndex Index of end of path
	 * @return Desired path or null if it doesn't exist in graph
	 */
	public Path getPath(int startIndex, int endIndex) {
		// Use binary search on adjacency list to find edge
		int i = BinarySearch.pathSearch(adj[startIndex], endIndex);
		if (i == -1)
			return null;
		return adj[startIndex].get(i);
	}

	/**
	 * Get adjacency list for node
	 * 
	 * @param v Index of node to get adjacency list for
	 * @return Adjacency list of specified node
	 */
	public Iterable<Path> adj(int v) {
		return adj[v];
	}

	/**
	 * Get all edges in graph
	 * 
	 * @return All edges in graph
	 */
	public Iterable<Path> edges() {
		ArrayList<Path> bag = new ArrayList<Path>();
		for (int v = 0; v < V; v++)
			for (Path p : adj[v])
				bag.add(p);
		return bag;
	}
}

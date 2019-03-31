// Taken from page 655 of Algorithms (Fourth Edition), Sedgewick and Wayne

package algs;

import bixiTrip.Path;

/**
 * Shortest path algorithm for a edge weighted directed digraph
 * 
 * @author Caleb Mech
 *
 */
public class SP {
	private Path[] pathTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;
	
	private final int PATH_LEN_MIN = 10 * 60; // seconds
	private final int PATH_LEN_MAX = 28 * 60; // seconds
	private final int BIKE_SWITCH_PENALTY = 150; // seconds
	private final int PATH_COUNT_CUTOFF = 4; // min count for path

	/**
	 * Constructor for shortest path algorithm
	 * 
	 * @param G Input graph
	 * @param s Node to start algorithm at
	 */
	public SP(Graph G, int s) {
		pathTo = new Path[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());

		// Initialize weight of path to every node with
		// largest value
		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;

		pq.insert(s, 0.0);
		// Keep relaxing using the edges coming out of the
		// closest node (that hasn't had all edges relaxed)
		// until no more relaxing can be done (shortest path
		// tree has been obtained)
		while (!pq.isEmpty())
			relax(G, pq.delMin());
	}

	/**
	 * Relax paths coming out of given node
	 * 
	 * @param G Graph to relax in
	 * @param v Node to relax at
	 */
	private void relax(Graph G, int v) {
		// Look at all paths coming out of node V
		for (Path p : G.adj(v)) {
			// Get key of destination node
			int w = p.getEndCode();
				// Check if route would be faster than current best
			if (distTo[w] > distTo[v] + p.getDuration() + BIKE_SWITCH_PENALTY && 
					(p.getDuration() > PATH_LEN_MIN || !hasPathTo(w) || pathTo(w).size() == 1) &&
					// Make sure leg of trip isn't too long
					p.getDuration() < PATH_LEN_MAX &&
					// Make sure enough people have taken this path before
					// to ensure confidence in data
					p.getCount() >= PATH_COUNT_CUTOFF) {
				// Update the route with the new faster path
				distTo[w] = distTo[v] + p.getDuration() + BIKE_SWITCH_PENALTY;
				pathTo[w] = p;

				// Add / update selected node in priority queue
				if (pq.contains(w))
					pq.changeKey(w, distTo[w]);
				else
					pq.insert(w, distTo[w]);
			}
		}
	}

	/**
	 * Distance from start to given node
	 * 
	 * @param v Node to find distance to
	 * @return Distance to given node as double
	 */
	public double distTo(int v) {
		return distTo[v];
	}

	/**
	 * Check if a route more efficient than the default "unreachable" value has been
	 * found
	 * 
	 * @param v Check if there is a path to node
	 * @return Whether a path to node exists
	 */
	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	/**
	 * Path to given node
	 * 
	 * @param v Node to find path to
	 * @return Stack of paths to along route
	 */
	public Stack<Path> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Path> path = new Stack<Path>();
		for (Path p = pathTo[v]; p != null; p = pathTo[p.getStartCode()])
			path.push(p);
		return path;
	}
}

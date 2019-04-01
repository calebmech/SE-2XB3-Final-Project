package bixiTrip;

import java.util.ArrayList;

import algs.Graph;

/**
 * Abstract object that holds all Path instances
 * 
 * @author Caleb Mech
 *
 */

public class Paths {
	private final Graph graph;
	private final Stations stations;
	private static Paths instance = null;

	/**
	 * Getter for a singleton Paths object
	 * 
	 * @return Returns a single instance of the Paths object, whether one already
	 *         exists or not
	 */
	public static Paths getInstance() {
		if (instance == null)
			instance = new Paths();
		return instance;
	}

	/**
	 * Constructor for the Paths object
	 * 
	 */
	private Paths() {
		stations = Stations.getInstance();
		this.graph = new Graph();
	}

	/**
	 * Add a Path to the Paths object
	 * 
	 * @param path Path to add to the object
	 */
	public void addPath(Path path) {
		graph.addPath(path);
	}

	/**
	 * Get a Path that's stored in the Paths object
	 * 
	 * @param startCode Code of the Station where the Path starts
	 * @param endCode   Code of the Station where the Path end
	 * @return Requested Path if it exists in Paths or null
	 */
	public Path getPath(int startCode, int endCode) {
		return graph.getPath(startCode, endCode);
	}

	/**
	 * Import all PastTrip's into the Paths object
	 */
	public void importPastTrips() {
		PastTrips pastTrips = PastTrips.getInstance();

		int i = 0;
		ArrayList<PastTrip> nextPath;
		while (true) {

			nextPath = pastTrips.getNextPath();
			if (nextPath == null)
				return;

			for (PastTrip pastTrip : nextPath) {
				Path path = getPath(pastTrip.getStartCode(), pastTrip.getEndCode());

				if (path == null)
					addPath(new Path(pastTrip));
				else
					path.addPastTrip(pastTrip);
			}
			i++;
		}
	}

	/**
	 * Getter for Graph containing all Paths
	 * 
	 * @return Returns all Paths connected in a Graph
	 */
	public Graph getGraph() {
		return graph;
	}
}

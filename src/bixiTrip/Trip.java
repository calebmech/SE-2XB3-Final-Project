package bixiTrip;

import algs.Graph;
import algs.Queue;
import algs.SP;
import algs.Stack;

/**
 * Trip abstract data type that provides directions between two Stations
 * 
 * @author Caleb Mech
 *
 */

public class Trip {
	private final Station start;
	private final Station end;
	private final Queue<Station> route;
	private final Stations stations;
	private final SP sp;

	/**
	 * Constructor for Trip object
	 * 
	 * @param _start Code of Station to start from
	 * @param _end   Code of Station to end at
	 */
	public Trip(Station _start, Station _end) {
		this.start = _start;
		this.end = _end;
		this.route = new Queue<Station>();

		Paths paths = Paths.getInstance();
		Graph graph = paths.getGraph();

		this.stations = Stations.getInstance();
		this.sp = new SP(graph, start.getCode());

		if (!sp.hasPathTo(end.getCode()))
			throw new IllegalArgumentException("Stations are not connected.");

		Stack<Path> pathSeq = sp.pathTo(end.getCode());

		int i = pathSeq.size();
		for (Path path : pathSeq) {
			route.enqueue(stations.getStationByIndex(path.getStartIndex()));
			if (--i == 0)
				route.enqueue(stations.getStationByIndex(path.getEndIndex()));
		}
	}

	/**
	 * Get route between two Stations
	 * 
	 * @return Returns sequence of Stations to travel
	 */
	public Iterable<Station> getRoute() {
		return route;
	}

	/**
	 * Getter for duration of trip
	 * 
	 * @return Returns number of seconds a trip should take as an int
	 */
	public int getDuration() {
		return (int) Math.round(sp.distTo(end.getCode()));
	}

	/**
	 * Get URL for directions to travel a route
	 * 
	 * @return Returns string representation of directions URL
	 */
	public String getUrl() {
		String url = "https://www.google.com/maps/dir/?api=1";
		url += "&origin=" + route.dequeue().getCoords().toString();
		url += "&waypoints=";
		while (route.size() > 1) {
			url += route.dequeue().getCoords().toString() + "%7C";
		}
		url += "&destination=" + route.dequeue().getCoords().toString();
		url += "&travelmode=bicycling";
		url += "&dir_action=navigate";
		return url;
	}
}
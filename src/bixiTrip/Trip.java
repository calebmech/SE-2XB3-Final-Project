package bixiTrip;

import algs.Graph;
import algs.Queue;
import algs.SP;

/**
 * Trip abstract data type that provides directions
 * between two Stations
 * 
 * @author Caleb Mech &amp; Jonathan Janzen
 *
 */

public class Trip {
	private Station start;
	private Station end;
	private Queue<Station> route;
	private SP sp;

	/**
	 * Constructor for Trip object
	 * 
	 * @param _start 	Code of Station to start from
	 * @param _end		Code of Station to end at
	 */
	public Trip(Station _start, Station _end) {
		this.start = _start;
		this.end = _end;
		this.route = new Queue<Station>();
		
		Paths paths = Paths.getInstance();
		Graph graph = paths.getGraph();
		Stations stations = Stations.getInstance();

		this.sp = new SP(graph, start.getCode());
		Iterable<Path> pathSeq = sp.pathTo(end.getCode());

		pathSeq.forEach(path -> {
			route.enqueue(stations.getStationByIndex(path.getStartIndex()));
		});
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
			url += route.dequeue().getCoords().toString() + "|"; 
		}
		url += "&destination=" + route.dequeue().getCoords().toString();
		url += "&travelmode=bicycling";
		url += "&dir_action=navigate";
		return url;
	}
}
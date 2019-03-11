package bixiTrip;

import algs.Queue;

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
	private Boolean hasRoute = false;

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
	}

	/**
	 * Get route between two Stations
	 * 
	 * @return Returns sequence of Stations to travel
	 */
	public Iterable<Station> getRoute() {
		if (hasRoute == false) {
			Paths paths = Paths.getInstance();
			Stations stations = Stations.getInstance();
			Iterable<Path> pathSeq = paths.getPathSeq(start.getCode(), end.getCode());

			pathSeq.forEach(path -> {
				route.enqueue(stations.getStationByCode(path.getStationStart()));
			});
			hasRoute = true;
		}

		return route;
	}
	
	/**
	 * Get URL for directions to travel a route
	 * 
	 * @return Returns string representation of directions URL
	 */
	public String getUrl() {
		if (!hasRoute)
			getRoute();
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
package bixiTrip;

import algs.Queue;

public class Trip {
	private Station start;
	private Station end;
	private Queue<Station> route;

	public Trip(Station _start, Station _end) {
		this.start = _start;
		this.end = _end;
		this.route = new Queue<Station>();
	}

	public Queue<Station> getRoute() {
		if (route.size() == 0) {
			Paths paths = Paths.getInstance();
			Stations stations = Stations.getInstance();
			Iterable<Integer> path = paths.getPath(start.getCode(), end.getCode());

			path.forEach(stationCode -> {
				route.enqueue(stations.getStation(stationCode));
			});
		}

		return route;
	}
	
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
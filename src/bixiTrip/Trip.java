package bixiTrip;

import algs.Queue;

public class Trip {
	private Station start;
	private Station end;
	private Queue<Station> route;
	private Boolean hasRoute = false;

	public Trip(Station _start, Station _end) {
		this.start = _start;
		this.end = _end;
		this.route = new Queue<Station>();
	}

	public Iterable<Station> getRoute() {
		if (hasRoute == false) {
			Paths paths = Paths.getInstance();
			Stations stations = Stations.getInstance();
			Iterable<Path> pathSeq = paths.getPathSeq(start.getCode(), end.getCode());

			pathSeq.forEach(path -> {
				route.enqueue(stations.getStation(path.getStationStart()));
			});
			hasRoute = true;
		}

		return route;
	}
	
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
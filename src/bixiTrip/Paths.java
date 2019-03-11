package bixiTrip;

import algs.Graph;
import algs.SP;

public class Paths {
	private Graph graph;
	private Stations stations;

	private static Paths instance = null;

	public static Paths getInstance() {
		if (instance == null)
			instance = new Paths();
		return instance;
	}

	private Paths() {
		stations = Stations.getInstance();
		this.graph = new Graph(stations.size());
	}

	public void addPath(Path path) {
		graph.addPath(path);
	}
	
	public Path getPath(int startCode, int endCode) {
		return graph.getPath(stations.getIndex(startCode), stations.getIndex(endCode));
	}

	public void importPastTrips() {
		PastTrips pastTrips = PastTrips.getInstance();
		
		for (PastTrip pastTrip : pastTrips.getNextPath()) {
			Path path = getPath(pastTrip.getStationStart(), pastTrip.getStationEnd());

			if (path == null)
				addPath(new Path(pastTrip));
			else
				path.addPastTrip(pastTrip);
		}
	}

	public Iterable<Path> getPathSeq(int start, int end) {
		SP shortestPath = new SP(graph, start);
		return shortestPath.pathTo(end);
	}

//	public static void main(String[] args) {
//		PastTrip trip1 = new PastTrip(1, 2, 5);
//		PastTrip trip2 = new PastTrip(2, 3, 5);
//		PastTrip trip3 = new PastTrip(3, 4, 5);
//		Path path1 = new Path(trip1);
//		Path path2 = new Path(trip2);
//		Path path3 = new Path(trip3);
//
//		Paths paths = new Paths();
//		paths.addPath(path1);
//		paths.addPath(path2);
//		paths.addPath(path3);
//
//		Iterable<Path> route = paths.getPath(1, 3);
//		for (Integer station : route) {
//			System.out.println(station);
//		}
//	}
}

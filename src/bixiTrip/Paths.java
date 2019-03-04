package bixiTrip;

import algs.Graph;
import algs.BFS;

public class Paths {
	private Graph paths;
	
	private static Paths instance = null;
	
	private Paths(int size) {
		this.paths = new Graph(size);
	}
	
	public static Paths Paths(int size) {
		if (instance == null) 
			instance = new Paths(size);
		return instance;
	}
	
	public Iterable<Integer> getPath(int start, int end) {
		BFS bfs = new BFS(paths, start);
		return bfs.pathTo(end);
	}
	
	public void addPath(Path path) {
		paths.addEdge(path.getStationStart(), path.getStationEnd());
	}
	
	public static void main(String[] args) {
		PastTrip trip1 = new PastTrip(1, 2, 5);
		PastTrip trip2 = new PastTrip(2, 3, 5);
		PastTrip trip3 = new PastTrip(3, 4, 5);
		Path path1 = new Path(trip1);
		Path path2 = new Path(trip2);
		Path path3 = new Path(trip3);
		
		Paths paths = new Paths(5);
		paths.addPath(path1);
		paths.addPath(path2);
		paths.addPath(path3);
		
		Iterable<Integer> route = paths.getPath(1, 3);
		for (Integer station : route) {
			System.out.println(station);
		}
	}
}

package bixiTrip;

import algs.Graph;
import algs.BFS;

public class Paths {
	private Graph paths;
	
	private static Paths instance = null;
	
	private Paths() {
		this.paths = new Graph();
	}
	
	public static Paths Paths() {
		if (instance == null) 
			instance = new Paths();
		return instance;
	}
	
	public Iterable<Integer> getPaths(int start, int end) {
		BFS bfs = new BFS(paths, start);
		return bfs.pathTo(end);
	}
	
	public void addPath(Path path) {
		paths.addEdge(path.getStationStart(), path.getStationEnd());
	}
}

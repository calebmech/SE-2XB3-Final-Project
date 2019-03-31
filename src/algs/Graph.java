package algs;

import java.util.ArrayList;

import bixiTrip.Path;

public class Graph {
	private final int V;
	private int E;
	private ArrayList<Path>[] adj;

	public Graph(int _V) {
		this.V = 10003;
		this.E = 0;
		adj = (ArrayList<Path>[]) new ArrayList[V];
		for (int v = 0; v < V; v++)
			adj[v] = new ArrayList<Path>();
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addPath(Path p) {
		adj[p.getStartCode()].add(p);
		E++;
	}

	public Path getPath(int startIndex, int endIndex) {
		int i = BinarySearch.pathSearch(adj[startIndex], endIndex);
		if (i == -1)
			return null;
		return adj[startIndex].get(i);
	}

	public Iterable<Path> adj(int v) {
		return adj[v];
	}

	public Iterable<Path> edges() {
		ArrayList<Path> bag = new ArrayList<Path>();
		for (int v = 0; v < V; v++)
			for (Path p : adj[v])
				bag.add(p);
		return bag;
	}
}

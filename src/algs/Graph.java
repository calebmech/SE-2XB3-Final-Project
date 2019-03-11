package algs;

import bixiTrip.Path;

public class Graph {
	private final int V;
	private int E;
	private Bag<Path>[] adj;

	public Graph(int _V) {
		this.V = _V;
		this.E = 0;
		adj = (Bag<Path>[]) new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<Path>();
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addPath(Path p) {
		adj[p.getStartIndex()].add(p);
		E++;
	}
	
	public Path getPath(int startIndex, int endIndex) {
		for (Path p : adj[startIndex]) {
			if (p.getEndIndex() == endIndex) {
				return p;
			}
		}
		return null;
	}
	
	public Iterable<Path> adj(int v) {
		return adj[v];
	}
	
	public Iterable<Path> edges() {
		Bag<Path> bag = new Bag<Path>();
		for (int v = 0; v < V; v++)
			for (Path p : adj[v])
				bag.add(p);
		return bag;
	}
}

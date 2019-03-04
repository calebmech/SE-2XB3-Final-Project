package algs;

import java.util.ArrayList;

public class Graph {
	private int E;
	private ArrayList<Bag<Integer>> adj;

	public Graph() {
		this.E = 0;
		adj = new ArrayList<Bag<Integer>>();
	}

	public int V() {
		return adj.size();
	}

	public int E() {
		return E;
	}

	public void addEdge(int v, int w) {
		adj.get(v).add(w);
		E++;
	}
	
	public Iterable<Integer> adj(int v) {
		return adj.get(v);
	}
}

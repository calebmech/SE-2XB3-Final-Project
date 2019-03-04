package algs;

public class Graph {
	private final int V;
	private int E;
	private Bag<Integer>[] adj;

	public Graph(int _V) {
		this.V = _V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<Integer>();
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}

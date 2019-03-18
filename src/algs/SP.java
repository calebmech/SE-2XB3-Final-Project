package algs;

import bixiTrip.Path;

public class SP {
	private Path[] pathTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;
	
	private final int PATH_LEN_CUTOFF = 28 * 60; // seconds
	private final int BIKE_SWITCH_PENALTY = 60; // seconds
	private final int PATH_COUNT_CUTOFF = 4; // min count for path
	
	public SP(Graph G, int s) {
		pathTo = new Path[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());

		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;

		pq.insert(s, 0.0);
		while (!pq.isEmpty())
			relax(G, pq.delMin());
	}

	private void relax(Graph G, int v) {
		for (Path p : G.adj(v)) {
			int w = p.getEndCode();
			if (distTo[w] > distTo[v] + p.getDuration() + BIKE_SWITCH_PENALTY && 
					p.getDuration() < PATH_LEN_CUTOFF &&
					p.getCount() >= PATH_COUNT_CUTOFF) {
				distTo[w] = distTo[v] + p.getDuration() + BIKE_SWITCH_PENALTY;
				pathTo[w] = p;
				if (pq.contains(w))
					pq.changeKey(w, distTo[w]);
				else
					pq.insert(w, distTo[w]);
			}
		}
	}

	public double distTo(int v) {
		return distTo[v];
	}

	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	public Stack<Path> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Path> path = new Stack<Path>();
		for (Path p = pathTo[v]; p != null; p = pathTo[p.getStartCode()])
			path.push(p);
		return path;
	}
}

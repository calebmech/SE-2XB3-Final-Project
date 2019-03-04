package algs;

public class BFS {
	private boolean[] marked;
	private int[] edgeTo;
	private final int start;

	public BFS(Graph G, int _start) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.start = _start;
		bfs(G, _start);
	}

	private void bfs(Graph G, int start) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[start] = true;
		queue.enqueue(start);
		while (!queue.isEmpty()) {
			int v = queue.dequeue();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					queue.enqueue(w);
				}
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != start; x = edgeTo[x])
			path.push(x);
		path.push(start);
		return path;
	}
}

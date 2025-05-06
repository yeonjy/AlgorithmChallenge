import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int v1;
	int v2;
	int w;

	public Node(int v1, int v2, int w) {
		this.v1 = v1;
		this.v2 = v2;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}
}

public class Main {
	static int n;
	static int m;
	static int result;
	static PriorityQueue<Node> q;
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		q = new PriorityQueue<Node>();
		parent = new int[n + 1];

		for(int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}

		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			q.offer(new Node(v1,v2,w));
		}

		while(!q.isEmpty()) {
			Node node = q.poll();

			if(find(node.v1) != find(node.v2)) {
				union(node.v1,node.v2);
				result += node.w;
			}
		}

		System.out.println(result);
	}

	static void union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);

		if(p1 < p2) {
			parent[p2] = p1;
		}
		else {
			parent[p1] = p2;
		}
	}

	static int find(int v) {
		if(parent[v] == v) {
			return v;
		}
		return parent[v] = find(parent[v]);
	}
}
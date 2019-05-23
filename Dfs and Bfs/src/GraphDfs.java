import java.io.*; 
import java.util.*; 

class GraphDfs 
{ 
	private int V;
	private LinkedList<Integer> adj[];
	int cont =0;
	int vetor[]= new int[6];

	GraphDfs(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	void addEdge(int v, int w) 
	{ 
		adj[v].add(w);
	} 


	void DFSUtil(int v,boolean visited[]) 
	{ 
		visited[v] = true;
		vetor[v] = cont++;
		
		int x = 0;
		Iterator<Integer> i = adj[v].listIterator(); 
		while (i.hasNext()) 
		{ 
			int n = i.next();
			if (!visited[n]) {
				DFSUtil(n, visited);
			} 
		}
		for(int j = 0 ; j < vetor.length; j++) {
			System.out.printf(" %d",vetor[j]);
		}
		System.out.println();
	} 

	void DFS(int v) 
	{ 
		boolean visited[] = new boolean[V]; 
		DFSUtil(v, visited); 
	} 

	public static void main(String args[]) 
	{ 
		GraphDfs g = new GraphDfs(6); 

		g.addEdge(0, 2); 
		g.addEdge(0, 3); 
		g.addEdge(0, 4); 
		g.addEdge(1, 2); 
		g.addEdge(1, 4); 
		g.addEdge(2, 4);
		g.addEdge(3, 4); 
		g.addEdge(3, 5); 
		g.addEdge(4, 5);
		g.addEdge(5, 1); 
		/*
		 * g.addEdge(2, 4); g.addEdge(3, 4); g.addEdge(3, 5); g.addEdge(4, 5);
		 * g.addEdge(5, 1);
		 */
		g.DFS(0); 
	} 
} 

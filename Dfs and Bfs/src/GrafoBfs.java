import java.io.*; 
import java.util.*; 

class GrafoBfs 
{ 
	private int V; 
	private LinkedList<Integer> adj[]; 

	GrafoBfs(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	void addEdge(int v,int w) 
	{ 
		adj[v].add(w); 
	} 

	void BFS(int s) 
	{ 
		boolean visited[] = new boolean[V];
		int visitado[] = new int[V];
		int cont =0;
		LinkedList<Integer> queue = new LinkedList<Integer>(); 
		
		visited[s]=true;
		visitado[s] = cont++;
		queue.add(s); 
		

		while (queue.size() != 0) 
		{ 
			s = queue.poll(); 
			//System.out.print("["+s+"]"); 
			for(int i = 0 ; i < visitado.length; i++) {
				System.out.printf(" %d",visitado[i]);
			}
			System.out.println();
			
			Iterator<Integer> i = adj[s].listIterator(); 
			while (i.hasNext()) 
			{ 
				int n = i.next();
				if (!visited[n]) 
				{ 
					visited[n] = true;
					visitado[n] = cont++;
					queue.add(n); 
				} 
			} 
		} 
	} 

	public static void main(String args[]) 
	{ 
		GrafoBfs g = new GrafoBfs(6); 

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

		g.BFS(0); 
	} 
} 


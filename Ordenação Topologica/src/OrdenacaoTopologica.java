import java.io.*;
import java.util.*;

class OrdenacaoTopologica {
	private int V;
	private LinkedList<Integer> adj[];

	OrdenacaoTopologica(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void ordenTopologicaUtil(int v, boolean visitado[], Stack pilha) {
		visitado[v] = true;
		Integer i;
		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext()) {
			i = it.next();
			if (!visitado[i])
				ordenTopologicaUtil(i, visitado, pilha);
		}
		pilha.push(new Integer(v));
	}

	void ordenTopologica() {
		Stack pilha = new Stack();
		boolean visitado[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			visitado[i] = false;
		}
		for (int i = 0; i < V; i++) {
			if (visitado[i] == false) {
				ordenTopologicaUtil(i, visitado, pilha);
			}
		}
		while (pilha.empty() == false) {
			System.out.print("[" + pilha.pop() + "]" + " ");
		}
	}

	public static void main(String args[]) {
		OrdenacaoTopologica g = new OrdenacaoTopologica(13);

		g.addEdge(0, 6);
		g.addEdge(0, 1);
		g.addEdge(0, 5);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 5);
		g.addEdge(5, 4);
		g.addEdge(6, 4);
		g.addEdge(6, 9);
		g.addEdge(8, 7);
		g.addEdge(7, 6);
		g.addEdge(9, 10);
		g.addEdge(9, 11);
		g.addEdge(9, 12);
		g.addEdge(11, 12);

		System.out.printf("Ordem: ");
		g.ordenTopologica();
	}
}
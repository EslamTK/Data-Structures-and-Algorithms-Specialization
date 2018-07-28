package Week2;

import java.util.*;

public class Pro3 {
	static boolean visited[];
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt(), x, y;
		
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		ArrayList<Integer>[] revGraph = new ArrayList[n+1];
		
		for(int i=1;i<=n;++i) {
			graph[i] = new ArrayList<>();
			revGraph[i] = new ArrayList<>();
		}
		
		
		while(m > 0) {
			x = scan.nextInt();
			y = scan.nextInt();
			graph[x].add(y);
			revGraph[y].add(x);
			--m;
		}
		
		ArrayList connectedComponents = findConnectedComponents(graph, revGraph);

		System.out.println(connectedComponents.size());
		
	}
	
	public static ArrayList findConnectedComponents(ArrayList[] graph, ArrayList[] revGraph) {
		
		visited = new boolean[graph.length];
		ArrayList<Integer> postOrder = new ArrayList();
		
		for(int i=1;i<graph.length;++i) DFS(graph, i, postOrder);
		
		visited = new boolean[graph.length];
		ArrayList<ArrayList> components = new ArrayList();
		
		for(int i=postOrder.size()-1;i>=0;--i) {

			if(!visited[postOrder.get(i)]) {
				ArrayList<Integer> component = new ArrayList();
				DFS(revGraph, postOrder.get(i), component);
				components.add(component);
			}
		}
		return components;
	}
	
	public static void DFS(ArrayList[] graph, int node, ArrayList container) {
		
		if (visited[node]) return;
		
		visited[node] = true;

		for(int i=0;i<graph[node].size();++i) {
			
			int j = (int)graph[node].get(i);
				
			if(!visited[j]) DFS(graph, j, container);
		}
		
		container.add(node);
	}
}

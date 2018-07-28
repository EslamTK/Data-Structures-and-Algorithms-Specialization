package Week2;

import java.util.*;

public class Pro2 {
	static boolean[] visited, deleted;
	static Stack<Integer> order;
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt(), x, y;
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		
		for(int i=1;i<=n;++i) graph[i] = new ArrayList<>();
		
		while(m > 0) {
			x = scan.nextInt();
			y = scan.nextInt();
			graph[x].add(y);
			--m;
		}
		
		order = new Stack<>();
		visited = new boolean[n+1];
		deleted = new boolean[n+1];
		
		for(int i=1;i<=n;++i) {
			topogicalSort(graph, i);
		}
		
		while(!order.isEmpty()) {
			System.out.print(order.pop() + " ");
		}
	}
	
public static void topogicalSort(ArrayList[] graph, int node) {
	
	if (visited[node]) return;
		
	visited[node] = true;
	
	for(int i=0;i<graph[node].size();++i) {
		
		int j = (int)graph[node].get(i);
			
		if(!visited[j]) topogicalSort(graph, j);
	}
	
	deleted[node] = true;
	order.push(node);
	}
}
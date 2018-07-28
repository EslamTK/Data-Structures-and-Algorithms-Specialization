package Week3;

import java.util.*;

public class Pro1 {

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
			graph[y].add(x);
			--m;
		}
		x = scan.nextInt();
		y = scan.nextInt();
		
		System.out.println(BFS(graph, x, y));
	}
	
	public static int BFS(ArrayList[] graph, int u, int v) {
		Queue<Integer> que = new LinkedList<>();
		int[] dis = new int[graph.length];
		
		for (int i = 0; i < dis.length; i++) dis[i] = Integer.MAX_VALUE;
		
		dis[u] = 0;
		que.add(u);
		
		while(!que.isEmpty()) {
			
			int current = que.poll();

			for(int i=0;i<graph[current].size();++i) {
				
				int node = (int)graph[current].get(i);
				
				
				if(dis[node]==Integer.MAX_VALUE) {
					dis[node] = dis[current]+1;
					que.add(node);
				}
			
			}
		}
		
		return dis[v]==Integer.MAX_VALUE?-1:dis[v];
	}

}

package Week4;

import java.util.*;

public class Pro2 {

	private static Pro2 mainClass = new Pro2();
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt(), x, y, w;
		
		ArrayList<Pair>[] graph = new ArrayList[n+1];

		for(int i=1;i<=n;++i) graph[i] = new ArrayList<>();				

		while(m > 0) {
			x = scan.nextInt();
			y = scan.nextInt();
			w = scan.nextInt();
			graph[x].add(mainClass.new Pair(y, w));
			--m;
		}
		System.out.println(bellman(graph, 1, 1));
	}
	
	private static int bellman(ArrayList[] graph, int start, int end) {
		
		int[] dist = new int[graph.length];
		//int[] prev = new int[graph.length];
		
		for (int i = 0; i < graph.length; i++) dist[i] = 0;
		
		//dist[start] = 0;
		
		int relaxed = 0;
		
		for (int k = 1; k <= graph.length; k++) {
			
			for (int i = 1; i < graph.length; i++) {
				
				for (int j = 0; j < graph[i].size(); j++) {
				
					if(dist[((Pair) graph[i].get(j)).node] > dist[i] + ((Pair) graph[i].get(j)).weight) {
						
						dist[((Pair) graph[i].get(j)).node] = dist[i] + ((Pair) graph[i].get(j)).weight;
						//prev[((Pair) graph[i].get(j)).node] = i;
						
						relaxed = k;
					}
				
			    }
		    }
		}

		return relaxed<graph.length?0:1;
	}
	
	public class Pair
	{
		public int node;
		public int weight;
		public Pair(int node, int weight) 
		{
			this.node = node;
			this.weight = weight;
		}
	}
}

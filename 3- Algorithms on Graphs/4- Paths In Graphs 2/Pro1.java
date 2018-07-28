package Week4;

import java.util.*;

public class Pro1 {
	
	private static Pro1 mainClass = new Pro1();
	
	private final static Comparator<Pair> comp = new Comparator<Pair>() {
		
		@Override
		public int compare(Pair left, Pair right) {
			
			if(left.weight<right.weight) return -1;
			
			else if(left.weight==right.weight) return 0;
			
			else return 1;
			
		}

	};
	
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
		x = scan.nextInt();
		y = scan.nextInt();
		System.out.println(Dijkstra(graph, x, y));
	}
	
	private static int Dijkstra(ArrayList[] graph, int start, int end) {
		
		int[] dist = new int[graph.length];
		//int[] prev = new int[graph.length];
		
		for (int i = 0; i < graph.length; i++) dist[i] = Integer.MAX_VALUE;
		
		dist[start] = 0;
		
		PriorityQueue<Pair> priorityQue = new PriorityQueue(comp);
		
		for(int i=0;i<graph[start].size();++i) {
			dist[((Pair) graph[start].get(i)).node] = ((Pair) graph[start].get(i)).weight;
			priorityQue.add((Pair) graph[start].get(i));
		}
		
		while(!priorityQue.isEmpty()) {
			Pair min = priorityQue.poll();
			for(int i=0;i<graph[min.node].size();++i) {
				if(dist[((Pair) graph[min.node].get(i)).node] > dist[min.node] + ((Pair) graph[min.node].get(i)).weight) {
					dist[((Pair) graph[min.node].get(i)).node] = dist[min.node] + ((Pair) graph[min.node].get(i)).weight;
					//prev[((Pair) graph[min.node].get(i)).node] = min.node;
					priorityQue.add(mainClass.new Pair(((Pair) graph[min.node].get(i)).node, dist[((Pair) graph[min.node].get(i)).node]));
				}
			}
		}
		
		return dist[end]!=Integer.MAX_VALUE?dist[end]:-1;
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
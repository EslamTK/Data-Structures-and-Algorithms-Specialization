

import java.math.RoundingMode;
import java.text.DecimalFormat;
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
		int n = scan.nextInt(), x, y;
		double w;
		
		int[][] points = new int[n][2];
		
		ArrayList<Pair>[] graph = new ArrayList[n];

		for(int i=0;i<n;++i) {
			points[i][0] = scan.nextInt();;
			points[i][1] = scan.nextInt();
			graph[i] = new ArrayList<>();				
		}
		
		for(int i=0;i<n;++i) {
			x = points[i][0];
			y = points[i][1];
			for (int j = 0; j < n; j++) {
				if(i!=j) {
					w = Math.sqrt( ( (x-points[j][0]) * (x-points[j][0]) ) + ( (y-points[j][1]) * (y-points[j][1]) ) );
					graph[i].add(mainClass.new Pair(j, w));
				}
			}
		}
		
		DecimalFormat df = new DecimalFormat("#.#########");
		
		System.out.println(df.format(Prim(graph)));
	}
	
	private static double Prim(ArrayList[] graph) {
		
		int start = 0;
		boolean[] done = new boolean[graph.length];
		double[] dist = new double[graph.length];
		
		for (int i = 0; i < graph.length; i++) dist[i] = Float.MAX_VALUE;
		
		dist[start] = 0;
		done[start] = true;
		
		PriorityQueue<Pair> priorityQue = new PriorityQueue(comp);
		
		for(int i=0;i<graph[start].size();++i) {
			dist[((Pair) graph[start].get(i)).node] = ((Pair) graph[start].get(i)).weight;
			priorityQue.add((Pair) graph[start].get(i));
		}
		
		while(!priorityQue.isEmpty()) {
			
			Pair min = priorityQue.poll();
			
			done[min.node] = true;
			
			for(int i=0;i<graph[min.node].size();++i) {
				
				if(!done[((Pair) graph[min.node].get(i)).node] && dist[((Pair) graph[min.node].get(i)).node] > ((Pair) graph[min.node].get(i)).weight) {
					
					dist[((Pair) graph[min.node].get(i)).node] = ((Pair) graph[min.node].get(i)).weight;
					
					priorityQue.add(mainClass.new Pair(((Pair) graph[min.node].get(i)).node, dist[((Pair) graph[min.node].get(i)).node]));
				}
			}
		}
		
		double result = 0;
		for (int i = 0; i < dist.length; i++) result += dist[i];
		
		return result;
	}
	
	public class Pair
	{
		public int node;
		public double weight;
		public Pair(int node, double weight) 
		{
			this.node = node;
			this.weight = weight;
		}
	}
}
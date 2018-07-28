package Week4;
import java.util.*;

public class Pro3 {

	private static Pro3 mainClass = new Pro3();
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

		bellman_exchange(graph, x, -1);
	}
	
	private static void bellman_exchange(ArrayList[] graph, int start, int end) {
		
		boolean[] negative = new boolean[graph.length]; 
		long[] dist = new long[graph.length];
		//int[] prev = new int[graph.length];
		
		for (int i = 0; i < graph.length; i++) dist[i] = Integer.MAX_VALUE;
		
		dist[start] = 0;
		
        for (int k = 1; k <= 1+graph.length; k++) {
			
			for (int i = 1; i < graph.length; i++) {
				
				for (int j = 0; j < graph[i].size(); j++) {
				
					if(dist[((Pair) graph[i].get(j)).node] > dist[i] + ((Pair) graph[i].get(j)).weight) {
						
						dist[((Pair) graph[i].get(j)).node] = dist[i] + ((Pair) graph[i].get(j)).weight;
						//prev[((Pair) graph[i].get(j)).node] = i;
						
						if(k>=graph.length) {
							//System.out.println(((Pair) graph[i].get(j)).node);
							negative[((Pair) graph[i].get(j)).node] = true;
						}
					}
				
			    }
		    }
		}
        
        for (int i = 1; i < dist.length; i++) {
			if(dist[i]==Integer.MAX_VALUE) System.out.println('*');
			else if(negative[i]) System.out.println('-');
			else System.out.println(dist[i]);
		}
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

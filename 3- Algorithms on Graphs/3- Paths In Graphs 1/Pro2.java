package Week3;

import java.util.*;

public class Pro2 {

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
		
		System.out.println(isBipartite(graph)?1:0);
	}
	
	public static boolean isBipartite(ArrayList[] graph) {
		Queue<Integer> que = new LinkedList<>();
		int BLACK = 0, WHITE = 1, UNPROCESSED = -1;
		int[] colors = new int[graph.length];
		
		for (int i = 0; i < colors.length; i++) colors[i] = UNPROCESSED;
		
		for (int i = 1; i < graph.length; i++) {
			
			if(colors[i]==UNPROCESSED){
				
				que.add(i);
				colors[i] = BLACK;
						
				while(!que.isEmpty()) {
					
					int current = que.poll();
					int color = 1 - colors[current];
					
					for(int j=0;j<graph[current].size();++j) {
						
						int node = (int)graph[current].get(j);
						
						if(colors[node]==UNPROCESSED) {
							colors[node] = color;
							que.add(node);
						}
						else if(colors[node]!=color) return false;
					}
				}
			}
		}
		
		return true;
	}

}

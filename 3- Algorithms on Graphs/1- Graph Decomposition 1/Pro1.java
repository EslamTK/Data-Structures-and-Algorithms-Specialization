package Week1;
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

		System.out.println(checkConnectivity(graph, scan.nextInt(), scan.nextInt()));
	}
	
	public static int checkConnectivity(ArrayList[] graph, int u, int v) {
		Queue<Integer> que = new LinkedList<>();
		boolean[] visited = new boolean[graph.length];
		que.add(u);
		
		while(!que.isEmpty()) {
			
			int current = que.poll();

			for(int i=0;i<graph[current].size();++i) {
				
				int node = (int)graph[current].get(i);
				
				if(node==v) return 1;
				
				if(!visited[node]) {
					visited[node] = true;
					que.add(node);
				}
			
			}
		}
		return 0;
	}

}

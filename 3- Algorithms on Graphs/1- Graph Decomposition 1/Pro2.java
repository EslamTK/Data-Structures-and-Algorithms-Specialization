package Week1;
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

		System.out.println(checkConnectivity(graph));
	}
	
	public static int checkConnectivity(ArrayList[] graph) {
		Queue<Integer> que = new LinkedList<>();

		boolean[] visited = new boolean[graph.length];
		
		int count = 0;
		
		for(int i=1;i<graph.length;++i) {
			if(!visited[i]) {
				
				++count;
				que.add(i);
				visited[i] = true;
				while(!que.isEmpty()) {
					
					int current = que.poll();
	
					for(int j=0;j<graph[current].size();++j) {
						
						int node = (int)graph[current].get(j);
						
						if(!visited[node]) {
							visited[node] = true;
							que.add(node);
						}
					}
				}
			}
		}
		return count;
	}

}

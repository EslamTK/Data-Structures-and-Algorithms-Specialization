package Week2;

import java.util.*;

public class Pro1 {
	static int status[];
	static int WAITING = 0, PROCCESSING = 1, FINISHED = 2;
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt(), x, y;
		
		status = new int[n+1];
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		
		
		for(int i=1;i<=n;++i) {
			status[i] = WAITING;
			graph[i] = new ArrayList<>();
		}
		
		while(m > 0) {
			x = scan.nextInt();
			y = scan.nextInt();
			graph[x].add(y);
			--m;
		}
		
		//Recursive Approach Using Statuses
		for(int i=1;i<=n;++i) {
			if(checkCycle(graph, i)) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
		
		//Iterative Approach By Checking The Opening Node
		//System.out.println(checkCycleIterative(graph));
	}
	
	public static boolean checkCycle(ArrayList[] graph, int node) {
		
		if (status[node]==FINISHED) return false;
			
		status[node] = PROCCESSING;
		
		for(int i=0;i<graph[node].size();++i) {
			
			int j = (int)graph[node].get(i);
				
			if(status[j]==PROCCESSING) return true;
			
			if(status[j]==WAITING && checkCycle(graph, j)) return true;
		}
		
		status[node] = FINISHED;
		
		return false;
	}
	
	
	public static int checkCycleIterative(ArrayList[] graph) {
		
		Stack<Integer> que = new Stack<>();
		
		boolean[] visited = new boolean[graph.length];
		
		for(int i=1;i<graph.length;++i) {
			    
			visited = new boolean[graph.length];
			que.push(i);
				
			while(!que.isEmpty()) {
					
				int current = que.pop();
				visited[current] = true;
	
				for(int j=0;j<graph[current].size();++j) {
						
					int node = (int)graph[current].get(j);
						
					if(!visited[node]) {
						que.push(node);
					} 
					if(node == i) {
						return 1;
					}
					}
				}
			}
		return 0;
	}

}

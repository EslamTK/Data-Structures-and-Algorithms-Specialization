package Week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pro3 
{
	static int[][] packets;
	static long[] output;
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
        int s = scan.nextInt(), n = scan.nextInt();
        packets = new int[n][2];
        output = new long[n];
        for (int i = 0; i < n; i++) 
        {
		  	packets[i][0] = scan.nextInt();
		  	packets[i][1] = scan.nextInt();
		}
        if(n>0) simulation(s);
        for (int i = 0; i < n; i++) {
        	System.out.println(output[i]);	
		}
	}
	private static void simulation(int s)
	{
		Long T = (long) 0, finish = (long) 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<packets.length;++i)
        {
        	if(finish<=packets[i][0] && !que.isEmpty()) 
        	{
        		int next = que.poll();
    	        T = Math.max(T, packets[next][0]);
    	        output[next] = T;
    	        T += packets[next][1];
    	        if(!que.isEmpty()) {
    	        	int temp = que.peek();
    	        	finish = Math.max(finish, packets[temp][0]) + packets[temp][1];
    	        }
        	}
        	
        	if(que.isEmpty()) {
        		que.add(i);
        		finish = Math.max(finish, packets[i][0]) + packets[i][1];
        	}
        	else if(que.size()<s) {
        		que.add(i);
        	}
        	else {
        		output[i] = -1;
        	}
        }
        while(!que.isEmpty()) {
    		int next = que.poll();
	        T = Math.max(T, packets[next][0]);
	        output[next] = T;
	        T += packets[next][1];
    	}
	}
}

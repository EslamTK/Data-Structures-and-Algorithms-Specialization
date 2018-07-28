package Week1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.management.Query;

public class Pro2 
{
	static ArrayList[] tree;
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(),node,root = 0;
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) 
        {
		  	node = scan.nextInt();
		  	if(node==-1) root = i;
		  	else
		  	{
		  		if(tree[node]==null) tree[node] = new ArrayList<Integer>();
		  		tree[node].add(i);
		  	}
		}
        System.out.println(getTreeHight(root));
	}
	private static int getTreeHight(int node)
	{
		int height = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (queue.isEmpty()==false) 
        {
			int n = queue.size();
			while (n > 0) 
			{
				node = queue.poll();
				if (tree[node] != null) 
				{
					for (int i = 0; i < tree[node].size(); i++) 
					{
						queue.add((int) tree[node].get(i));
					}
				}
				--n;
			}
			++height;
        }
		
		return height;
	}
}

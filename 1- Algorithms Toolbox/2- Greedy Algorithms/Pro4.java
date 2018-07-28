package Week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Pro4 
{
    class Point implements Comparable<Point>
    {
        int x,y;
        public Point(int x,int y) 
        {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point p) 
		{
			if(x>p.x || (x==p.x && y>p.y)) return 1;
			else if(x<p.x ||  (x==p.x && y<p.y)) return -1;
			return 0;
		}
    	
    }
	public static void main(String[] args)
	{
	 Scanner scan = new Scanner(System.in);
	 Pro4 mainClass = new Pro4();
	 int n = scan.nextInt(),y = -1;
	 Point[] Points = new Point[n];
	 ArrayList<Integer> Array = new ArrayList<>();
	 for (int i = 0; i < n; i++) 
	 {
	  	Points[i] = mainClass.new Point(scan.nextInt(),scan.nextInt());
	 }
	 Arrays.sort(Points);
	 y = Points[0].y;
	 for (int i = 0; i < Points.length; i++) 
	 {
		if(Points[i].x <= y && Points[i].y < y) y = Points[i].y;
		else if(Points[i].x>y)
	    {
			Array.add(y);
	    	y = Points[i].y;
	    }
	 }
	 Array.add(y);
	 System.out.println(Array.size());
	 for (Iterator iterator = Array.iterator(); iterator.hasNext();) {
		Integer integer = (Integer) iterator.next();
		System.out.print(integer + " ");
	}
	}
}

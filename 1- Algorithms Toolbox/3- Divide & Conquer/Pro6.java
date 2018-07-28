package Week3;
import java.sql.Ref;
import java.util.Arrays;
import java.util.Scanner;

public class Pro6 
{
	class Pair implements Comparable<Pair>
	{
        public int x;
        public int y;
        public Pair(int x,int y) 
        {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pair pair) 
		{
			if(x>pair.x || (x==pair.x && y>pair.y))
			{
				return 1;
			}
			else if(x<pair.x || (x==pair.x && y<pair.y))
			{
				return -1;
			}
			return 0;
		}
	}
	public static void main(String[] args)
	{
	 Scanner scan = new Scanner(System.in);
	 Pro6 mainClass = new Pro6();
	 int n = scan.nextInt(),x,y;
	 double min = Double.MAX_VALUE;
	 Pair[] Array = new Pair[n];
	 for (int i = 0; i < n; i++) 
	 {
		x = scan.nextInt();
		y = scan.nextInt();
		Array[i] = mainClass.new Pair(x,y);
	 }
	 Arrays.sort(Array);
	 for (int i = 1; i < n; i++) 
	 {;
		min = Math.min(Math.sqrt((Array[i].x-Array[i-1].x)*(Array[i].x-Array[i-1].x)+
				                 (Array[i].y-Array[i-1].y)*(Array[i].y-Array[i-1].y)), min);
		System.out.println(min);
	 }
	 System.out.println(min);
	}
}

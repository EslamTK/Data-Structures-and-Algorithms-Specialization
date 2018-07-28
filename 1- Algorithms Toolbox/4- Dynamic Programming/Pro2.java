package Week4;
import java.util.Scanner;

public class Pro2 {

	public static void main(String[] args)
	{
	 Scanner scan = new Scanner(System.in);
	 int w = scan.nextInt() , n = scan.nextInt();
	 int[] golds = new int[n];
	 
	 for (int i = 0; i < golds.length; i++) 
	 {
		golds[i] = scan.nextInt();
	 }
	 
	int[][] Table = new int[n+1][w+1];
	
	for (int i = 0; i <= n; i++) Table[i][0] = 0;
	for (int i = 0; i <= w; i++) Table[0][i] = 0;
	
	for (int i = 1; i <= n; i++) 
	{
		for (int j = 1; j <= w; j++) 
		{
			Table[i][j] = Table[i-1][j];
			
			if(j>=golds[i-1])
			{
				Table[i][j] = Math.max(Table[i][j], Table[i-1][j-golds[i-1]]+golds[i-1]);
			}
		}
	}
	System.out.println(Table[n][w]);
	}
}

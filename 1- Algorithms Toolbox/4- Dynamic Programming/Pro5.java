package Week4;
import java.util.Scanner;

public class Pro5 {

	public static void main(String[] args)
	{
	 Scanner scan = new Scanner(System.in);
	 int[][] Arr = new int[3][];
	 for (int i = 0; i < 3; i++) 
	 {
	  	int n = scan.nextInt();
	  	Arr[i] = new int[n];
	  	for (int j = 0; j < n; j++) 
	  	{
			Arr[i][j] = scan.nextInt();
		}
	 }
	 
	int[][][] Table = new int[Arr[0].length+1][Arr[1].length+1][Arr[2].length+1];
	
	for (int i = 0; i <= Arr[0].length; i++) Table[i][0][0] = 0;
	for (int i = 0; i <= Arr[1].length; i++) Table[0][i][0] = 0;
	for (int i = 0; i <= Arr[2].length; i++) Table[0][0][i] = 0;
	
	for (int i = 1; i <= Arr[0].length; i++) 
	{
		for (int j = 1; j <= Arr[1].length; j++) 
		{
			for (int k = 1; k <= Arr[2].length; k++) 
			{
				if(Arr[0][i-1]==Arr[1][j-1] && Arr[1][j-1]==Arr[2][k-1])
				{
					Table[i][j][k] = Table[i-1][j-1][k-1] + 1;
				}
				else
				{
					Table[i][j][k] = Math.max(Math.max(Table[i-1][j][k], Table[i][j-1][k]), 
			                                           Table[i][j][k-1]);
				}
			}
		}
	}
	System.out.println(Table[Arr[0].length][Arr[1].length][Arr[2].length]);
	}
}

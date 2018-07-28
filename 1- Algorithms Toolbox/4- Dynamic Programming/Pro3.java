package Week4;
import java.util.Scanner;

public class Pro3 {

	public static void main(String[] args)
	{
	 Scanner scan = new Scanner(System.in);
	 String a = scan.nextLine(),b = scan.nextLine();
	int[][] Table = new int[a.length()+1][b.length()+1];
	for (int i = 0; i <= a.length(); i++) Table[i][0] = i;
	for (int i = 0; i <= b.length(); i++) Table[0][i] = i;
	
	for (int i = 1; i <= a.length(); i++) 
	{
		for (int j = 1; j <= b.length(); j++) 
		{
			if(a.charAt(i-1)==b.charAt(j-1))
			{
				Table[i][j] = Math.min(Table[i-1][j-1],Math.min(Table[i-1][j],Table[i][j-1])+1);
			}
			else
			{
				Table[i][j] = Math.min(Table[i-1][j-1],Math.min(Table[i-1][j],Table[i][j-1]))+1;
			}
		}
	}
	System.out.println(Table[a.length()][b.length()]);
	}
}

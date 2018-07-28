package Week3;
import java.sql.Ref;
import java.util.Scanner;

public class Pro4 {

	public static void main(String[] args)
	{
	 Scanner scan = new Scanner(System.in);
	 int n = scan.nextInt();
	 int count = 0;
	 int[] Array = new int[n];
	 for (int i = 0; i < n; i++) 
	 {
		Array[i] = scan.nextInt();
	 }
	 for (int i = 1; i < n; i++) 
	 {
		int key = Array[i],j = i-1;
		for (;j >= 0;j--) 
		{
			if(Array[j]>key)
			{
				Array[j+1] = Array[j];
				++count;
			}
			else break;
		}
		Array[j+1] = key;
	 }
	 System.out.println(count);
	}
}

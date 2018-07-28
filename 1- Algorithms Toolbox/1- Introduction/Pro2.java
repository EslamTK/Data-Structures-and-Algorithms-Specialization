package Week1;
import java.util.Scanner;

public class Pro2 {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] Arr = new int[n+1];
		Arr[0] = 0;
		Arr[1] = 1;
		for(int i=2;i<=n;++i)
		{
			Arr[i] = (Arr[i-1] + Arr[i-2])%10;
		}
		System.out.println(Arr[n]);
	}

}

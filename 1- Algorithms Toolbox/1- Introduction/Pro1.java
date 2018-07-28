package Week1;
import java.util.Scanner;

public class Pro1 {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = 25;
		int[] Arr = new int[n+2];
		int[] sum = new int[n+2];
		Arr[0] = 0;
		Arr[1] = 1;
		for(int i=2;i<=n;++i)
		{
			Arr[i] = Arr[i-1] + Arr[i-2];
		}
		sum[0] = 0;
		for(int i=1;i<=n;++i)
		{
		   for(int j=i;j>=0;--j)
		   {
			   sum[i] += Arr[j];
		   }
		   System.out.println(sum[i]-sum[i-1]);
		}
		
	}

}

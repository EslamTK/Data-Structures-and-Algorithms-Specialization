package Week1;
import java.math.BigInteger;
import java.util.Scanner;

public class Pro5 {
	
	public static void main(String[] args) 
	{
	Scanner scan = new Scanner(System.in);
	long n = scan.nextLong();
	int m = scan.nextInt(),count = 0,nth;
	boolean check = false,done = false;
	int Arr[] = new int[200000];
	Arr[0] = 0;
	Arr[1] = 1;
	for(int i=2;i<=n;++i)
	{
		Arr[i] = (Arr[i-1]+Arr[i-2]);
		++count;
		if(Arr[i]>=m) Arr[i] %= m; 
		if(check)
		{
			if(Arr[i]==1)
			{
				done = true;
				break;
			}
			else check = false;
		}
		
		if(Arr[i]==0) check = true;
	}
	System.out.println(count);
	nth = (int)(done?n%count:n);
	System.out.println(Arr[nth]);
    }
	
}

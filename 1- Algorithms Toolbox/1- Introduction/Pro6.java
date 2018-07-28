package Week1;
import java.util.Scanner;

public class Pro6 {
	
	public static void main(String[] args) 
	{
	Scanner scan = new Scanner(System.in);
	long n = scan.nextLong();
	n += 2; 
	n %= 60;
	int[] Arr = new int[(int)(n+1)];
	Arr[0] = 0;
	Arr[1] = 1;
	for(int i=2;i<=n;++i)
	{
		Arr[i] = (Arr[i-1] + Arr[i-2])%10;
	}
	System.out.println((Arr[(int) n]-1)<0?9:Arr[(int) n]-1);
    }
	
}

package Week1;
import java.util.Scanner;

public class Pro4 {

	public static void main(String[] args) 
	{
		
	Scanner scan = new Scanner(System.in);
	long a = scan.nextInt() , b = scan.nextInt() , res = 0;
	
	if(a>b) res = GCD(a,b);
	else res = GCD(b,a);
	
	System.out.println((a*b)/res);
    }
	private static long GCD(long a,long b)
	{
		if(b==0) return a;
		
		return GCD(b,a%b);
	}

}

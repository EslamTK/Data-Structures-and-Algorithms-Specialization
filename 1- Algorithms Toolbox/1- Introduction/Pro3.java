package Week1;
import java.util.Scanner;

public class Pro3 
{
	public static void main(String[] args) 
	{
	Scanner scan = new Scanner(System.in);
	int a = scan.nextInt() , b = scan.nextInt() , res = 0;
	
	if(a>b) res = GCD(a,b);
	else res = GCD(b,a);
	
	System.out.println(res);
    }
	private static int GCD(int a,int b)
	{
		if(b==0) return a;
		
		return GCD(b,a%b);
	}
}

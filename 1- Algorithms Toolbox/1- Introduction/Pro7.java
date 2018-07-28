package Week1;
import java.util.Scanner;

public class Pro7 {
	
	public static void main(String[] args) 
	{
	Scanner scan = new Scanner(System.in);
	long m = scan.nextLong(),n = scan.nextLong();
	n += 2; 
	n %= 60;
	m += 1; 
	m %= 60;
	int[] Arr = new int[(int)(n+1)];
	Arr[0] = 0;
	Arr[1] = 1;
	for(int i=2;i<=n;++i)
	{
		Arr[i] = (Arr[i-1] + Arr[i-2])%10;
	}
	int nRes = (Arr[(int) n]-1)<0?9:Arr[(int) n]-1;
	int mRes = (Arr[(int) m]-1)<0?9:Arr[(int) m]-1;
	if(nRes<mRes) nRes += 10;
	nRes -= mRes;
	System.out.println(nRes);
    }
	
}

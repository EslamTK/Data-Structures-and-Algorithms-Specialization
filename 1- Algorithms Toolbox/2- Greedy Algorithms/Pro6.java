package Week2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Pro6 
{
	public static void main(String[] args)
	{
	 //test();
	 Scanner scan = new Scanner(System.in);
	 int n = scan.nextInt();
	 String[] Arr = new String[n];
	 for (int i = 0; i < Arr.length; i++) {
		Arr[i] = scan.next();
	}
	 int maxindex = 0;
	 for (int i = 0; i < Arr.length; i++) 
	 {
		maxindex = 0;
		for (int j = 0; j < Arr.length; j++) 
		{
		if(Arr[j].equals("0")==false && maxString(Arr[j], Arr[maxindex])==1) maxindex = j;
	    }
		System.out.print(Arr[maxindex]);
		Arr[maxindex] = "0";
	 }
	}
	private static void test()
	{
		Random random = new Random();
		while(true)
		{
		int n = random.nextInt(101);
		 String[] Arr = new String[n];
		 for (int i = 0; i < Arr.length; i++) {
			Arr[i] = String.valueOf(random.nextInt(1001));
		}
		 int maxindex = 0;
		 for (int i = 0; i < Arr.length; i++) 
		 {
			maxindex = 0;
			for (int j = 0; j < Arr.length; j++) 
			{
			if(maxString(Arr[j], Arr[maxindex])!=testmaxString(Arr[j], Arr[maxindex]))
			{
				System.out.println(Arr[j] + " " + Arr[maxindex]);
			}
		    }
			Arr[maxindex] = "0";
		 }
		}
	}
	private static int maxString(String s1,String s2)
	{
		String A = s1 + s2;
		String B = s2 + s1;
		for (int i = 0;i<A.length();++i) 
		{
			if(A.charAt(i)<B.charAt(i)) return 2;
			else if(B.charAt(i)<A.charAt(i)) return 1;
		}
		return 2;
	}
	private static int testmaxString(String s1,String s2)
	{
		for (int i = 0,j = 0;;) 
		{
			if(s1.charAt(i)<s2.charAt(j))
			{
				return 2;
			}
			else if(s2.charAt(j)<s1.charAt(i))
			{
				return 1;
			}
			if(i >= s1.length()-1 && j >= s2.length()-1) break;
			if(i < s1.length()-1) ++i;
			if(j < s2.length()-1) ++j;
		}
		return 2;
	}
}

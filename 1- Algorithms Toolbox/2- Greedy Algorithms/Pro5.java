package Week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Pro5 {

	public static void main(String[] args)
	{
	 Scanner scan = new Scanner(System.in);
	 int n = scan.nextInt();
	 ArrayList<Integer> Array = new ArrayList();
	 for(int i=1;i<=n;++i)
	 {
		 if((n-i)>=i+1)
		 {
			 Array.add(i);
			 n -= i;
		 }
		 else
		 {
			 Array.add(n);
			 break;
		 }
	 }
	 System.out.println(Array.size());
	 for (Iterator iterator = Array.iterator(); iterator.hasNext();) {
		Integer num = (Integer)iterator.next();
		System.out.print(num + " ");
	}
	}
}

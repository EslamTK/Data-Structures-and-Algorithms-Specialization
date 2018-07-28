package Week2;

import java.util.Arrays;
import java.util.Scanner;

public class Pro3 {

	public static void main(String[] args)
	{
	 Scanner scan = new Scanner(System.in);
	 int n = scan.nextInt();
	 long total = 0;
	 long[] revenus = new long[n];
	 long[] clicks = new long[n];
	 for (int i = 0; i < n; i++) revenus[i] = scan.nextLong();
	 for (int i = 0; i < n; i++) clicks[i] = scan.nextLong();
	 Arrays.sort(revenus);
	 Arrays.sort(clicks);
	 for (int i = 0; i < n; i++) {
		 total += revenus[i]*clicks[i];
	}
	 System.out.println(total);
	}
}

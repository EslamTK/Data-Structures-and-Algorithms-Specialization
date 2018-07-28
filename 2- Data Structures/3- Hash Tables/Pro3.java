package Week4;
import java.util.Scanner;

public class Pro3 {
	static long[] arr;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String p = scan.next(), t = scan.next();
        arr = new long[t.length()];
        preComputeHash(t, p);
        long pHash = getHash(p);
        for (int i = 0; i <= t.length()-p.length(); i++) {
			if(pHash==arr[i])
			{
				if(t.substring(i, i+p.length()).equals(p)) System.out.print(i + " ");
			}
		}
	}

	private static long preComputeHash(String t,String s) {
		int x = 2;
		long p = 1000000000000007L;
		long hash = 0,previous = 1;
		for(int i=0;i<s.length();++i)
		{
			previous *= x;
			if (previous > p) previous %= p;
		}
		for (int i = t.length() - 1; i >= 0; i--) {
			hash *= x;
			hash += (int) t.charAt(i);
			if(i+s.length()<=t.length()-1) hash -= previous * t.charAt(i+s.length());
			if (hash > p) hash %= p;
			arr[i] = hash;
		}
		return hash;
	}
	private static long getHash(String t) {
		int x = 2;
		long p = 1000000000000007L;
		long hash = 0;
		for (int i = t.length() - 1; i >= 0; i--) {
			hash *= x;
			hash += (int) t.charAt(i);
			if (hash > p) hash %= p;
		}
		return hash;
	}
}

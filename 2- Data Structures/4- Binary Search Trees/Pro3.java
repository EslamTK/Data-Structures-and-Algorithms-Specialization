package Week6;
import java.util.ArrayList;
import java.util.Scanner;

public class Pro3 
{
	static long tree[][];
	public static void main(String[] args) 
	{   
        new Thread(null, new Runnable() {
            public void run() {
                try {
            		Scanner scan = new Scanner(System.in);
                    int n = scan.nextInt();
                    if(n==0) {
                    	System.out.println("CORRECT");
                    	return;
                    }
                    tree = new long[n][3];
                    for(int i=0;i<n;++i) {
                    	tree[i][0] = scan.nextLong();
                    	tree[i][1] = scan.nextInt();
                    	tree[i][2] = scan.nextInt();
                    }
                    scan.close();
                    if(isBST(0, Long.MIN_VALUE, Long.MAX_VALUE)) System.out.println("CORRECT");
                    else System.out.println("INCORRECT");

                } catch (Exception e) {
                }
            }
        }, "1", 1 << 26).start();
	}
	private static boolean isBST(int i, long min, long max) {
		
		if(i==-1) return true;
		
		if(tree[i][0] < min || tree[i][0] >= max) return false;
		
		
		return isBST((int) tree[i][1], min, tree[i][0]) & isBST((int) tree[i][2], tree[i][0], max);
	}
}

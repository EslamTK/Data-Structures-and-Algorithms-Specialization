package Week6;
import java.util.ArrayList;
import java.util.Scanner;

public class Pro1 
{
	static ArrayList<Integer>[] output;
	static int tree[][];
	public static void main(String[] args) 
	{   
        new Thread(null, new Runnable() {
            public void run() {
                try {
            		Scanner scan = new Scanner(System.in);
                    int n = scan.nextInt();
                    tree = new int[n][3];
                    for(int i=0;i<n;++i) {
                    	tree[i][0] = scan.nextInt();
                    	tree[i][1] = scan.nextInt();
                    	tree[i][2] = scan.nextInt();
                    }
                    scan.close();
                    output = new ArrayList[3];
                    output[0] = new ArrayList();
                    output[1] = new ArrayList();
                    output[2] = new ArrayList();
                    printTree(0);
                    for (int i = 0; i < 3; i++) {
            			for (int j = 0; j < n; j++) {
            				System.out.print(output[i].get(j) + " ");
            			}
            			System.out.println();
            		}
                } catch (Exception e) {
                }
            }
        }, "1", 1 << 26).start();
	}
	private static void printTree(int i) {
		
		output[1].add(tree[i][0]);
		
		if(tree[i][1]!=-1) {
			printTree(tree[i][1]);
		}
		
		output[0].add(tree[i][0]);
		
		if(tree[i][2]!=-1) {
			printTree(tree[i][2]);
		}
		
		output[2].add(tree[i][0]);
	}
}

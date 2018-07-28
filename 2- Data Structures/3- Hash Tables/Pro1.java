package Week4;
import java.util.ArrayList;
import java.util.Scanner;

public class Pro1 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] arr = new String[10000000];
        int num;
        String command,name;
        for (int i = 0; i < n; i++) {
		    command = scan.next();
		    switch (command) {
			case "add":
				num = scan.nextInt();
				name = scan.next();
				arr[num] = name;
				break;
			case "find":
				 num = scan.nextInt();
				 if(arr[num]==null) System.out.println("not found");
				 else System.out.println(arr[num]);
			     break;
			default:
				num = scan.nextInt();
				arr[num] = null;
				break;
			}
		}
	}
}

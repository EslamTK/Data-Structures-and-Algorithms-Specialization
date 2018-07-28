package Week2;
import java.util.Scanner;

public class Pro1 {

	public static void main(String[] args)
	{
	 Scanner scan = new Scanner(System.in);
	 int m = scan.nextInt();
	 int ten = m/10;
	 int five = (m-(ten*10))/5;
	 int one = m-(ten*10+five*5);
	 System.out.println(ten+five+one);
	}

}

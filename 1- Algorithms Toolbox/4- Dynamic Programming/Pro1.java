package Week4;
import java.util.Scanner;

public class Pro1 {

	public static void main(String[] args)
	{
	 Scanner scan = new Scanner(System.in);
	 int n = scan.nextInt();
	 int[] Op = new int[n+1];
	 Op[1] = 0;
	 for(int i=2;i<=n;++i)
	 {
	   Op[i] = Op[i-1]+1;
	   
	   if(i%3==0) Op[i] = Math.min(Op[i],Op[i/3]+1);
	   
	   if(i%2==0) Op[i] = Math.min(Op[i],Op[i/2]+1);
	   
	 }
	 int[] out = new int[Op[n]+1];
	 out[out.length-1] = n;
	 int j = out.length-2;
	 for(int i=n;i>1;)
	 {
	   if(i%3==0 && Op[i]==Op[i/3]+1)
	   {
		   i /= 3;
	   }
	   else if(i%2==0 && Op[i]==Op[i/2]+1)
	   {
		   i /= 2;
	   }
	   else
	   {
		   --i;
	   }
	   out[j] = i;
	   --j;
	 }
	 System.out.println(Op[n]);
	 for (int i = 0; i < out.length; i++) {
		 System.out.print(out[i] + " ");
	}
	}
}

package Week2;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Pro2 
{
	class Pair implements Comparable<Pair>
	{
        public float value;
        public int wight;
        public Pair(float value,int wight) 
        {
			this.value = value;
			this.wight = wight;
		}
		@Override
		public int compareTo(Pair pair) 
		{
			if(value>pair.value)
			{
				return 1;
			}
			else if(value<pair.value)
			{
				return -1;
			}
			return 0;
		}
		
	}

	public static void main(String[] args)
	{
	 Pro2 mainClass = new Pro2();
	 Scanner scan = new Scanner(System.in);
	 int n = scan.nextInt(), w = scan.nextInt(),vi,wi;
	 double totalValue = 0;
	 Pair[] pairs = new Pair[n];
	 for (int i = 0; i < n; i++) {
		vi = scan.nextInt();
		wi = scan.nextInt();
		pairs[i] = mainClass.new Pair((float)vi/(float)wi, wi);
	}
	 Arrays.sort(pairs);
	 for (int i = n-1; i >= 0; --i) {
		 if(w>=pairs[i].wight)
		 {
			 totalValue += pairs[i].wight*pairs[i].value;
			 w -= pairs[i].wight;
		 }
		 else
		 {
			 totalValue += w*pairs[i].value;
			 break;
		 }
	}
	 DecimalFormat df = new DecimalFormat("#.000");
	 System.out.println(df.format(totalValue));
	}

}

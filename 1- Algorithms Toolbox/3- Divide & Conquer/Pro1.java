package Week3;
import java.util.Scanner;

public class Pro1 {

	public static void main(String[] args)
	{
	 Scanner scan = new Scanner(System.in);
	 int n = scan.nextInt();
	 int[] Array = new int[n];
	 for (int i = 0; i < n; i++) {
		Array[i] = scan.nextInt();
	}
	 int k = scan.nextInt(),key = 0;
	 while(k>0)
	 {
		 key = scan.nextInt();
		 System.out.println(binarySearch(key, 0, n-1, Array));
		 --k;
	 }
	}
    public static int binarySearch(int key,int low,int high,int[] Arr)
    {
    	if(low>high) return -1;
    	
    	int mid = low + (high-low)/2;
    	
    	if(Arr[mid]==key) return mid;
    	else if(Arr[mid]>key)
    	{
    		return binarySearch(key, low, mid-1, Arr);
    	}
    	else return binarySearch(key, mid+1, high, Arr);
    }
}

package Week3;
import java.util.ArrayList;
import java.util.Scanner;

public class Pro1 
{
	static Pro1 mainClass = new Pro1();
	static ArrayList<Pair> swaps = new ArrayList();
	static int[] arr;
	public class Pair
    {
    	public int x;
    	public int y;
		public Pair(int x, int y) 
		{
			this.x = x;
			this.y = y;
		}
    }
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;++i) arr[i] = scan.nextInt();
        buildHeap(arr);
        System.out.println(swaps.size());
        for(int i=0;i<swaps.size();++i)
        {
           System.out.println(swaps.get(i).x + " " + swaps.get(i).y);
        }
	}
	public static void buildHeap (int[] arr)
	{
		Pro1.arr = arr;
		for(int i=arr.length/2;i>=0;--i)
		{
 			shiftDown(i);
		}
	}
	private static void shiftDown(int i) 
	{
	  while(i<arr.length-1)
	  {
	  int minIndex = i;
	  if((i*2+1)<arr.length && arr[minIndex]>arr[i*2+1]) minIndex =  i*2+1;
	  if((i*2+2)<arr.length && arr[minIndex]>arr[i*2+2]) minIndex =  i*2+2;
	  if(minIndex==i) return;
	  swaps.add(mainClass.new Pair(i,minIndex));
	  int Temp = arr[i];
	  arr[i] = arr[minIndex];
	  arr[minIndex] = Temp;
	  i = minIndex;
	  }
	}
}

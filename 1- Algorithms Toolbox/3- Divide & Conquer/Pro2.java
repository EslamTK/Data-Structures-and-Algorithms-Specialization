package Week3;
import java.sql.Ref;
import java.util.Scanner;

public class Pro2 {

	public static void main(String[] args)
	{
	 Scanner scan = new Scanner(System.in);
	 int n = scan.nextInt();
	 int[] Array = new int[n];
	 for (int i = 0; i < n; i++) {
		Array[i] = scan.nextInt();
	}
	 MergeSort(Array, 0, n-1);
	 int count = 0,maxC = 0;
	 for (int i = 1; i < n; i++) 
	 {
		if(Array[i]==Array[i-1]) ++count;
		else
		{
			if(count>maxC) maxC = count;
			count = 0;
		}
	 }
	 if(count>maxC) maxC = count;
	 
     if((maxC+1)>n/2) System.out.println(1);
     else System.out.println(0);
	}
    public static void MergeSort(int[] Arr,int low,int high)
    {
    	if(low>high || low==high) return;
    	int mid = low +(high-low)/2;
    	MergeSort(Arr, low, mid);
    	MergeSort(Arr, mid+1, high);
    	Merge(low, high, mid,Arr);
    }
    public static void Merge(int low, int high, int mid,int[] Arr) 
    {
		int[] Temp = new int[high-low+1];
		int a = low,b= mid+1;
		for(int i=0;i<Temp.length;++i)
		{
			if(a<=mid && b<=high)
			{
				if(Arr[a]<=Arr[b])
				{
					Temp[i] = Arr[a];
					++a;
				}
				else
				{
					Temp[i] = Arr[b];
					++b;
				}
			}
			else if(a<=mid)
			{
				Temp[i] = Arr[a];
				++a;
			}
			else if(b<=high)
			{
				Temp[i] = Arr[b];
				++b;
			}
		}
		for(int i=0,j=low;i<Temp.length && j<=high;++i,++j)
		{
			Arr[j] = Temp[i];
		}
	}
}

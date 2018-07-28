package Week3;
import java.util.ArrayList;
import java.util.Scanner;

public class Pro2 
{
	static Pro2 mainClass = new Pro2();
	public class Pair
    {
    	public int id;
    	public long time;
		public Pair(int id, long time) 
		{
			this.id = id;
			this.time = time;
		}
    }
	public class PQ
	{
		Pair[] threads;
		public PQ(int n)
		{
			threads = new Pair[n];
			for(int i=0;i<n;++i) threads[i] = mainClass.new Pair(i,0);
		}
		public void setMinPriority(int time)
		{
			threads[0].time += time;
			shiftDown(0);
		}
		public Pair getMin()
		{
			return threads[0];
		}
		private void shiftUp(int i)
		{
			while(i>0)
			{
				if(parent(i)>=0 && (threads[i].time<threads[parent(i)].time || 
						(threads[i].time==threads[parent(i)].time && threads[i].id<threads[parent(i)].id)))
				{
					  Pair Temp = threads[i];
					  threads[i] = threads[parent(i)];
					  threads[parent(i)] = Temp;
					  i = parent(i);
				}
				else return;
			}
		}
		private void shiftDown(int i) 
		{
		  while(i<threads.length-1)
		  {
		  int minIndex = i;
		  if(leftChild(i)<threads.length && (threads[minIndex].time>threads[leftChild(i)].time || 
			  (threads[minIndex].time==threads[leftChild(i)].time && threads[minIndex].id>threads[leftChild(i)].id))) minIndex =  leftChild(i);
		  
		  if((rightChild(i))<threads.length && (threads[minIndex].time>threads[rightChild(i)].time ||
				  (threads[minIndex].time==threads[rightChild(i)].time && threads[minIndex].id>threads[rightChild(i)].id))) minIndex =  rightChild(i);
		  
		  if(minIndex==i) return;
		  Pair Temp = threads[i];
		  threads[i] = threads[minIndex];
		  threads[minIndex] = Temp;
		  i = minIndex;
		  }
		}
		private int parent(int i)
		{
			return (i-1)/2;
		}
		private int leftChild(int i)
		{
			return 2*i+1;
		}
		private int rightChild(int i)
		{
			return 2*i+2;
		}
	}
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
        int t = scan.nextInt(), n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;++i) arr[i] = scan.nextInt();
        PQ priorityQ = mainClass.new PQ(t);
        for(int i=0;i<n;++i)
        { 
        	System.out.println(priorityQ.getMin().id + " " + priorityQ.getMin().time);
        	priorityQ.setMinPriority(arr[i]);
        }
	}
}

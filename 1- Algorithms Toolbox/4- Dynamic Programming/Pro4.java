package Week4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pro4 {
	static long[][] Table;
    static ArrayList<Character> Operations;
	public static void main(String[] args) throws IOException
	{
	Scanner scan = new Scanner(System.in);
	ArrayList<Integer> Numbers = new ArrayList<>();
	Operations = new ArrayList<>();
	String line = scan.nextLine();
	for (int i = 0; i < line.length(); i++)
	{
		if(i%2==0)
		{
			Numbers.add((int)(line.charAt(i)-'0'));
		}
		else
		{
			Operations.add(line.charAt(i));
		}
	}
	Table = new long[Numbers.size()][Numbers.size()];
	
	for (int i = 0; i < Numbers.size(); i++) Table[i][i] = Numbers.get(i);
	getMaxRes();
	System.out.println(Table[Numbers.size()-1][0]);
	}
	static void getMaxRes()
	{
		for (int i = 1; i < Table.length; i++) 
		{
			for (int j = 0; j < Table.length-i; j++) 
			{
				setMax_Min(j, j+i);
			}
		}	
/*		for (int i = 0; i < Table.length; i++) 
		{
			for (int j = 0; j < Table.length; j++) 
			{
				System.out.print(Table[i][j]);
				if(j<Table.length-1) System.out.print(" - ");
			}
			System.out.println();
		}
*/	
	}
	static void setMax_Min(int i,int j)
	{
		long a,b,c,d;
		long min = Long.MAX_VALUE,max = Long.MIN_VALUE;
		
		for(int op = i; op<j; ++op)
		{
			
			if(Operations.get(op).equals('+'))
			{
				a = Table[i][op] + Table[op+1][j];
				b = Table[op][i] + Table[j][op+1];
				c = Table[i][op] + Table[j][op+1];
				d = Table[op][i] + Table[op+1][j];
			}
			else if(Operations.get(op).equals('-'))
			{
				a = Table[i][op] - Table[op+1][j];
				b = Table[op][i] - Table[j][op+1];
				c = Table[i][op] - Table[j][op+1];
				d = Table[op][i] - Table[op+1][j];
			}
			else
			{
				a = Table[i][op] * Table[op+1][j];
				b = Table[op][i] * Table[j][op+1];
				c = Table[i][op] * Table[j][op+1];
				d = Table[op][i] * Table[op+1][j];
			}
			max = Math.max(max,Math.max(Math.max(a, b), Math.max(c, d)));
			min =  Math.min(min,Math.min(Math.min(a, b), Math.min(c, d)));
			//System.out.println(i + " " + j + "( " + min + " " + max + " )");
		}
		Table[i][j] = min;
		Table[j][i] = max;
	}
}

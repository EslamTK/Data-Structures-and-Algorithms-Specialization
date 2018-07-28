package Week1;
import java.util.Scanner;
import java.util.Stack;

public class Pro1 
{
	static Stack <Pair> stack = new Stack<>(); 
    public class Pair
    {
    	public char c;
    	public int index;
		public Pair(char c, int index) 
		{
			this.c = c;
			this.index = index;
		}
    }
	public static void main(String[] args) 
	{
		Pro1 mainClass = new Pro1();
		Scanner scan = new Scanner(System.in);
        String s = scan.next();
        
        for (int i = 0; i < s.length(); i++) 
        {
			if(s.charAt(i)=='[' || s.charAt(i)=='(' || s.charAt(i)=='{') stack.push(mainClass.new Pair(s.charAt(i), i));
			else if(s.charAt(i)==']' || s.charAt(i)==')' || s.charAt(i)=='}')
			{
				if(stack.isEmpty())
				{
					System.out.println(i + 1);
					return;
				}
				if (s.charAt(i) == ']') 
				{
					if (stack.pop().c != '[') 
					{
						System.out.println(i + 1);
						return;
					}
				} 
				else if (s.charAt(i) == ')') 
				{
					if (stack.pop().c != '(') 
					{
						System.out.println(i + 1);
						return;
					}
				} 
				else if (s.charAt(i) == '}') 
				{
					if (stack.pop().c != '{') 
					{
						System.out.println(i + 1);
						return;
					}
				}
			}
		}
        
        if(stack.isEmpty())
		{
			System.out.println("Success");
		}
        else
        {
        	while(stack.size()>1) stack.pop();
        	System.out.println(stack.pop().index+1);
        }
	}

}

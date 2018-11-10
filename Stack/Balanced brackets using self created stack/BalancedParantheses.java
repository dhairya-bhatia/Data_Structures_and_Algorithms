package client;
import java.util.*;
import ds.Stack;
public class BalancedParantheses {
		
	static String isBalanced(String str)
	{
		Stack s = new Stack();
		if(str.charAt(0) == ')' || str.charAt(0) == ']' || str.charAt(0) == '}')
	    {
	    	return "NO";
	    }
	    for(int i = 0; i < str.length(); i++)
	    {
	    	if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{')
	    		s.push(str.charAt(i));
	    	if(str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}')
	    	{
	    		switch(str.charAt(i))
	    		{
	    			case ')' :  if(s.peek() != '(')
	    							return "NO";
	    						else
	    						{
	    							s.pop();
	    						}
	    							
	    			break;
	    			
	    			case ']' :  if(s.peek() != '[')
									return "NO";
	    						else
	    							s.pop();
	    			break;
	    			

	    			case '}' :  if(s.peek() != '{')
									return "NO";
	    						else
	    							s.pop();
	    			break;
	    		}
	    	}
	    }
	    	if(s.isEmpty() == true)
	    	{
	    		return "YES";
	    	}
	    	else
	    	{
	    		return "NO";
	    	}
	    	
	    		
	    
	}
	public static void main(String[] args)
	{
	    Scanner sc = new Scanner(System.in);
	    String str = sc.next();
	    String ans = isBalanced(str);
	    System.out.println(ans);
	    
	    
	}
}

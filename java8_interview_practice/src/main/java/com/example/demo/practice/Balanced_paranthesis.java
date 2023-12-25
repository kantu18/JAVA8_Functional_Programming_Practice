package com.example.demo.practice;

import java.util.Stack;

public class Balanced_paranthesis {
	public static void main(String args[])
	{
		
		String inputstr="[]";
		
		if(checkvalidations(inputstr))
		{
			System.out.println("Input string "+inputstr+" is balanced.");
		}
		else{
			 System.out.println("Input string "+inputstr+" is not balanced.");
		}
		           
	}


private static boolean checkvalidations(String str)
{
	Stack<Object> stackobject=new Stack<>();
	
	char[] charArray = str.toCharArray();
	
	for(int i=0;i<charArray.length;i++)
	{
		char charcheck = charArray[i];
		
		if(charcheck=='(' || charcheck==']' || charcheck=='}')
		{
			stackobject.push(charcheck);
			continue;
		}
		if(stackobject.empty())
		{
			return false;
		}
		
		char popchar;
		
		switch(charcheck) {
			case '}':
				popchar=(char) stackobject.pop();
				if(popchar=='(' || popchar=='[')
					return false;
				break;
			case ')':
				popchar=(char) stackobject.pop();
				if(popchar=='{' || popchar=='[')
					return false;
				break;	
			case ']':
				popchar=(char) stackobject.pop();
				if(popchar=='(' || popchar=='{')
					return false;
				break;
		}
		
	}
	return stackobject.isEmpty();
}

}
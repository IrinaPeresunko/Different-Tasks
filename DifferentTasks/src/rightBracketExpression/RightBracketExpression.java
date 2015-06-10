package rightBracketExpression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// task description in the text file "Task.txt"

public class RightBracketExpression {
	private static int N;
	 //private static char[] bracketExpression = {'(','(',')',')'};
	private static Map<String,String> variantsOfBracketExpression = new HashMap<String,String>();
	
	public static void initializeHashMap(){
		variantsOfBracketExpression.put("1","()");
		variantsOfBracketExpression.put("2","()()"); 
		variantsOfBracketExpression.put("2","(())");
	}
	public static void getValueOfNFromUser(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
	    System.out.println("Enter N for right bracket expression: "); 
	      try {
			input = (String) br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    N = Integer.parseInt(input);
	}
	public static char[] toCharArray(String inputExpression){
		char[] resultExpression = new char[inputExpression.length()];
		for(int i=0;i<inputExpression.length();i++){
			resultExpression[i] = inputExpression.charAt(i);
		}
		return resultExpression;
	}
	public static boolean isCorrectBracketExpression(char[] expression){
		int openBracket=0;
		int closeBracket=0;
		if(expression[0]==')' || expression[expression.length-1]=='(') return false;
		for(int i=0;i<expression.length;i++){
			if(expression[i]=='(') openBracket++;
			if(expression[i]==')') closeBracket++;
		}
		if((openBracket-closeBracket)==0) return true;
		return false;
	}
	public static void main(String[] args) {
		String expression = "(()(()))";
		boolean temp = isCorrectBracketExpression(toCharArray(expression));
		System.out.println(temp);
	}

}

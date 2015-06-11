package rightBracketExpression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// task description in the text file "Task.txt"

public class RightBracketExpression {
	private static Set<String> variantsOfBracketExpression = new HashSet<String>();
	
	public static Set<String> generateBasicVariants(int N){
		StringBuffer sb = new StringBuffer();
		
		Set<String> prevVariants = new HashSet<String>();
		Set<String> nextVariants = new HashSet<String>();
		
		prevVariants.add("()");
		for(int i=1;i<N-1;i++){
			for(String tempVariant:prevVariants){
				for(int j=0;j<2*i;j++){
					sb.append(tempVariant);
					nextVariants.add(sb.insert(j, "()").toString());
					sb.delete(0, sb.length());
					//System.out.println(nextVariants);
				}
			}
			prevVariants = nextVariants;
			nextVariants = new HashSet<String>();
		}
		return prevVariants;
	}
	public static void getVariantsOfBracketsForN(int N){
		if(N==1){
			variantsOfBracketExpression.add("()");
			//System.out.println(variantsOfBracketExpression);
			return;
		}
		StringBuffer sb = new StringBuffer();
		Set<String> prevVariants = generateBasicVariants(N);
			for(String tempVariant:prevVariants){
				for(int j=0;j<2*(N-1);j++){
					sb.append(tempVariant);
					variantsOfBracketExpression.add(sb.insert(j, "()").toString());
					sb.delete(0, sb.length());
				}
			}
			//System.out.println(variantsOfBracketExpression);
	}
	public static int getCountOfVariantsOfBracketExpression(int N){
		getVariantsOfBracketsForN(N);
		return variantsOfBracketExpression.size();
	}
	public static int getValueOfNFromUser(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
	    System.out.println("Enter N for right bracket expression: "); 
	      try {
			input = (String) br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return Integer.parseInt(input);
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
		//String expression = "(()(()))";
		int count =getCountOfVariantsOfBracketExpression(0);
		System.out.println(count);
	}
}
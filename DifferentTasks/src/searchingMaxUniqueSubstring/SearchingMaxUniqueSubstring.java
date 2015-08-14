package searchingMaxUniqueSubstring;
/*
 * Task:searching the max unique length of substring in the input string
 */
public class SearchingMaxUniqueSubstring {

	public static int searchPositionOfCharacters(char[] alphabet,char character){
		int position=0;
		for(int i=0;i<alphabet.length;i++){
			if(alphabet[i]==character){
				position=i;
				break;
			}
		}
		return position;
	}
//	public static String gettingMaxUniqueSubstring(String inputString,int start,int end){
//		return inputString.substring(start, end);
//	}
	public static void main(String[] args) {
		char[] alphabet = {'A','B','C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
				'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		String inputString = "ABCDEFGVWXYZAB";
		
		int result=0,startOfSubstring=0,endOfSubstring=0;
		char[] charactersOfInputString = inputString.toCharArray();
		for(int i=0;i<inputString.length();i++){
			
			int positionInAlphabet = searchPositionOfCharacters(alphabet,charactersOfInputString[i]);
			boolean flag = false;
			int start = i,pointer=i,end=start;
			
			while(flag!=true){
				if(pointer<inputString.length()-1){ pointer=pointer+1;}
				int tempPosition = searchPositionOfCharacters(alphabet,charactersOfInputString[pointer]);
				positionInAlphabet=positionInAlphabet+1;
				if(positionInAlphabet==tempPosition){
					end=pointer;
				}
				else{
					int tempResult=(end-start)+1;
					if(tempResult>result){
						startOfSubstring=start;
						endOfSubstring=end+1;
						result = tempResult;
					}
					flag=true;
				}
			}
		}
		System.out.println("result="+result);
		String resultSubstring = inputString.substring(startOfSubstring, endOfSubstring);
		System.out.println("resulting substring = "+resultSubstring);
	}
}

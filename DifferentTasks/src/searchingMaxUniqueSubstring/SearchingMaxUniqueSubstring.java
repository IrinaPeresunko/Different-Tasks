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
	public static void main(String[] args) {
		char[] alphabet = {'A','B','C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
				'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		String inputString = "ABCDVWXYZAB";
		
		int start=0,end=0,result=0;
		char[] charactersOfInputString = inputString.toCharArray();
		for(int i=0;i<inputString.length();i++){
			
			int positionInAlphabet = searchPositionOfCharacters(alphabet,charactersOfInputString[i]);
			boolean flag = false;
			start = i;
			int pointer=i;
			
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
						result = tempResult;
					}
					flag=true;
				}
			}
		}
		System.out.println("result="+result);
	}
}

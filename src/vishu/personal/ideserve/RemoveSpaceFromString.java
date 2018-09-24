package vishu.personal.ideserve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * program to remove the spaces from a Given String which contains 0 or more spaces.
 */

public class RemoveSpaceFromString {
	
	public String removeSpace(String s){
		StringBuilder sb = new StringBuilder("");
		char [] c = s.toCharArray();
		for(int i=0; i<c.length; i++){
			if(c[i] != ' '){
				sb.append(c[i]);
			}
		}
//		System.out.println("SB: " +sb.toString());
		return sb.toString();
	}
	
	public boolean hasWhiteSpace(String s) {
		char [] c = s.toCharArray();
		for(int i=0; i<c.length; i++){
			if(c[i] == ' '){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please Enter a String:\n");
		String inputString = br.readLine();
		RemoveSpaceFromString rsfs = new RemoveSpaceFromString();
		String outputString = rsfs.removeSpace(inputString);
		System.out.println("The String is:\n" +outputString);
		System.out.println("Contains WhiteSpace? " + (rsfs.hasWhiteSpace(outputString)? "true" : "false") );
		
	}
}

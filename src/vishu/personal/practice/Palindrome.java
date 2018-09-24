package vishu.personal.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {
	
	public static void main(String[] args) throws IOException, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter a String: ");
		String s = br.readLine();
		
		StringBuilder sb = new StringBuilder(s);
		System.out.println(s.equalsIgnoreCase(sb.reverse().toString()) ? "Palindrome" : "Not Palindrome");
	}
}


package vishu.personal.testdome;

public class PalindromeString {
    public static boolean isPalindrome(String word) {
//        throw new UnsupportedOperationException("Waiting to be implemented.");
    	String s = new StringBuffer(word.toLowerCase()).reverse().toString();
    	return word.equalsIgnoreCase(s);
    }
    
    public static void main(String[] args) {
        System.out.println(PalindromeString.isPalindrome("Deleveled"));
    }
}
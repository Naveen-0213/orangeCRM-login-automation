package learn.ecommerce.scripts;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CheckAnagram {

	public static void main(String[] args) {
		String first="stop";
		String second="pose";
		if(first.length()!=second.length()) {
			System.out.println("Not a Anagram");
		}
		
		char[] ch=first.toLowerCase().toCharArray();
		char[] chh=second.toLowerCase().toCharArray();
		
		Arrays.sort(ch);
		Arrays.sort(chh);
		
		if(Arrays.equals(ch, chh)) {
			System.out.println("Given Strings are Anagram");
		}else {
			System.out.println("Length Same but not a Anagram");
		}
		
		
	}

}

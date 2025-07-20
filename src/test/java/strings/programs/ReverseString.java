package strings.programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.formula.atp.Switch;

public class ReverseString {
	
	public static void reverseString() {
		String name="Naveen Kumar";
		char[] ch=name.toCharArray();
		for(int i=ch.length-1;i>=0;i--) {
			System.out.print(ch[i]);
		}

	}
	
	public static void reverseEachWord() {
		
		String input="Naveen Kumar Pitchuka";
		String[] words=input.split(" ");
		String output="";
		for(String word: words) {
			char[] ch=word.toCharArray();
			for(int i=ch.length-1;i>=0;i--) {
				output=output+ch[i];
			}
			
		}
		
		System.out.println(output);
		
		
	}
	
	
	public static void duplicateChars() {
		String str="Naveen Kumar";
		char[] ch=str.toLowerCase().toCharArray();
		for(int i=0;i<=ch.length-1;i++) {
			for(int j=i+1;j<ch.length;j++) {
				if(ch[i]==ch[j]) {
					System.out.print(ch[i]);
				}
			}
		}
	}
	
	public static void duplicateCharCount() {
		
		String str="Naveen Kumar";
		char[] ch=str.toLowerCase().toCharArray();
		Map<Character, Integer> map=new HashMap<>();
		
		for(Character c:ch) {
			map.put(c, map.getOrDefault(c,0)+1);
			
			if(map.get(c)>1) {
				System.out.println(c +":"+map.get(c));
			}
			
		}
		
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		
		
	}
	
	public static void countWords() {
		String str="Naveen Kumar Kumar Pitchuka naveen";
		String[] words=str.toLowerCase().split(" ");
		Map<String, Integer> map=new HashMap<>();
		for(String word:words) {
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
	
	public static void countNoOfWords() {
		String in="Naveen Kumar Pitchuka Hi";
		String[] str=in.split(" ");
		int noOfWords=str.length;
		System.out.println("No Of Words from Given String: "+noOfWords);
	}
	
	public static void appendEachCharTwice() {
		String name="naveen";
		char[] ch=name.toCharArray();
		String out="";
		for(int i=0;i<=ch.length-1;i++) {
			out=out+ch[i]+ch[i];
		}
		System.out.println(out);
	}
	
	public static void evenIndexChar() {
		String str="naveen kumar";
		char[] ch=str.toCharArray();
		for(int i=0;i<=ch.length-1;i++) {
			if(i%2==0) {
				System.out.print(ch[i]);
			}
		}
	}
	
	public static void permutations(String str, String prefix) {
		
		
		if(str.length()==0) {
			System.out.println(prefix);
		}else {
			for(int i=0;i<str.length();i++) {
				String rem=str.substring(0,i)+str.substring(i+1);
				permutations(rem, prefix+str.charAt(i));
			}
		}
		
	}
	
	public static void palindrome() {
		String str="navan";
		String out="";
		char[] ch=str.toCharArray();
		for(int i=ch.length-1;i>=0;i--) {
			out=out+ch[i];
		}
		
		if(str.equals(out)) {
			System.out.println("The Given String is palindrome");
		}else {
			System.out.println("The Given String is not a Palindrome");
		}
	}
	
	public static void checkAnagrams() {
		String one="post";
		String two="soop";
		char[] chOne=one.toCharArray();
		char[] chtwo=two.toCharArray();
		
		if(one.length()!=two.length()) {
			System.out.println("Given Strings are not anagrams");
		}else {
		
		Arrays.sort(chOne);
		Arrays.sort(chtwo);
		
		if(Arrays.equals(chOne, chtwo)) {
			System.out.println("Given Strings are Anagrams");
		}else {
			System.out.println("Given String are not Anagrams");
		}
		}
		
	}
	
	public static void countVowelsConsonants() {
		String name="Naveen Kumar";
		char[] ch=name.toCharArray();
		int vowelCount=0;
		int consonantCount=0;
		for(Character c: ch) {
			switch(c) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				vowelCount++;
				break;
				default: consonantCount++;
			}
		}
		
		System.out.println("Vowel Count is: "+vowelCount);
		System.out.println("Consonant Count is: "+consonantCount);
	}
	
	public static void printuniqueChars() {
		String in="naveen kumar pitchuka";
		char[] ch=in.toCharArray();
		Map<Character, Integer> map=new HashMap<>();
		for(Character c: ch) {
			map.put(c, map.getOrDefault(c, 0)+1);
			if(map.get(c)==1) {
				System.out.print(c);
			}
		}
	}
	
	public static void removeSpaces() {
		String in="Naveen Kumar Pitchuka";
		String out=in.replaceAll(" ", "");
		System.out.println(out);
		
	}
	
	public static void main(String[] args) {
		//reverseString();
		//reverseEachWord();
		//duplicateChars();
		//duplicateCharCount();
		//countWords();
		//countNoOfWords();
		//appendEachCharTwice();
		//evenIndexChar();
		//permutations("abc", "");
		//palindrome();
		//checkAnagrams();
		//countVowelsConsonants();
		//printuniqueChars() ;
		removeSpaces();
	}

}

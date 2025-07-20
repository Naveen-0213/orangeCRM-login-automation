package learn.ecommerce.scripts;

import java.util.Collection;

public class LastwordReverse {

	public static void reverseString(String str) {
		
		StringBuilder partOne=new StringBuilder();
		StringBuilder partTwo=new StringBuilder();
		
		String one=str.substring(0,4);
		String two=str.substring(4);
		partOne.append(one);
		partTwo.append(two).reverse();
		System.out.println(partOne.toString()+partTwo.toString());
		
		
		
	}
	
	
	public static void printvalidName(String str) {
		
		String one=str.replaceAll("[^a-zA-Z]", "");
		System.out.println(one);
		
		
	}
	public static void main(String[] args) {
		
		
		String name="Naveen";
		String reverse=name.substring(4);
		String nameOne=name.substring(0,4);
		System.out.println(nameOne);
		String str="";
		char[]ch=reverse.toCharArray();
		for(int i=ch.length-1;i>=0;i--) {
			//System.out.print(ch[i]);
			str=str+ch[i];
		}
		
		System.out.println(nameOne.concat(str));
		reverseString(name);
		printvalidName("Navee%%%666nKumar$$");

		
	}

	

}

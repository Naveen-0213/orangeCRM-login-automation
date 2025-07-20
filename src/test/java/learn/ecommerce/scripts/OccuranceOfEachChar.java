package learn.ecommerce.scripts;

import java.util.HashMap;
import java.util.Map;

public class OccuranceOfEachChar {

	public static void main(String[] args) {
		String name="naveen kumar";
		//output: 
		
		char[] ch=name.toCharArray();
		
		for(int i=0;i<=ch.length-1;i++) {
			for(int j=i+1;j<ch.length;j++) {
				if(ch[i]==ch[j]) {
					System.out.print(ch[i]);
				}
			}
		}

	}

}

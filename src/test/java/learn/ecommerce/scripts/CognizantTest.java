package learn.ecommerce.scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CognizantTest {

	public static void main(String[] args) {
		String str="Chennai Kolkata Chennai Pune Kolkata";
		//Chennai Kolkata Pune
		Set<String> set=new HashSet<>();
		for(String word:str.split(" ")) {
			set.add(word);
		}
	
		for(String word:set) {
			System.out.println(word);
		}
		

	}

}

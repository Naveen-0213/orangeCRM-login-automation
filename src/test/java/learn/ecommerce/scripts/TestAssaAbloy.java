package learn.ecommerce.scripts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestAssaAbloy {

	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		
		list.add("Naveen");
		list.add("Vinay");
		list.add("Sivayya");
		
		Collections.sort(list);
		
		for(String name:list) {
			System.out.println(name);
		}
		
	}

}

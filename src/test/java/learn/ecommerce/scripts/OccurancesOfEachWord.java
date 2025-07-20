package learn.ecommerce.scripts;

import java.util.HashMap;
import java.util.Map;

public class OccurancesOfEachWord {

	public static void main(String[] args) {
		String name="Test Automation Java Automation test";
		String[] str=name.split(" ");
		Map<String, Integer> map=new HashMap<>();
		
		for(String word:str) {
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		
		for(Map.Entry<String, Integer> entry:map.entrySet()) {
			
			System.out.println(entry.getKey()+":"+entry.getValue());
		}

	}

}

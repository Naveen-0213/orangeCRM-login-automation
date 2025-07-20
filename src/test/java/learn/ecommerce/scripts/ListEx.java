package learn.ecommerce.scripts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListEx {

	public static void main(String[] args) {
		
		
		
		List<Integer> list=new ArrayList<>();
		List<Integer> listTwo=new ArrayList<>();
		list.add(34);
		list.add(345);
		list.add(346);
		list.add(37);
		list.add(35);
		list.add(30);
		
		
		
		listTwo.add(34);
		listTwo.add(345);
		listTwo.add(346);
		listTwo.add(46);
		listTwo.add(45);
		listTwo.add(40);
		
		list.retainAll(listTwo);
		
		System.out.println("Before Reverse: "+list);
		
		Collections.reverse(list);
		
		System.out.println("After Reverse: "+list);
		
		list.stream().forEach(element-> System.out.println(element));
		
		
		
	}

}

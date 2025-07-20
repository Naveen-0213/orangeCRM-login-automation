package learn.ecommerce.scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLargestElementFromList {
	
	public static void findDuplicates(int[] arr) {
		
		for(int i=0;i<=arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					System.out.println("Duplicate Elements are: "+arr[i]);
				}
			}
		}
		
		
	}

	public static void findSmallest(int[] arr) {
	
		Arrays.sort(arr);
		List<Integer> list=new ArrayList<>(arr.length);
		for(Integer ele:arr) {
			list.add(ele);
		}
		
		System.out.println(list.get(0));
		
		
		
	}
	
	public static void largestNumList(List<Integer> list) {
		
		int max=Integer.MIN_VALUE;
		for(Integer num:list) {
			//System.out.println(num);
			if(num>max) {
				max=num;
			}
		}
		System.out.println(max);
		
		
	}
	
	public static void main(String[] args) {
		// Write a Java program to find the largest number in a given list.
		//Write a Java program to find the smallest number in an array.
		//Write a Java program to find duplicates in an array.
		
		int[] duplicates= {1,2,3,4,5,6,3,2,5,1};
		//findDuplicates(duplicates);
		
		int[] smallest= {3,5,6,7,12,8,9,11};
		//findSmallest(smallest);
		
		List<Integer> listOne=new ArrayList<>();
		listOne.add(6);
		listOne.add(5);
		listOne.add(110);
		listOne.add(3);
		listOne.add(2);
		listOne.add(1);
		largestNumList(listOne);

	}

}

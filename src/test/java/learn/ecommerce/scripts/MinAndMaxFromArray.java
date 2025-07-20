package learn.ecommerce.scripts;

public class MinAndMaxFromArray {

	public static int findMax(int[] arr) {
		
		int max=arr[0];
		
		for(int i=0;i<=arr.length-1;i++) {
			
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		
		
		return max;
		
		
	}
	public static int findMin(int[] arr) {
		int min=arr[0];
		for(int i=0;i<=arr.length-1;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		int[] arr= {-1,0,1,2,3,4,5,6,7,8,9};
		int maxVal=findMax(arr);
		System.out.println("Max Value from the given Array is: "+maxVal);
		
		int minVal=findMin(arr);
		System.out.println("Min value from the given Array is: "+minVal);
	}

}

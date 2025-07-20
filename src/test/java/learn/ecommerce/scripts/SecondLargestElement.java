package learn.ecommerce.scripts;

public class SecondLargestElement {

	public static void main(String[] args) {
		int[] arr= {9,8,7,6,3,2,4,5};
		int largest=Integer.MIN_VALUE;
		int secondLargest=Integer.MIN_VALUE;
		for(int i=0;i<=arr.length-1;i++) {
			if(arr[i]>largest) {
				largest=arr[i];
			}else if(arr[i]>secondLargest && arr[i]!=largest) {
				secondLargest=arr[i];
			}
		}
		
		System.out.println(secondLargest);
				
	}

}

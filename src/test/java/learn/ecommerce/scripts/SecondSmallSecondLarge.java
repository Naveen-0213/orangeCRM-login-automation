package learn.ecommerce.scripts;

public class SecondSmallSecondLarge {

	public static void findSecondLargest(int[] arr) {
		
		int largest=Integer.MIN_VALUE;
		int secondLargest=Integer.MIN_VALUE;
		for(int i=0;i<=arr.length-1;i++) {
		if(arr[i]>largest) {
			largest=arr[i];
		}else if(arr[i]>secondLargest && arr[i]<largest) {
			secondLargest=arr[i];
		}
		}
		System.out.println("SecondLargest Element from Array is : "+secondLargest);
	}
	
	public static void findSeconfSmallest(int[] arr) {
		
		int smallest=Integer.MAX_VALUE;
		int secondSmallest=Integer.MAX_VALUE;
		for(int i=0;i<=arr.length-1;i++) {
			if(arr[i]<smallest) {
				smallest=arr[i];
				
			}else if(arr[i]<secondSmallest && arr[i]>smallest) {
				secondSmallest=arr[i];
			}
		}
		System.out.println("The second smallest ele from Array is: "+secondSmallest);
	}
	
	public static void main(String[] args) {
		
		int[] arr= {1,3,4,5,6,7,89,10,77};
		findSecondLargest(arr);
	    findSeconfSmallest(arr);
		
	}

}

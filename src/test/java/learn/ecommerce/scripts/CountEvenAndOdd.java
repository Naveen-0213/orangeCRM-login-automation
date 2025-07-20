package learn.ecommerce.scripts;

public class CountEvenAndOdd {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7,8,9};
		int evenCount=0;
		int oddCount=0;
		
		for(int i=0;i<=arr.length-1;i++) {
			
			if(arr[i]%2==0) {
				evenCount++;
			}else {
				oddCount++;
			}
		}
		System.out.println("Even Count is: "+evenCount);
		System.out.println("Odd Count is: "+oddCount);
	}

}

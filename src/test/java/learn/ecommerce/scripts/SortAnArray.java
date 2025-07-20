package learn.ecommerce.scripts;

public class SortAnArray {
	
	public static void selectionSort(int[] arr) {
		//Get the array
		for(int i=0;i<=arr.length-1;i++) {
			int minIndex=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[minIndex]) {
					minIndex=j;
				}
			}
			
			//swap
			int temp=arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=temp;
		}
		
	}

	public static void main(String[] args) {
		int[] arr= {4,3,6,8,3,1,7,5,2,9};
		selectionSort(arr);
		for(int num:arr) {
			System.out.print(num+" ");
		}

	}

}

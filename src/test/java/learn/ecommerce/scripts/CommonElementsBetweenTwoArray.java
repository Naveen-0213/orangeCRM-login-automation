package learn.ecommerce.scripts;

public class CommonElementsBetweenTwoArray {

	public static void main(String[] args) {
		int[] arrOne= {1,2,3,4,5,6,7,8,9};
		int[] arrTwo= {10,11,12,13,1,15,6,8,};
		for(int i=0;i<=arrOne.length-1;i++) {
			for(int j=0;j<=arrTwo.length-1;j++) {
				if(arrOne[i]==arrTwo[j]) {
					System.out.println("Commom Elements: "+arrOne[i]);
				}
			}
		}
		

	}

}

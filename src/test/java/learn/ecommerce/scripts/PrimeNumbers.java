package learn.ecommerce.scripts;

public class PrimeNumbers {

	public static void main(String[] args) {
		int num=20;
		for(int i=2;i<=num;i++) {
			boolean isPrime=true;
			for(int j=2;j<=num/2;j++) {
			if(i%2==0) {
				isPrime=false;
				break;
			}
		}
			
			if(isPrime) {
				System.out.print(i+" ");
			}
		}
		
	}

}

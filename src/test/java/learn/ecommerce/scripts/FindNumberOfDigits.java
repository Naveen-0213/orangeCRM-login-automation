package learn.ecommerce.scripts;

public class FindNumberOfDigits {

	public static void main(String[] args) {
		int number=1235544;
		int  count=0;
		while(number>0) {
		 number=number/10;
		 count++;
		}
		System.out.println(count);
	}

}

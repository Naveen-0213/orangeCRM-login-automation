package learn.ecommerce.scripts;

public class ReverseNumber {

	public static void main(String[] args) {
		int number=12345;
		int digit;
		int reversed=0;
		
		System.out.println("Initial Number: "+number);
		while(number>0) {
			
		 digit=number%10;
		 reversed=reversed*10+digit;
		 number=number/10;
		}
		
		
		System.out.println("Reversed: "+reversed );

	}

}

package learn.ecommerce.scripts;

public class NumberPalindrome {

	public static void main(String[] args) {
		int number=10011;
		int org=number;
		int digit, result=0;
		while(number>0) {
			digit=number%10;
			number=number/10;
			result=result*10+digit;
		}
		if(org==result) {
			System.out.println("Palindrome "+result);
		}else {
			System.out.println("Not a Palindrome "+result);
		}
		

	}

}

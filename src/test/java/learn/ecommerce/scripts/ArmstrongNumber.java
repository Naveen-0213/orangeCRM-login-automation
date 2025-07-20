package learn.ecommerce.scripts;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int arm=153, digit;
		int org=arm;
		int result=0;
		while(arm>0) {
			digit=arm%10;
			arm=arm/10;
			result=result+digit*digit*digit;
			
		}
		if(result==org) {
			System.out.println("Number is ArmStrong");
		}else {
			System.out.println("Number is not a ArmStrong");
		}

	}

}

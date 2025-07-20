package learn.ecommerce.scripts;

import java.util.Collections;

import org.openqa.selenium.JavascriptExecutor;

public class HelloWorld {
	
	public static void testMethod() {
		try {
			System.out.println("Try Block");
			//System.exit(0);
			
			
		}catch(Exception e){
			System.out.println("Catch Block");
		}finally {
			System.out.println("Finally Block");
		}
	}

	public static void main(String[] args) {
		//System.out.println("Hiii");
		testMethod();
	
		
		        
	}

}

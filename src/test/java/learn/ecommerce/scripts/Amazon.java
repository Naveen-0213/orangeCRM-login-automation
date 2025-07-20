package learn.ecommerce.scripts;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
public static void main(String[] args) throws  InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver=new ChromeDriver(options);
		Wait<WebDriver> wait=new FluentWait<>(driver)
							.withTimeout(Duration.ofSeconds(10))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(Exception.class);
		SoftAssert ass=new SoftAssert();
		
		
		try {
			driver.get("https://www.amazon.in");
			String homeTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
			String homePageTitle=driver.getTitle();
			ass.assertEquals(homeTitle, homePageTitle, "HomePage Title Not Matched");
			System.out.println(homePageTitle);
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 15");
			
			driver.findElement(By.id("nav-search-submit-button")).click();
		    WebElement iphonePink=driver.findElement(By.xpath("//span[@class='a-price']/child::span/child::span[contains(text(),\"60,100\")]/preceding::span[contains(text(),\"Apple iPhone 15 (128 GB) - Pink\")]"));
			wait.until(ExpectedConditions.elementToBeClickable(iphonePink));
		    iphonePink.click();
			String actualPhoneLink="Apple iPhone 15 (128 GB) - Pink : Amazon.in: Electronics";
			String verifyTitle=driver.getTitle();
			System.out.println(verifyTitle);
			 
			
		
			
			ass.assertEquals(actualPhoneLink,verifyTitle, "Pink Title Not Matched");
			
			
			ass.assertAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Thread.sleep(5000);
			driver.quit();
		}
		
		
	}


}

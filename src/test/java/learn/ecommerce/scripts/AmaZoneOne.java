package learn.ecommerce.scripts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmaZoneOne {

	public WebDriver driver;
	
	public  AmaZoneOne() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--start-maximized");
		this.driver=new ChromeDriver(options);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox") WebElement
	enterTextBox;
	
	@FindBy(id="nav-search-submit-button") WebElement 
	clickOnSearchBox;
	
	@FindBy(xpath="//span[@class='a-price']/child::span/child::span[contains(text(),\"60,100\")]/preceding::span[contains(text(),\"Apple iPhone 15 (128 GB) - Pink\")]") WebElement
	selectPinkIphone;
	
	public void takesSnap(String imgName) throws IOException {
		TakesScreenshot shot=(TakesScreenshot)driver;
		File src=shot.getScreenshotAs(OutputType.FILE);
		File dest=new File(".//ScreenShots//"+imgName+".png");
		FileUtils.copyFile(src, dest);
		
		
	}
	
	public void launchTest() throws InterruptedException {
	
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
		enterTextBox.sendKeys("Iphone 15");
		
		clickOnSearchBox.click();
	   
		wait.until(ExpectedConditions.elementToBeClickable(selectPinkIphone));
		selectPinkIphone.click();
		String actualPhoneLink="Apple iPhone 15 (128 GB) - Pink : Amazon.in: Electronics";
		String verifyTitle=driver.getTitle();
		System.out.println(verifyTitle);
		ass.assertEquals(actualPhoneLink,verifyTitle, "Pink Title Not Matched");
		String str="pinkphone";
		takesSnap(str);
		ass.assertAll();
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		Thread.sleep(5000);
		driver.quit();
	}
	
	
}

	 public static void main(String[] args) throws InterruptedException {
		 AmaZoneOne test=new AmaZoneOne();
		 test.launchTest();
		 
		 
	 }

	}



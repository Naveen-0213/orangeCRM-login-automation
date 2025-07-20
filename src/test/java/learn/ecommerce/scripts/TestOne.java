package learn.ecommerce.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOne {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://leafground.com/");
		driver.navigate().to("https://leafground.com/");
		driver.findElement(By.xpath("//span[contains(text(),'Browser')]/..")).click();
		driver.navigate().refresh();
	}

}

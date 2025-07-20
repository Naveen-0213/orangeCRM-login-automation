package learn.ecommerce.scripts;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkBrokenOrNot {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		try {
		 driver.get("https://toolsqa.com/selenium-webdriver/find-broken-links-in-selenium/");
		
		List<WebElement> list= driver.findElements(By.tagName("a"));
		System.out.println("Total Links: "+list.size());
		for(WebElement ele:list) {
			String url=ele.getDomAttribute("href");
			
			if(url==null || url.isEmpty()) {
				System.out.println("No Link Avaialbe");
				continue;
			}
			
			try {
				
				URL linkUrl=new URL(url);
				HttpURLConnection conn=(HttpURLConnection) linkUrl.openConnection();
				conn.setRequestMethod("HEAD");
				conn.setConnectTimeout(5000);
				conn.connect();
				
				int responseCode=conn.getResponseCode();
				if(responseCode>400) {
					System.out.println("Link Broken");
				}else {
					System.out.println("Link Not broken");
				}
				
			}catch(Exception e) {
				
			}
		}
		
		
		}finally {
			Thread.sleep(3000);
			driver.quit();
		}
		

	}

}

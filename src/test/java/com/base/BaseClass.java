package com.base;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
//import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;





public class BaseClass {
	protected WebDriver driver;
	protected Properties prop;
	protected ExtentReports extent;
	protected ExtentTest test;
	//protected Logger log=Logger.getLogger(BaseClass.class.getName());
	
	private static final Logger log=LogManager.getLogger(BaseClass.class);
	
	
	@BeforeMethod
	public void setup(Method method) throws IOException, InterruptedException {
		//log.info("\"===== Test Start: \" + method.getName() + \" =====\"");
		log.info("==== Test Start:" + method.getName() +" =====");
		
		//getting config.properties
		prop=new Properties();
		FileInputStream fis=new FileInputStream("src/test/resources/config.properties");
		prop.load(fis);
		
		//setup browser
		String browser = prop.getProperty("browser").toLowerCase();
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions=new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			driver=new ChromeDriver(chromeOptions);
			break;
		
		case "safari":
			WebDriverManager.safaridriver().setup();
			
			driver=new SafariDriver();
			driver.manage().window().maximize();
			
		}
		
		// Init Extent
		    extent = ExtentManager.getInstance();
	        test = extent.createTest(method.getName());
		//Launch App
	        driver.get(prop.getProperty("url"));
	        log.info("Launched Url: "+prop.getProperty("url"));
	        Thread.sleep(3000);
		
		
	}
		@AfterMethod
		public void tearDown(ITestResult result) throws InterruptedException {
			if(result.getStatus()==ITestResult.FAILURE) {
				test.fail(result.getThrowable());
				log.error("Test case Failed: "+result.getThrowable());
				
			}else if(result.getStatus()==ITestResult.SUCCESS) {
				test.pass("Test Passed...!");
				log.info("Test passed...!");
			}
			
			if(driver!=null) {
				Thread.sleep(5000);
				driver.quit();
			}
			
			extent.flush();
			log.info("Test End");
		}



}

package com.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.base.ExplicitWaitUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class HomePage extends ProjectSpecifiMethods {

    WebDriver driver;
    ExplicitWaitUtils util;
    Logger log = LogManager.getLogger(HomePage.class);
    //SoftAssert ass=new SoftAssert();
    protected ExtentTest test;
    SoftAssert ass;
    

    public HomePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.util = new ExplicitWaitUtils(driver);
        this.test = test;
        this.ass = new SoftAssert();
    }

    private By dashboard = By.xpath("//a[@class='oxd-main-menu-item active']");
    private By allLinks = By.tagName("a");
    //private By canvas=By.xpath("//div[@class='oxd-pie-chart']//canvas[@id='4PdeqCB7']");
    
    
    

    public void checkDashboardMenuVisibility() {
        try {
            WebElement checkDash = util.waitForElementVisibleLocated(dashboard, 5);
            ass.assertTrue(checkDash.isDisplayed(), "Login Failed..!");
            log.info("Dashboard Menu Identified. Hence Landed in Home Page");
            test.info("Dashboard Menu Identified. Hence Landed in Home Page");

        } catch (Exception e) {
            ass.fail("Login Failed");
            log.info("Login Test Failed - from log");
            test.info("Login Test Failed -- from extent reports");

        }
        ass.assertAll();
     
    }

    public  void checkAllLinks() {
        List < WebElement > homeLinks = driver.findElements(allLinks);
        List < String > brokenLinks = new ArrayList < > ();
        List < String > validLinks = new ArrayList < > ();

   
        for (WebElement eachLink: homeLinks) {
            String link = eachLink.getDomAttribute("href");


            log.info("Link in Home Page is: " + link);
            test.info("Link in Home Page is " + link);
            if (!link.isEmpty()) {
                String status = checkUrlStatus(link);
                if (status.startsWith("Broken")) {
                	brokenLinks.add(link +" - "+status);
            }else {
            	validLinks.add(link+" - "+status);
            }
        }
        
    }

        //print results
        System.out.println("Valid Links in Home Page");
        for(String validUrl: validLinks) {
        	System.out.println(validUrl);
        	log.info("Valid Urls in home page: "+validUrl);
        }
        
       System.out.println("Invalid Links in home page");
       if(brokenLinks.isEmpty()) {
    	   System.out.println("No Broken Links Found");
       }else {
    	   for(String brokenUrl: brokenLinks) {
    		   System.out.println("Broken Links in Home Page: "+brokenUrl);
    		   log.info("Broken Links in Home Page: "+brokenUrl);
    	   }
       }
   

    }
    public String checkUrlStatus(String link) {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int responseCode = connection.getResponseCode();
            if (responseCode >= 400) {
                return "Broken (HTTP " + responseCode + ")";
            } else {
                return "OK (HTTP " + responseCode + ")";
            }
        } catch (IOException e) {
            return "Broken (" + e.getMessage() + ")";





        }


    }

    
    public void gotoEmployeeDistributionbyLocationChart() {
    	
    	WebElement title=driver.findElement(By.xpath("//p[text()=\"Employee Distribution by Location\"]"));
    	//WebElement canvasEle=driver.findElement(canvas);
    	WebElement assignLeaveButton=driver.findElement(By.xpath("//button[@class='oxd-icon-button orangehrm-quick-launch-icon']"));
    	
      	Actions action=new Actions(driver);
        action.moveToElement(assignLeaveButton).build().perform();
        takeSnapShot(driver, "./ScreenShots/canvasSS.png");
        
        util.waitForElementVisibleOf(title, 5);
    	jsScrollIntoView(driver, title);
    	takeSnapShot(driver, "./ScreenShots/scroll.png");
    	
    	
    	
    	
    	
    }
    

}
package com.tests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.base.TestDataProvider;
import com.pages.LoginPage;

public class LoginTest extends BaseClass{

	Logger log=LogManager.getLogger(LoginTest.class);
	SoftAssert ass=new SoftAssert();
	
	@Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
	public void testLogin(String userName, String password) {
		log.info("Starting login test for User: "+userName);
		test.info("Starting login test for User: "+userName);
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserId(userName);
		log.info("Entered Username");
		test.info("Entered Username");
		
		loginPage.enterPassword(password);
		log.info("Entered Password");
		test.info("Entered Password");
		
		loginPage.enterClick();
		log.info("Clicked on Login Button");
		test.info("Clicked on Login button");
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	   // WebElement upgrade=	driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']"));
		try {
		WebElement dashBoard=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='oxd-main-menu-item active']")));
		ass.assertTrue(dashBoard.isDisplayed(), "Login Failed");
		log.info("Login Success as DashBorad is visible");
		test.info("Login Success as DashBorad is visible for"+userName);
		
		}catch(Exception e) {
			log.info("Login Failed as DashBorad is not visible");
			test.info("Login Failed as DashBorad is not visible for"+userName);
			ass.fail("Dashboard not displayed due to some exceptions");
		}
		
		ass.assertAll();
	}
}

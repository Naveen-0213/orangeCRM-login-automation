package com.tests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.base.BaseClass;
import com.base.ExplicitWaitUtils;
import com.base.TestDataProvider;
import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginTest extends BaseClass{

	Logger log=LogManager.getLogger(LoginTest.class);
	SoftAssert ass=new SoftAssert();
	ExplicitWaitUtils util;
	
	@Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
	public void testLogin(String userName, String password) {
		log.info("Starting login test for User: "+userName);
		test.info("Starting login test for User: "+userName);
		
		LoginPage loginPage=new LoginPage(driver, test);
		loginPage.enterUserId(userName);
		log.info("Entered Username");
		test.info("Entered Username");
		
		loginPage.enterPassword(password);
		log.info("Entered Password");
		test.info("Entered Password");
		
		loginPage.enterClick();
		log.info("Clicked on Login Button");
		test.info("Clicked on Login button");
		
		HomePage homePage=new HomePage(driver, test);
		homePage.checkDashboardMenuVisibility();
		homePage.checkAllLinks();
		homePage.gotoEmployeeDistributionbyLocationChart();
		

		
	}
}

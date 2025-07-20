package com.tests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.base.BaseClass;
import com.base.CustomExtentReporer;
import com.base.ExplicitWaitUtils;
import com.base.TestDataProvider;
import com.pages.HomePage;
import com.pages.LoginPage;


@Listeners(com.base.SuiteListener.class)
public class LoginTest extends BaseClass {
    private static final Logger log = LogManager.getLogger(LoginTest.class);
    private ExplicitWaitUtils util;

    @Test(groups = {"smoke"}, dataProvider = "loginData", dataProviderClass = TestDataProvider.class,
            invocationCount = 1, timeOut = 10000)
    public void testLogin(String userName, String password) {
        log.info("Starting login test for User: {}", userName);
        if (test == null) {
            log.warn("ExtentTest is null in testLogin, initializing fallback");
            test = CustomExtentReporer.createTest("testLogin_fallback_" + Thread.currentThread().getId());
            test.warning("Fallback ExtentTest initialized due to null test");
            println('cofecfully conflict added')
        }
        test.info("Starting login test for User: " + userName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserId(userName);
        log.info("Entered Username");
        test.info("Entered Username");

        loginPage.enterPassword(password);
        log.info("Entered Password");
        test.info("Entered Password");

        loginPage.enterClick();
        log.info("Clicked on Login Button");
        test.info("Clicked on Login button");

        HomePage homePage = new HomePage(driver);
        homePage.checkDashboardMenuVisibility();
        homePage.checkAllLinks();
        homePage.gotoEmployeeDistributionbyLocationChart();
        log.info("Completed login test for User: {}", userName);
    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = TestDataProvider.class,
            invocationCount = 3, timeOut = 10000, groups={"reg"})
    public void invalidTestInLogin(String userName, String password) {
        log.info("Starting invalid login test for User: {}", userName);
        if (test == null) {
            log.warn("ExtentTest is null in invalidTestInLogin, initializing fallback");
            test = CustomExtentReporer.createTest("invalidTestInLogin_fallback_" + Thread.currentThread().getId());
            test.warning("Fallback ExtentTest initialized due to null test");
        }
        test.info("Starting invalid login test for User: " + userName);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserId(userName);
        log.info("Entered Username");
        test.info("Entered Username");

        loginPage.enterPassword(password);
        log.info("Entered Password");
        test.info("Entered Password");

        loginPage.enterClick();
        log.info("Clicked on Login Button");
        test.info("Clicked on Login button");

        HomePage homePage = new HomePage(driver);
        homePage.checkDashboardMenuVisibility();
        homePage.checkAllLinks();
        homePage.gotoEmployeeDistributionbyLocationChart();
        log.info("Completed invalid login test for User: {}", userName);
    }
}

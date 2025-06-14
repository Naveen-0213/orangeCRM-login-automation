package com.pages;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.base.ExplicitWaitUtils;
import com.tests.LoginTest;

public class LoginPage {
	WebDriver driver;
	Properties prop;
	Logger log=LogManager.getLogger(LoginPage.class);
	//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	ExplicitWaitUtils util;
	protected ExtentTest test;
	
	private By userIdInput=By.xpath("//input[@name='username']");
	private By passInput=By.xpath("//input[@class='oxd-input oxd-input--active']");
	private By loginButton=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
				
	
	public LoginPage(WebDriver driver, ExtentTest test ) {
		this.driver=driver;
		this.util=new ExplicitWaitUtils(driver);
		this.test=test;
		
	}
	
	public LoginPage enterUserId(String userId) {
		WebElement user=driver.findElement(userIdInput);
		//wait.until(ExpectedConditions.visibilityOf(user));
		util.waitForElementVisibleOf(user, 5);
		user.sendKeys(userId);
		return this;
		
	}
	
	public LoginPage enterPassword(String password) {
		driver.findElement(passInput).sendKeys(password);
		return this;
	}
	
	public HomePage enterClick() {
		driver.findElement(loginButton).click();
		return new HomePage(driver, test);
	}
	
	
	public HomePage loginAs(String username, String password) {
		enterUserId(username);
		enterPassword(password);
		enterClick();
		
		return new HomePage(driver, test);
	}
	
	


}

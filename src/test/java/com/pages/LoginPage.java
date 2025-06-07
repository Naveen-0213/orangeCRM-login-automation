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

import com.tests.LoginTest;

public class LoginPage {
	WebDriver driver;
	Properties prop;
	Logger log=LogManager.getLogger(LoginPage.class);
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	
	private By userIdInput=By.xpath("//input[@name='username']");
	private By passInput=By.xpath("//input[@class='oxd-input oxd-input--active']");
	private By loginButton=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
				
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void enterUserId(String userId) {
		WebElement user=driver.findElement(userIdInput);
		wait.until(ExpectedConditions.visibilityOf(user));
		user.sendKeys(userId);
		
	}
	
	public void enterPassword(String password) {
		driver.findElement(passInput).sendKeys(password);
		
	}
	
	public void enterClick() {
		driver.findElement(loginButton).click();
	}
	


}

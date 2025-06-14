package com.base;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitUtils {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ExplicitWaitUtils(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public WebElement waitForElementVisibleLocated(By locator, int timeoutInSeconds) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public WebElement waitForElementVisibleOf(WebElement locator, int timeoutInSeconds) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.visibilityOf(locator));
		
	}
	
	public WebElement waitForElementClickable(By locator, int timeoutInSeconds) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
}

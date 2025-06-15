package com.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectSpecifiMethods {
//	private WebDriver driver;
//	
//	public ProjectSpecifiMethods(WebDriver driver) {
//		this.driver=driver;
//	}
	
	//JavaScriptExecutor
	public void jsScrollIntoView(WebDriver driver,WebElement ele) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();", ele );
	
	}
	
	//TakesScreenShot
	
	public void takeSnapShot(WebDriver driver,String filepath) {
		try {
		TakesScreenshot shot=(TakesScreenshot)driver;
		File src=shot.getScreenshotAs(OutputType.FILE);
		File dest=new File(filepath);
		FileUtils.copyFile(src, dest);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	
	

}

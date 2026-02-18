package com.ReusableFunctions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Baseclass.Library;

public class SeleniumReusable extends Library{
	public SeleniumReusable(WebDriver driver) {
		Library.driver=driver;
	}
	
	
	public void EnterValue(WebElement element, String text) {
		try {
			element.sendKeys(text);
		}
		catch(Exception e) {
			System.out.println("No Such element Exception");
		}
	}
	
	public void click(WebElement element) {
		
		try {
			element.click();
		}
		catch(Exception e) {
			System.out.println("No Such element Exception");
		}
		
	}
	
	public void getTitle() {
		try {
			System.out.println(driver.getTitle());
		}
		catch(Exception e) {
			System.out.println("Unable to fetch title.");
		}
		
	}
	
	public void screenShot(String path) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(source, new File(path));
		}
		catch(Exception e) {
			System.out.println("Screenshot not found");
		}
	}

}

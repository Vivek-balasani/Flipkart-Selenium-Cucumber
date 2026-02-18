package com.Baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Library {
	public static Properties prop;
	public static WebDriver driver;
	
	
	
	public void launchApplication() throws IOException {
		FileInputStream input = new FileInputStream("src/test/resources/Properties/Config.Property");
		prop = new Properties();
		prop.load(input);
		
		
		try {
			
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("user-data-dir=/Users/yourname/selenium-profile");
				driver = new ChromeDriver();
			}
			else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
			}
			else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
			}
			else {
				System.out.println("No such browser found");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
			driver.navigate().to(prop.getProperty("url"));
			driver.navigate().refresh();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void teardown() {
		driver.close();
	}

}

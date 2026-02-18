package com.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Baseclass.Library;
import com.ReusableFunctions.SeleniumReusable;

public class SearchPage extends Library{
	SeleniumReusable se = new SeleniumReusable(driver);
	
	 
	public SearchPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='olwU0Z BseBiK']//input[@name='q']")
	WebElement searchText;
	
	
	@FindBy(xpath="//html[@lang='en-IN']")
	WebElement homePage;
	
	@FindBy(xpath="//html[@lang='en']")
	WebElement resultsPage;
	
	public void search(String text) {
		se.EnterValue(searchText, text);
		
	}
	public void clickSearch() {
		searchText.sendKeys(Keys.ENTER);
	}
	
	public void homeScreen() {
		System.out.println(homePage.isDisplayed());
	}
	
	public void resultsScreen() {
		System.out.println(resultsPage.isDisplayed());
		
	
	}
	

}

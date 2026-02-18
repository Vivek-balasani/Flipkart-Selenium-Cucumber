package com.StepDefinitions;

import java.io.IOException;

import com.Baseclass.Library;
import com.Pages.SearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchMobile_Testcase extends Library{

SearchPage sp = new SearchPage(driver);


@Given("Launch the Flipkart Application")
public void launch_the_flipkart_application() throws IOException {
	launchApplication();
  
}

@When("Close the popup")
public void close_the_popup() {
	System.out.println(driver.getTitle());
  
}

@Then("It should navigate to the Home Page")
public void it_should_navigate_to_the_home_page() {
	
	sp.homeScreen();
	System.out.println("Stuck here!");
	
   
}

@Given("User enter the text in the search field")
public void user_enter_the_text_in_the_search_field() {
	
	sp.search("Mobile");
	
  
}
@When("Click the search button")
public void click_the_search_button() {
	sp.clickSearch();
   
}

@Then("It should navigate to the search results page and display relavant details")
public void it_should_navigate_to_the_search_results_page_and_display_relavant_details() {
   
	sp.resultsScreen();
	sp.teardown();
}


	

}

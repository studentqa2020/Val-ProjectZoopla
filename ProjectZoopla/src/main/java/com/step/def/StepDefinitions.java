package com.step.def;

import org.openqa.selenium.WebDriver;

import com.cucumber.CucumberBaseLogin;
import com.cucumber.CucumberPropertySelection;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	
	public WebDriver driver;
	
	@Given("open a browser")
	public void open_a_browser() {
	   driver = CucumberBaseLogin.setupBrowser();
	}

	@Given("Put URL")
	public void put_URL() throws Throwable {
	    CucumberBaseLogin.getUrl(driver);
	}

	@When("Click Signin")
	public void click_Signin() {
	   CucumberBaseLogin.clickSignIn(driver);
	}

	@When("put valid user name")
	public void put_valid_user_name() throws Throwable {
	    CucumberBaseLogin.enterUserName(driver);
	}

	@When("put valid password")
	public void put_valid_password() throws Throwable {
	   CucumberBaseLogin.enterPassword(driver);
	}

	@When("click accept all cookies button")
	public void click_accept_all_cookies_button() {
	    CucumberBaseLogin.clickCookies(driver);
	}

	@When("click sign in button")
	public void click_sign_in_button() {
	    CucumberBaseLogin.logIn(driver);
	}
	
	@When("Validate login was success")
	public void validate_login_was_success() {
	    CucumberBaseLogin.loginSuccessfull(driver);
	}

	@When("select property")
	public void select_property() throws Throwable {
	   CucumberPropertySelection.selectProperty(driver);
	}
	
	@When("get Agent Info")
	public void get_Agent_Info() {
		CucumberPropertySelection.getAgentInfo(driver);
	    
	}

	@Then("Signout")
	public void signout() {
		CucumberPropertySelection.singOut(driver);
	}



}

package com.app.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.app.action.LoginPageAction;
import com.app.utility.SeleniumDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NopLoginSteps {

	private static final Logger logger = LogManager.getLogger(NopLoginSteps.class.getName());

	LoginPageAction loginPageAction = new LoginPageAction();

	@Given("^Navigate to \"([^\"]*)\"$")
	public void navigate_to_nopcommerce_com(String url) throws Throwable {
		logger.debug("Debug Ecommerce application");
		SeleniumDriver.setUp();
		SeleniumDriver.openurl(url);
		logger.info("Selenium webDriver object created and browse lunched successfully");
	}

	@When("^user logged in using username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_logged_in_using_username_as_and_password_as(String username, String password) throws Throwable {
		loginPageAction.userEnterUsernameAndPassword(username, password);
		logger.info("user enterd username and password");
	}

	@Then("^user enter login button$")
	public void user_enter_login_button() throws Throwable {
		loginPageAction.userclickOnLoginButton();
		logger.info("user successfully loged in");
	}
}

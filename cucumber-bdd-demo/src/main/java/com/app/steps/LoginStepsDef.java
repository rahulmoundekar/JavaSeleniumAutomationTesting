package com.app.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepsDef {

	@Given("^user is navigate to gmail account$")
	public void user_is_navigate_to_gmail_account() {
		System.out.println("user_is_navigate_to_gmail_account");
	}

	@When("^user enter username$")
	public void user_enter_username() {
		System.out.println("user_enter_username");
	}

	@And("^user enter password$")
	public void user_enter_password() {
		System.out.println("user_enter_password");
	}

	@Then("^user can see Inbox$")
	public void user_can_see_Inbox() {
		System.out.println("user_can_see_Inbox");
	}

}

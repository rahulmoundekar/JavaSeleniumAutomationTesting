package com.app.action;

import org.openqa.selenium.support.PageFactory;

import com.app.locators.LoginPageLocators;
import com.app.utility.SeleniumDriver;

public class LoginPageAction {

	LoginPageLocators loginPageLocators;

	public LoginPageAction() {
		SeleniumDriver.setUp();
		this.loginPageLocators = new LoginPageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), loginPageLocators);
	}

	public void userEnterUsernameAndPassword(String username, String password) {
		loginPageLocators.email.clear();
		loginPageLocators.email.sendKeys(username);
		loginPageLocators.password.clear();
		loginPageLocators.password.sendKeys(password);
	}

	public void userclickOnLoginButton() {
		loginPageLocators.loginBtn.click();
	}

}

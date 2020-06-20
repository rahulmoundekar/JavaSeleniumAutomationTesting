package com.app.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageLocators {

	@FindBy(how = How.ID, using = "Email")
	public WebElement email;

	@FindBy(how = How.ID, using = "Password")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@class='button-1 login-button']")
	public WebElement loginBtn;

}

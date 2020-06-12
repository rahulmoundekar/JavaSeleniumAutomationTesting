package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "username")
	WebElement username;

	@FindBy(how = How.ID, using = "password")
	WebElement password;

	@FindBy(how = How.ID, using = "loginsubmit")
	WebElement login;

	public void setUserName(String username) {
		this.username.sendKeys(username);
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public void submitBtn() {
		this.login.click();
	}

}

package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.LINK_TEXT, using = "Service Request")
	WebElement serviceRequest;

	@FindBy(xpath = "//a[@title='Departments']")
	WebElement departBtn;

	public void clickToSR() {
		serviceRequest.click();
	}

	public void clickToDepartment() {
		this.departBtn.click();
	}

}

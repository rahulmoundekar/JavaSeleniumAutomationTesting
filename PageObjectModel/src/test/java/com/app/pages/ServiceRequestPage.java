package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceRequestPage {

	WebDriver driver;

	public ServiceRequestPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@class='grid-action-align']//a[@name='12'][1]")
	WebElement editBtn;

	public void clickToEdit() {
		this.editBtn.click();
	}

}

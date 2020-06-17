package com.app.test.action;

import org.openqa.selenium.support.PageFactory;

import com.app.test.locators.HomeLocators;
import com.app.utility.SeleniumDriver;

public class HomePageAction {

	HomeLocators homeLocators = new HomeLocators();

	public HomePageAction() {
		SeleniumDriver.getInstance();
		PageFactory.initElements(SeleniumDriver.getDriver(), homeLocators);
	}

	public void clickToBuyPlusSell() {
		homeLocators.buyPlusSell.click();
	}

	public void clickToSearchCarMenu() {
		homeLocators.searchCars.click();
	}

}

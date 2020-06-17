package com.app.test.action;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.app.test.locators.SearchCarsLocators;
import com.app.utility.SeleniumDriver;

public class SearchCarPageAction {

	SearchCarsLocators searchCarsLocators = new SearchCarsLocators();

	public SearchCarPageAction() {
		SeleniumDriver.getInstance();
		PageFactory.initElements(SeleniumDriver.getDriver(), searchCarsLocators);
	}

	public void selectAnyMake() {
		Select select = new Select(searchCarsLocators.anyMake);
		select.selectByVisibleText("Audi");
	}

	public void selectAnyModel() {
		Select select = new Select(searchCarsLocators.anyModel);
		select.selectByVisibleText("A1");
	}

	public void selectAnyLocations() {
		Select select = new Select(searchCarsLocators.anyLocation);
		select.selectByVisibleText("NSW - Hunter");
	}

	public void selectAnyPrice() {
		Select select = new Select(searchCarsLocators.anyPrice);
		select.selectByVisibleText("$2,000");
	}

	public void findMyNextCar() {
		searchCarsLocators.findMyNextCar.click();
	}

}

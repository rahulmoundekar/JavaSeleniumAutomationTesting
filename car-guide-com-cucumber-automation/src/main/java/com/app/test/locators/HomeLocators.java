package com.app.test.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeLocators {

	@FindBy(how = How.LINK_TEXT, using = "buy + sell")
	public WebElement buyPlusSell;

	@FindBy(how = How.LINK_TEXT, using = "Search Cars")
	public WebElement searchCars;

}

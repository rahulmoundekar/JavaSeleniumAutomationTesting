package com.app.test.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchCarsLocators {
	
	@FindBy(how=How.ID,using="makes")
	public WebElement anyMake;
	
	@FindBy(how=How.ID,using="models")
	public WebElement anyModel;
	
	@FindBy(how=How.ID,using="locations")
	public WebElement anyLocation;
	
	@FindBy(how=How.ID,using="price")
	public WebElement anyPrice;
	
	@FindBy(how=How.ID,using="search-submit")
	public WebElement findMyNextCar;

}

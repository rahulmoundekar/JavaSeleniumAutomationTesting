package com.app.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CatalogProductLoctors {
	
	@FindBy(how = How.ID, using = "Email")
	public WebElement email;
}

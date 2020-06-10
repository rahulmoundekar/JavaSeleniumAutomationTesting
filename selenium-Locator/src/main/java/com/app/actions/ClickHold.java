package com.app.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickHold {

	public static void main(String[] args) throws InterruptedException {

		// Note: Following statement is required since Selenium 3.0,
		// optional till Selenium 2.0
		// Set system properties for geckodriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		String URL = "https://demoqa.com/draggable/";

		driver.get(URL);

		// It is always advisable to Maximize the window before performing DragNDrop
		// action
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		// Actions class method to drag and drop
		Actions builder = new Actions(driver);

		WebElement from = driver.findElement(By.id("draggable"));

		// Perform drag and drop
		builder.clickAndHold(from);
		builder.moveByOffset(60, 120);
		
		//xOffset horizontal offset. A negative value means moving the mouse left.
		//yOffset vertical offset. A negative value means moving the mouse up.
		
		builder.build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// verify text changed in to 'Drop here' box

		driver.close();

	}

}

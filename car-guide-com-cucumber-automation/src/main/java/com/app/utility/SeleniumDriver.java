package com.app.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {

	private static SeleniumDriver seleniumDriver = null;
	private static WebDriver driver = null;

	private SeleniumDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static void openUrl(String url) {
		driver.get(url);
	}

	public static void getInstance() {
		if (seleniumDriver == null)
			seleniumDriver = new SeleniumDriver();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
		seleniumDriver = null;
	}

}

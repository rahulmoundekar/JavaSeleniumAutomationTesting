package com.app.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	private WebDriver driver = null;
	public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		threadDriver.set(driver);
		return getDriver();
	}

	public static WebDriver getDriver() {
		return threadDriver.get();
	}
}

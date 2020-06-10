package com.app.client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExceptedConditionTest {

	private static WebDriver driver = null;

	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.get("http://demo.sentrifugo.com/index.php/");
		driver.get("http://demo.guru99.com/test/guru99home/");

		driver.manage().window().maximize();
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); // page
		// loading
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // element
		// visibility
		return driver;
	}

	public static void main(String[] args) {
		driver = getDriver();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		String eTitle = "Demo Guru99 Page";
		String aTitle = "";

		aTitle = driver.getTitle();

		if (aTitle.contentEquals(eTitle)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

		WebElement guru99seleniumlink;
		guru99seleniumlink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Insurance Project")));
		guru99seleniumlink.click();
	}

}

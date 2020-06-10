package com.app.client;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConditionTest {

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

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		String eTitle = "Demo Guru99 Page";
		String aTitle = "";

		aTitle = driver.getTitle();

		if (aTitle.contentEquals(eTitle)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

		WebElement guru99seleniumlink;
		guru99seleniumlink = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.linkText("Insurance Project"));
			}
		});
		guru99seleniumlink.click();
	}
}
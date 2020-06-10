package com.app.client;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollByTest {

	WebDriver driver;

	public void ByPixel() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("http://demo.guru99.com/test/guru99home/");

		driver.manage().window().maximize();

		js.executeScript("window.scrollBy(0,1000)");
	}

	public static void main(String[] args) {

		ScrollByTest byTest = new ScrollByTest();
		byTest.ByPixel();
	}

}

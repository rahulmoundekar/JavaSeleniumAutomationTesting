package com.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvocationCountTest {

	WebDriver driver;

	@BeforeMethod
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
	}

	@Test(invocationCount = 5)
	public void googleSearch() {
		driver.findElement(By.className("gLFyf gsfi")).sendKeys("selenium Testing");
		driver.findElement(By.xpath("//div[@class='tfB0Bf']//input[@name=\"btnK\"]")).click();
	}

	@AfterMethod
	public void afterClass() {
		driver.close();
		driver.quit();
	}
}

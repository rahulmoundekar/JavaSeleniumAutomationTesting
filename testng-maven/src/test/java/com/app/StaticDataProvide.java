package com.app;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticDataProvide {

	WebDriver driver;

	@Test(dataProvider = "sentri", retryAnalyzer = IRetry.class)
	public void f(String username, String password) throws IOException {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("loginsubmit")).click();
		driver.findElement(By.id("logoutbutton")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	@DataProvider(name = "sentri")
	public Object[][] dp() {
		return new Object[][] { { "EM01", "sent" } };
	}

	@BeforeSuite
	public void beforeSuite() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://demo.sentrifugo.com/index.php/");
	}

	@AfterSuite
	public void afterSuite() {
		driver.close();
		driver.quit();
	}

}

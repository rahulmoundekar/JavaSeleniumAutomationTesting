package com.app;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class OrangeHrm {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@Test
	@Parameters({ "username", "password" })
	public void login(String username, String password) {
		Helper.takeScreen(driver);
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys(username);
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("input#btnLogin")).click();
	}

	@Test(dependsOnMethods = "login")
	public void logout() throws IOException {
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
	}

}

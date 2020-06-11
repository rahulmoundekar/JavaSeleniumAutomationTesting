package com.app;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.jsoup.safety.Cleaner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

public class OrangeHrmRetryLogin {

	WebDriver driver;

	@BeforeSuite
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.sentrifugo.com/index.php/");
	}

	@Test(retryAnalyzer = IRetry.class)
	public void login() {
		driver.findElement(By.cssSelector("input#username")).sendKeys("admin");
		driver.findElement(By.cssSelector("input#password")).sendKeys("admin12345");
		driver.findElement(By.cssSelector("input#loginSubmit")).click();
		driver.findElement(By.cssSelector("input#username")).clear();
		driver.findElement(By.cssSelector("input#password")).clear();
	}

	@AfterSuite
	public void afterClass() {
		driver.close();
		driver.quit();
	}

}

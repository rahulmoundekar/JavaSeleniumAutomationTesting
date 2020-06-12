package com.app.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.app.pages.DashboardPage;
import com.app.pages.LoginPage;
import com.app.pages.ServiceRequestPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PomTestRunner {
	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://demo.sentrifugo.com/index.php/");
	}

	@AfterSuite
	public void afterSuite() {
		driver.close();
		driver.quit();
	}

	@Test
	public void loginTest() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.setUserName("EM01");
		loginPage.setPassword("sentrifugo");
		loginPage.submitBtn();
	}

	@Test(dependsOnMethods = "loginTest")
	public void dashboard() throws InterruptedException {
		Thread.sleep(5000);
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickToSR();
		driver.navigate().back();
		dashboardPage.clickToDepartment();
		Thread.sleep(3000);
	}

}

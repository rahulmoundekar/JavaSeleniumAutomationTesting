package com.app.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.app.pages.DashboardPage;
import com.app.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({ AllureListener.class })
public class PomTestRunner {
	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() throws IOException {
		BaseClass baseClass = new BaseClass();
		driver = baseClass.initDriver();
		driver.get("http://demo.sentrifugo.com/index.php/");
	}

	@AfterSuite
	public void afterSuite() {
		driver.close();
		driver.quit();
	}

	@Test(priority = 1)
	@Feature("Feature1 : Login")
	@Epic("EP01")
	@Story("Story : Login Verification")
	@Step("Verify the username and password")
	@Description("this is login test case for sentrifugo")
	@Severity(SeverityLevel.MINOR)
	public void loginTest() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.setUserName("EM01");
		loginPage.setPassword("sentrifugo");
		loginPage.submitBtn();
	}

	@Test(priority = 2, dependsOnMethods = "loginTest")
	@Feature("Feature2 : Dashboard")
	@Epic("EP02")
	@Story("Story : Verify navigation")
	@Step("Verify the navigation")
	@Description("To verify the Datatable")
	@Severity(SeverityLevel.TRIVIAL)
	public void dashboard() throws InterruptedException {
		Thread.sleep(5000);
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickToSR();
		driver.navigate().back();
		dashboardPage.clickToDepartment();
		Thread.sleep(3000);
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3, description = "Verify user Registration")
	@Description("Verify user Registration........")
	@Epic("EP03")
	@Feature("Feature3: Registration")
	@Story("Story:User registration")
	public void registrationTest() {
		throw new SkipException("Skipping this Test");
	}

}

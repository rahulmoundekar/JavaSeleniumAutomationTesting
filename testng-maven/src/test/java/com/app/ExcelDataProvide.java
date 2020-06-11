package com.app;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class ExcelDataProvide {

	WebDriver driver;

	@Test(dataProvider = "sentri")
	public void f(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("loginsubmit")).click();
		driver.findElement(By.id("logoutbutton")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	@DataProvider(name = "sentri")
	public Object[][] dp() {
		String sheetName = "employee";
		Object[][] loginCredentials;
		
		ExcelUtils excelUtils = new ExcelUtils("sentri.xlsx");

		int rows = excelUtils.getRowCount(sheetName);
		int columns = excelUtils.getColumnCount(sheetName);
		
		loginCredentials = new Object[rows - 1][columns];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				loginCredentials[i - 1][j] = excelUtils.getCellData(sheetName, j, i);
			}
		}
		return loginCredentials;
	}

	@BeforeSuite
	public void beforeSuite() {
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

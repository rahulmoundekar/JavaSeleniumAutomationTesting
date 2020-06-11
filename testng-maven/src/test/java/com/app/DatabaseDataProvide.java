package com.app;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeSuite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class DatabaseDataProvide {

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
		Object[][] loginCredentials = null;
		int rows = TestNGDataBase.getRowsCount();
		int columns = TestNGDataBase.getColumnsCount() - 1;
		
		List<Login> logins = TestNGDataBase.loginCredentials();
		loginCredentials = new Object[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				loginCredentials[i][j++] = logins.get(i).getUsername();
				loginCredentials[i][j] = logins.get(i).getPassword();
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

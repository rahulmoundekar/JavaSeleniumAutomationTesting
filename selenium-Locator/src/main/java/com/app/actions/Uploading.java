package com.app.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Uploading {

	private static WebDriver driver = null;

	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.get("http://demo.sentrifugo.com/index.php/");
		driver.get("http://demo.sentrifugo.com/index.php/");

		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static void main(String[] args) {
		driver = getDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("EM04");
		driver.findElement(By.id("password")).sendKeys("sentrifugo");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("input[type='submit']")).click();

		driver.findElement(By.id("logoutbutton")).click();
		driver.findElement(By.xpath("//a[text()='View Profile']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement uploadProfile = driver.findElement(By.xpath("//input[@id='uploadimagepath']"));
		uploadProfile.click();
		driver.switchTo();
		uploadProfile.sendKeys("C:\\Users\\rahul\\OneDrive\\Pictures\\download (3).png");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.close();

	}

}

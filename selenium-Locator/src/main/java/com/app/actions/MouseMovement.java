package com.app.actions;

import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseMovement {

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

		WebElement username = driver.findElement(By.id("username"));

		Actions actions = new Actions(driver);
		actions.keyDown(username, Keys.SHIFT);
		actions.sendKeys("admin");
		actions.build().perform();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.close();

	}

}

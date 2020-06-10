package com.app.client;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame {

	private static WebDriver driver = null;

	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.get("http://demo.sentrifugo.com/index.php/");
		driver.get("https://jqueryui.com/draggable/");

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

		WebElement frame = driver.findElement(By.className("demo-frame"));

		driver.switchTo().frame(frame);

		WebElement draggable = driver.findElement(By.id("draggable"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(draggable);
		actions.moveToElement(draggable, 80, 160);
		actions.build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();//parent frame
		driver.close();

	}

}

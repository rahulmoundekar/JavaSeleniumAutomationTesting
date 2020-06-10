package com.app.client;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.sun.javafx.webkit.WebConsoleListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseMovement {

	private static WebDriver driver = null;

	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.get("http://demo.sentrifugo.com/index.php/");
		driver.get("https://demoqa.com/droppable/");

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //page loading 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // element visibility
		return driver;
	}

	public void dragAndDrop() {
		driver = getDriver();
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement dropable = driver.findElement(By.id("droppable"));

		Actions actions = new Actions(driver);
		actions.dragAndDrop(draggable, dropable);
		actions.build().perform();
	}

	public void doubleclickTest() {
		driver = getDriver();
		WebElement doubleclickElement = driver.findElement(By.id("doubleClickBtn"));
		Actions actions = new Actions(driver);
		actions.doubleClick(doubleclickElement);
		actions.build().perform();

		TargetLocator targetLocator = driver.switchTo();
		Alert alert = targetLocator.alert();
		System.out.println(alert.getText());
		alert.accept();
	}

	public void mouseMove() {
		driver = getDriver();
		WebElement mouse = driver.findElement(By.id("tooltipDemo"));
		Actions actions = new Actions(driver);
		actions.moveToElement(mouse);
		actions.build().perform();
	}

	public void keyboardCopyPaste() {

		driver = getDriver();
		driver.findElement(By.id("userName")).sendKeys("Rahul");
		WebElement currentAddress = driver.findElement(By.id("currentAddress"));
		currentAddress.sendKeys("Kharadi Pune-14");
		Actions actions = new Actions(driver);

		actions.keyDown(currentAddress, Keys.CONTROL).sendKeys("a").build().perform();
		actions.keyDown(Keys.CONTROL).sendKeys("c").build().perform();

		WebElement perAddres = driver.findElement(By.id("permanentAddress"));
		actions.keyDown(perAddres, Keys.CONTROL).sendKeys("v").build().perform();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

	public static void main(String[] args) {
		MouseMovement mouseMovement = new MouseMovement();
		mouseMovement.dragAndDrop();
	}

}

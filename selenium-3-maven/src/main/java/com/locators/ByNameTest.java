package com.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ByNameTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://demo.sentrifugo.com/index.php/");

		WebElement element = driver.findElement(By.name("username"));
		element.sendKeys("superadmin@example.com");

		WebElement element2 = driver.findElement(By.name("password"));
		element2.sendKeys("sentrifugo");

		
		WebElement submit=driver.findElement(By.id("loginsubmit"));
		submit.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement selfService=driver.findElement(By.linkText("Self Service"));
		selfService.click();
		
		
		driver.findElement(By.className("side-menu-selected")).click();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.close();

	}

}

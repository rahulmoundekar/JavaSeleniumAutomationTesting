package com.app.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathLocators {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		Navigation nav = driver.navigate();
		nav.to("https://opensource-demo.orangehrmlive.com/");
		// driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div[2]/form/div[2]/input")).sendKeys("Admin");
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div[2]/form/div[3]/input")).sendKeys("admin123");
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div[2]/form/div[5]/input")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"menu_leave_viewLeaveModule\"]/b")).click();

		driver.findElement(By.xpath("//*[@id=\"menu_leave_viewLeaveList\"]")).click();

		nav.back();
		nav.back();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		nav.forward();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		nav.refresh();

		driver.close(); // current url window close
		driver.quit(); // all open by selenium automation close it

	}

}

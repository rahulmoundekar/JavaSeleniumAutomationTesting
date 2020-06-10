package com.app.client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.app.utility.DriverUitlity;

public class UploadTest {

	public static void main(String[] args) {

		WebDriver driver = DriverUitlity.getDriver();

		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("admin123");

		driver.findElement(By.cssSelector("input.button")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Actions actions = new Actions(driver);
		WebElement pim = driver.findElement(By.cssSelector("a#menu_pim_viewPimModule"));
		actions.moveToElement(pim).build().perform();

		driver.findElement(By.cssSelector("a#menu_pim_addEmployee")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.cssSelector("input#firstName")).sendKeys("Rahul");
		driver.findElement(By.cssSelector("input#middleName")).sendKeys("yogeshwar");
		driver.findElement(By.cssSelector("input#lastName")).sendKeys("Moundekar");

		WebElement profile = driver.findElement(By.cssSelector("input#photofile"));
		profile.sendKeys("C:\\Users\\rahul\\OneDrive\\Pictures\\download (2).png");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("input#chkLogin")).click();

		driver.findElement(By.cssSelector("input#btnSave")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.close();
		driver.quit();
	}

}

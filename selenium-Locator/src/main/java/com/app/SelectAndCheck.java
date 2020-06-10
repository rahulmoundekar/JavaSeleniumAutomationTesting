package com.app;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectAndCheck {

	public static void main(String[] args) {

		WebDriver driver = DriverUitlity.getDriver();

		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("admin123");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("input[type='submit']")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"menu_leave_viewLeaveModule\"]/b")).click();

		driver.findElement(By.xpath("//*[@id=\"menu_leave_viewLeaveList\"]")).click();

		driver.findElement(By.cssSelector("input#calFromDate")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement months = driver.findElement(By.cssSelector("select.ui-datepicker-month"));
		months.click();
		Select select = new Select(months);
		select.selectByVisibleText("Feb");

		driver.findElement(By.xpath("//a[contains(text(),'15')]")).click();

		driver.findElement(By.cssSelector("input#leaveList_chkSearchFilter_1")).click();
		driver.findElement(By.cssSelector("input#leaveList_chkSearchFilter_2")).click();

		driver.findElement(By.cssSelector("input#leaveList_txtEmployee_empName")).sendKeys("abc");
		WebElement selectDep = driver.findElement(By.cssSelector("select#leaveList_cmbSubunit"));
		selectDep.click();
		Select select2 = new Select(selectDep);
		select2.selectByValue("6");

		driver.findElement(By.cssSelector("input#leaveList_cmbWithTerminated")).click();
		driver.findElement(By.cssSelector("input#btnSearch")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();

	}

}

package com.app.client;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.app.utility.DriverUitlity;

public class OrangeHrm {

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
		driver.findElement(By.cssSelector("a#menu_leave_viewLeaveModule")).click();

		driver.findElement(By.cssSelector("a#menu_leave_viewLeaveList")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.cssSelector("input#calFromDate")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement datepicker = driver.findElement(By.cssSelector("select.ui-datepicker-month"));
		Select select = new Select(datepicker);
		select.selectByVisibleText("Feb");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[text()='18']")).click();

		List<WebElement> checkboxes = driver.findElements(
				By.xpath("//div[@id='leaveList_chkSearchFilter_checkboxgroup']//input[@type='checkbox']"));

		for (WebElement webElement : checkboxes) {
			String values = webElement.getAttribute("value");
			if (values.equals("1")) {
				webElement.click();
			} else if (values.equals("2")) {
				webElement.click();
			} else if (values.equals("3"))
				webElement.click();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.cssSelector("input#leaveList_txtEmployee_empName")).sendKeys("Rahul");
		
		WebElement seldpt = driver.findElement(By.cssSelector("select#leaveList_cmbSubunit"));
		seldpt.click();
		Select deptSelect = new Select(seldpt);
		deptSelect.selectByValue("6");

		driver.findElement(By.cssSelector("input#leaveList_cmbWithTerminated")).click();

		driver.findElement(By.cssSelector("input[name='btnSearch']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.close();
		driver.quit();
	}

}

package com.app.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadingDemo1 {

	public static void main(String[] args) {
		String baseUrl = "https://pdf2doc.com/";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get(baseUrl);
		WebElement uploadElement = driver.findElement(By.xpath("//span[text()='Upload Files']"));
		uploadElement.click();
		driver.switchTo().activeElement();
		// enter the file path onto the file-selection input field
		//uploadElement.sendKeys("C:\\Users\\rahul\\OneDrive\\Pictures\\download (3).png");
		
	}
}

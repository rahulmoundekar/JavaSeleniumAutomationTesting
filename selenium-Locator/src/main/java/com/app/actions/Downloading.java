package com.app.actions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Downloading {

	public static void main(String[] args) {

		String baseUrl = "https://eternallybored.org/misc/wget/";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get(baseUrl);
		WebElement downloadButton = driver.findElement(By.xpath("//tr[2]//td[5]//a[text()='EXE']"));
		String path = "https://eternallybored.org/misc/wget/";

		String sourceLocation = downloadButton.getAttribute("href");
		String wget_command = "cmd /c C:\\Wget\\wget.exe -P C:--no-check-certificate https://eternallybored.org/misc/wget/1.20.3/64/wget.exe";

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Process exec = Runtime.getRuntime().exec(wget_command);
			int exitVal = exec.waitFor();
			System.out.println("Exit value: " + exitVal);
		} catch (InterruptedException ex) {
			System.out.println(ex.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
		driver.close();

	}

}

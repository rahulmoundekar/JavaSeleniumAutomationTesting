package com.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.session.FirefoxFilter;

public class ChromeTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe"); // to
																					// load
																														// chrome
																														// driver,
																														// firefox

		// instatialtion of chrome Driver
		WebDriver driver = new ChromeDriver();

		// WebDriver driver=new FirefoxDriver();

		String url = "https://www.facebook.com/";

		driver.get(url);

		String title = driver.getTitle();
		System.out.println(title);

		if (title.contentEquals("Facebook – log in or sign up")) {
			System.out.println("success");
		} else {
			System.out.println("failed");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();

	}

}

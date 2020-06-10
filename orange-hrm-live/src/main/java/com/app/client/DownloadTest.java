package com.app.client;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadTest {

	private static WebDriver driver = null;

	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.get("http://demo.sentrifugo.com/index.php/");
		driver.get("https://bigfoto.com/");

		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver;
	}

	public void download() throws InterruptedException {

		driver = getDriver();
		WebElement download = driver.findElement(By.xpath("//*[@id=\"colormag_featured_posts_slider_widget-3\"]/div/div[1]/div/div[2]/figure/a/img"));
		String sourceFilePAth = download.getAttribute("src");

		String cmd = "cmd /c E:\\wget\\wget.exe -P e:download " + sourceFilePAth;
		System.out.println(cmd);
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			int result = process.waitFor();
			System.out.println(result);
			if (result == 0)
				System.out.println("successfuly downloaded");
			else
				System.out.println("Download Failed.try again..");
		} catch (IOException e) {
			e.printStackTrace();
		}

		driver.quit();
	}

	public static void main(String[] args) {
		DownloadTest test = new DownloadTest();
		try {
			test.download();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

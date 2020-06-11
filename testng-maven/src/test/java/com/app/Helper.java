package com.app;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static void takeScreen(WebDriver driver) {

		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		Calendar cal = new GregorianCalendar();

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int time = cal.get(Calendar.MINUTE);

		String screnName = nameofCurrMethod + "" + year + "" + month + "" + time;

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "//screenshot//" + screnName + ".png";
		File destFile = new File(path);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

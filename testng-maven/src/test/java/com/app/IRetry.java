package com.app;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetry implements IRetryAnalyzer {

	int counter = 0;
	int retryCountr = 2;

	public boolean retry(ITestResult result) {
		if (counter < retryCountr) {
			counter++;
			return true;
		}
		return false;
	}

}

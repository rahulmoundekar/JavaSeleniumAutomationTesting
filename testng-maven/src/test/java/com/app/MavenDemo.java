package com.app;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MavenDemo {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
	}

	@BeforeGroups
	public void beforeGroups() {
		System.out.println("@BeforeGroups");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
	}

	@AfterGroups
	public void afterG() {
		System.out.println("@AfterGroups");
	}

	@AfterClass
	public void afterC() {
		System.out.println("@AfterClass");
	}

	@AfterTest
	public void afterT() {
		System.out.println("@AfterTest");
	}

	@AfterSuite
	public void afterS() {
		System.out.println("@AfterSuite");
	}

	@Test
	public void f() {
		System.out.println("f");
	}

	@Test
	public void f1() {
		System.out.println("f1");
	}
}

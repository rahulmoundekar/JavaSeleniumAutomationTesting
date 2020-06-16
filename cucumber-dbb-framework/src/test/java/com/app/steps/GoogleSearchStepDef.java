package com.app.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchStepDef {

	WebDriver driver;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@After
	public void close() {
		driver.close();
		driver.quit();
	}

	@Given("^i lunch chrome browser$")
	public void i_lunch_chrome_browser() {
		driver.get("https://www.google.com/");
	}

	@When("^i type the \"([^\"]*)\" in search box$")
	public void i_type_the_cucumber_feature_file_in_search_box(String search) {

		driver.findElement(By.name("q")).sendKeys(search);
	}

	@Then("^click on search button$")
	public void click_on_search_button() {
		driver.findElement(By.name("btnK")).click();
	}

	@Then("^i will see the result related search$")
	public void i_will_see_the_result_related_search() {
		System.out.println("i will see the result related search");
	}

	@Then("^enter messages$")
	public void enter_messages(DataTable dataTable) throws Throwable {
		List<String> list = dataTable.asList(String.class);
		System.out.println(list);
	}

}

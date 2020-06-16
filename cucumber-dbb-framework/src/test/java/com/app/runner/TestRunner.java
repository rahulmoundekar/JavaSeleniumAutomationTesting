package com.app.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/resources/googlesearch.feature" }, glue = { "com.app.steps" }, tags = {
		"@smoke", "@regression" }, plugin = { "pretty", "json:target/cucumber/cucumber.json" })
public class TestRunner extends AbstractTestNGCucumberTests {

}

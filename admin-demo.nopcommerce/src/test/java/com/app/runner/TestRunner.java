package com.app.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/resources/noplogin.feature"}, glue = { "com.app.steps" }, plugin = { "pretty",
		"json:target/cucumber/cucumber.json" })
public class TestRunner extends AbstractTestNGCucumberTests {

}

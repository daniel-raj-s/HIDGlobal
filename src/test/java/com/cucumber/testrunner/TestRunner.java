package com.cucumber.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "./src/test/resources/", glue = { "com.cucumber.stepdefinition" }, plugin = { "pretty",
		"summary", "html:BDD_Report/cucumber.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true, publish = true

		, tags = "@UI_Assignment")

public class TestRunner extends AbstractTestNGCucumberTests {

}

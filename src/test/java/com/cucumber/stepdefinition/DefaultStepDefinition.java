package com.cucumber.stepdefinition;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

import com.cucumber.pages.DocsPage;
import com.cucumber.pages.TutorialPage;
import com.cucumber.utils.WebDriverSingleton;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DefaultStepDefinition {

	private WebDriver driver = WebDriverSingleton.getDriver();
	public static String URL = "";
	TutorialPage tutorialPage = new TutorialPage(driver);

	DocsPage DocsPage = new DocsPage(driver);

	@AfterStep("@UI_Assignment or @Assignment1 or @Assignment2")
	public void addScreenshot(Scenario scenario) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
		scenario.attach(fileContent, "image/png", "screenshot");

	}

	@Given("User Navigates to {string}")
	public void loginTest(String url) {
		URL = url;
		driver.get(url);
		Assert.assertTrue(driver.getTitle().equals("React – A JavaScript library for building user interfaces"));
	}

	@Given("User clicks on Docs tab")
	public void user_clicks_on_tab_name() {
		DocsPage.clickDocsTab();
	}

	@And("Expand {string} section")
	public void user_clicks_on_section_name(String sectionName) {
		DocsPage.expandSection(sectionName);
	}

	@And("Highlight all sub element under {string}")
	public void user_highlights_submenu_on_section_name(String sectionName) {
		DocsPage.highLightSubElement(sectionName);
	}

	@And("Store sub elements of {string} text and links into file")
	public void user_store_subelements_on_file(String sectionName) {
		DocsPage.storeSubmenusInTextFile(URL, sectionName);
	}

	@Given("User clicks on the Tutorial tab")
	public void userClicksOnTutorialTab() {
		tutorialPage.clickTutorialTab();
	}

	@Then("User scrolls down the page")
	public void userScrollsDownThePage() {
		tutorialPage.scrollDown("1400");
	}

	@Then("User verifies the respected content is bolded on the right navigation")
	public void userVerifiesBoldedContentOnRightNavigation() {
		Assert.assertTrue(tutorialPage.verifyBoldedContentOnRightNav());
	}

	@Then("User verifies the blue color line is seen")
	public void userVerifiesBlueColorLine() {
		Assert.assertTrue(tutorialPage.verifyBlueColorLine());
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}

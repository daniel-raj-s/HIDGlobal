package com.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.utils.CommonUtils;

public class TutorialPage extends CommonUtils {

	public TutorialPage(WebDriver driver) {
		super(driver);

		// TODO Auto-generated constructor stub
	}

	private By tutorialTab = By.linkText("Tutorial");
	private By rightNavLinks = By.cssSelector(".css-1xy1fx4");
	private By blueColorLine = By.cssSelector(".css-ifgy4z");

	public void clickTutorialTab() {
		try {
			getElement(tutorialTab).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean verifyBoldedContentOnRightNav() {
		WebElement link = getElement(rightNavLinks);
		if (link.getCssValue("color").equals("rgba(26, 26, 26, 1)")) {
			System.out.println("Respected content is bolded on Right Navigation: " + link.getText());
			return true;
		} else {
			System.out.println("Respected content is not bolded on Right Navigation: " + link.getText());
			return false;
		}
	}

	public boolean verifyBlueColorLine() {
		WebElement blueLine = getElement(blueColorLine);
		String lineColor = blueLine.getCssValue("border-left");
		if (lineColor.equals("4px solid rgb(97, 218, 251)")) {
			return true;
		} else {
			System.out.println("Blue color line is not seen");
			return false;
		}
	}

}

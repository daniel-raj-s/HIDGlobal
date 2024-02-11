package com.cucumber.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

public class CommonUtils {
	private WebDriver driver = WebDriverSingleton.getDriver();
	private static FluentWait<WebDriver> wait;
	public static String path = System.getProperty("user.dir");
	public static FileWriter writer;

	public CommonUtils(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(500))
				.ignoring(Exception.class);
	}

	public void scrollDown(String size) {
		((JavascriptExecutor) driver).executeScript("scroll(0, " + size + ");");
	}

	public static WebElement getElement(By element) {
		return wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(element);
			}
		});
	}

	public static List<WebElement> getElements(By element) {
		return wait.until(new ExpectedCondition<List<WebElement>>() {
			@Override
			public List<WebElement> apply(WebDriver driver) {
				return driver.findElements(element);
			}
		});
	}

	public void highLightElement(WebElement elem) {
		// draw a border around the found element
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		}
	}

	public static void writeTextToFile(FileWriter writer, String text) {
		// Write each line to a file
		try {
			writer.write(text + "\n");
			System.out.println("Text has been written to the file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getText(WebElement elem) {
		return elem.getText();
	}

	/**
	 * Sleep script for the specified length (generally not an ideal solution)
	 * 
	 * @param length
	 */
	public void sleep(long length) {
		try {
			Thread.sleep(length);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
package com.cucumber.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSingleton {
    private static WebDriver driver;
	public final static int TIMEOUT = 5;
    // Private constructor to prevent instantiation from outside
    private WebDriverSingleton() {}

    // Method to initialize WebDriver if not already initialized and return the instance
    public static WebDriver getDriver() {
        if (driver == null) {
        	ChromeOptions option = new ChromeOptions();
            option.addArguments("--headless");
    		driver = new ChromeDriver(option);
    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        }
        return driver;
    }
}
package com.google;

import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


//named incorrect
public class VisibleRun extends TestCase {
    public WebDriver driver; // make privet and create getter

    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:/Users/ddzheber/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}

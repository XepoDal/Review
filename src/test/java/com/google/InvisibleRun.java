package com.google;

import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;


//named incorrect
public class InvisibleRun extends TestCase {
    public WebDriver driver; // make privet and create getter

    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:/Users/ddzheber/Downloads/chromedriver_win32/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setBinary("C:/Users/ddzheber/Downloads/chromedriver_win32/chromedriver.exe");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}

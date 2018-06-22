package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends PageObject{

    By help_element = By.id("header_help_id");
    By about_element = By.id("header_aboutus_id");
    By sign_in_element = By.id("header_login_id");
    By open_reg = By.id("login_registration_button_id");
    By game1 = By.id("banner_2_img");
    By game2 = By.id("banner_3_img");
    By game3 = By.id("banner_4_img");
    By game4 = By.id("banner_5_img");
    By game5 = By.id("banner_1_img");
    WebDriver driver;

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void pageOpen() {
        driver.get("http://supermath.ru/");
    }

    public void pageClose() {
        if (driver != null)
            driver.quit();
    }

    public PageObject helpClick()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(help_element));
         driver.findElement(help_element).click();
        HelpPage help_page = new HelpPage(driver);
        return help_page;
    }

    public PageObject aboutClick()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(about_element));
        driver.findElement(about_element).click();
        AboutPage about_page = new AboutPage(driver);
        return about_page;
    }

    public PageObject signInClick()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(sign_in_element));
        driver.findElement(sign_in_element).click();
        SignInPage signInObj = new SignInPage(driver);
        return signInObj;
    }

    public void regOpen()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(open_reg));
        driver.findElement(open_reg).click();
    }

    public GameObject game1Open()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(game1));
        driver.findElement(game1).click();
        Game1 Game1Obj = new Game1(driver);
        return Game1Obj;
    }

    public GameObject game2Open()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(game2));
        driver.findElement(game2).click();
        Game2 Game2Obj = new Game2(driver);
        return Game2Obj;
    }

    public GameObject game3Open()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(game3));
        driver.findElement(game3).click();
        Game3 Game3Obj = new Game3(driver);
        return Game3Obj;
    }

    public GameObject game4Open()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(game4));
        driver.findElement(game4).click();
        Game4 Game4Obj = new Game4(driver);
        return Game4Obj;
    }

    public GameObject game5Open()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(game5));
        driver.findElement(game5).click();
        Game5 Game5Obj = new Game5(driver);
        return Game5Obj;
    }

}

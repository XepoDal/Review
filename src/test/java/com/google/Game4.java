package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Game4 extends GameObject{
    By win_close = By.xpath("//*[@id=\"game\"]/div/div[1]/img[1]");
    By num1 = By.id("mo_number_1");
    By num2 = By.id("mo_number_2");
    By result = By.id("mo_result");
    public int actualResult;
    WebDriver driver;

    public Game4(WebDriver driver)
    {
        this.driver = driver;
    }

    public void winClose()
    {
        driver.findElement(win_close).click();
    }

    public void checkResult() {
        (new WebDriverWait(driver,180)).until(ExpectedConditions.visibilityOfElementLocated(By.id("mo_smile_img_id")));
        String str1 = driver.findElement(num1).getText();
        String str2 = driver.findElement(num2).getText();
        String str3 = driver.findElement(result).getText();
        String str4 = driver.findElement(By.id("mo_operation")).getText();
        if (str4.equals("+")) {
            actualResult = Integer.parseInt(str1.trim()) + Integer.parseInt(str2.trim());
        }
        else{ if (str4.equals("-")){
            actualResult = Integer.parseInt(str1.trim()) - Integer.parseInt(str2.trim());
        }
        }
        assert (str3.equals(String.valueOf(actualResult))) : "Wrong expected result";
    }
    public void timeOutTest(int summ){}
    public void timeOutTest(){}
    public void incorrectAnswersTest(int summ){}
    public void incorrectAnswersTest(){}
    public void correctAnswersTest(int breakpoint){}
    public void correctAnswersTest(){}
}

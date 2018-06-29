package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Game5 extends GameObject{
    By win_close = By.xpath("//*[@id=\"game\"]/div/div[1]/img[1]");
    By num1 = By.id("co_number_1");
    By num2 = By.id("co_number_2");
    By result = By.id("co_result");
    String answer;
    WebDriver driver;

    public Game5(WebDriver driver)
    {
        this.driver = driver;
    }

    public void winClose()
    {
        driver.findElement(win_close).click();
    }

    public void checkResult() {
        (new WebDriverWait(driver,180)).until(ExpectedConditions.visibilityOfElementLocated(By.id("co_smile_img_id")));
        String str1 = driver.findElement(num1).getText();
        String str2 = driver.findElement(num2).getText();
        String str3 = driver.findElement(result).getText();
        if (Integer.parseInt(str1.trim()) > Integer.parseInt(str2.trim())){
            answer = ">";
        }
        else{
            if (Integer.parseInt(str1.trim()) < Integer.parseInt(str2.trim())){
                answer = "<";
            }
            else {
                if (Integer.parseInt(str1.trim()) == Integer.parseInt(str2.trim())){
                    answer = "=";
                }
                else {
                    System.out.println("Error");
                }
            }
        }

        assert (str3.equals(String.valueOf(answer))) : "Wrong expected result";
    }
    public void timeOutTest(int summ){}
    public void timeOutTest(){}
    public void incorrectAnswersTest(int summ){}
    public void incorrectAnswersTest(){}
    public void correctAnswersTest(int breakpoint){}
    public void correctAnswersTest(){}
}

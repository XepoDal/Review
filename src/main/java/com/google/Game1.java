package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Formatter;

public class Game1 extends GameObject {
    By win_close = By.xpath("//*[@id=\"game\"]/div/div[1]/img[1]");////*[@id="results"]/div/div[1]/img
    By num1 = By.id("mo_number_1");
    By num2 = By.id("mo_number_2");
    By result = By.id("mo_result");
    By tasks_remain = By.id("tasks_remain");
    By tasks_all = By.id("tasks_all");
    By tasks_passed = By.id("tasks_passed");
    By tasks_failed = By.id("tasks_failed");
    By clock_for_time_out = By.id("mo_smile_img_id");
    By clock_img = By.id("time_icon");
    By clock = By.id("circles");
    By keys_img = By.id("kbrd_icon");
    By keys = By.id("keys_wrapper");
    By image_img = By.id("hero_icon");
    By image = By.id("hero_img");
    //String
    public int actualResult;
    WebDriver driver;
    public int tasks;

    public Game1(WebDriver driver)
    {
        this.driver = driver;
        /*(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(num1));
        this.tasks = Integer.parseInt(driver.findElement(tasks_all).getText());*/
    }
    public void winClose()
    {
        driver.findElement(win_close).click();
    }

    public void checkResult() {

        (new WebDriverWait(driver, 180)).until(ExpectedConditions.visibilityOfElementLocated(By.id("mo_smile_img_id")));
        String str1 = driver.findElement(num1).getText();
        String str2 = driver.findElement(num2).getText();
        String str3 = driver.findElement(result).getText();
        String str4 = driver.findElement(By.id("mo_operation")).getText();
        if (str4.equals("+")) {
            actualResult = Integer.parseInt(str1.trim()) + Integer.parseInt(str2.trim());
        } else {
            if (str4.equals("-")) {
                actualResult = Integer.parseInt(str1.trim()) - Integer.parseInt(str2.trim());
            }
        }
        assert (str3.equals(String.valueOf(actualResult))) : "Wrong expected result";

    }
    public void correctAnswersTest(int getQtyOfIterationsForWrongAnswers) {

        (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(tasks_remain));
        int qtyTasks = Integer.parseInt(driver.findElement(tasks_all).getText());
        for(int iter = 0; iter < getQtyOfIterationsForWrongAnswers; iter++)  {
            (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(num1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int varTasks_passed_Begin = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_Begin = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_Begin = Integer.parseInt(driver.findElement(tasks_remain).getText());
            String str1 = driver.findElement(num1).getText();
            String str2 = driver.findElement(num2).getText();
            String str4 = driver.findElement(By.id("mo_operation")).getText();
            int actualResult = 0;
            if (str4.equals("+")) {
                actualResult = Integer.parseInt(str1.trim()) + Integer.parseInt(str2.trim());
            } else {
                if (str4.equals("-")) {
                    actualResult = Integer.parseInt(str1.trim()) - Integer.parseInt(str2.trim());
                } else {
                    System.out.println("Incorrect operator");
                }
            }
            String strActualResult = new Integer(actualResult).toString();
            //System.out.println(str1 + " " + str4 + " " + str2 + " = " + strActualResult);
            StringBuilder testStringBuilder = new StringBuilder();
            Formatter testFormatter = new Formatter(testStringBuilder);
            for (int i = 0; i < strActualResult.length(); i++) {
                String subStr = strActualResult.substring(i, i + 1);
                testFormatter.format("key_%s", subStr);
                driver.findElement(By.id(testStringBuilder.toString())).click();
                testStringBuilder.setLength(0);
            }
            int varTasks_passed_End = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_End = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_End = Integer.parseInt(driver.findElement(tasks_remain).getText());
            assert varTasks_remain_End == varTasks_remain_Begin - 1 : "positiveTestCorrectAnswers: tasks remain";//
            assert varTasks_failed_Begin == varTasks_failed_End : "positiveTestCorrectAnswers: tasks failed";
            assert varTasks_passed_End == varTasks_passed_Begin + 1 : "positiveTestCorrectAnswers: tasks passed";
        }
        int varTasks_passed_AfterCycle  = Integer.parseInt(driver.findElement(tasks_passed).getText());
        int varTasks_failed_AfterCycle = Integer.parseInt(driver.findElement(tasks_failed).getText());
        int varTasks_remain_AfterCycle = Integer.parseInt(driver.findElement(tasks_remain).getText());
        assert (varTasks_passed_AfterCycle + varTasks_failed_AfterCycle + varTasks_remain_AfterCycle) == qtyTasks : "positiveTestCorrectAnswers: tasks summ" ;//
       // System.out.println("Positive test passed");
    }

    public void correctAnswersTest(){
        (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(tasks_remain));
        int qtyTasks = Integer.parseInt(driver.findElement(tasks_all).getText());
        int varTasksRemain = Integer.parseInt(driver.findElement(tasks_remain).getText());
        for(int iter = 0; iter < varTasksRemain - 1; varTasksRemain = Integer.parseInt(driver.findElement(tasks_remain).getText())) {
            (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(num1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int varTasks_passed_Begin = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_Begin = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_Begin = Integer.parseInt(driver.findElement(tasks_remain).getText());
            String str1 = driver.findElement(num1).getText();
            String str2 = driver.findElement(num2).getText();
            String str4 = driver.findElement(By.id("mo_operation")).getText();
            int actualResult = 0;
            if (str4.equals("+")) {
                actualResult = Integer.parseInt(str1.trim()) + Integer.parseInt(str2.trim());
            } else {
                if (str4.equals("-")) {
                    actualResult = Integer.parseInt(str1.trim()) - Integer.parseInt(str2.trim());
                } else {
                    System.out.println("Incorrect operator");
                }
            }
            String strActualResult = new Integer(actualResult).toString();
            //System.out.println(str1 + " " + str4 + " " + str2 + " = " + strActualResult);
            StringBuilder testStringBuilder = new StringBuilder();
            Formatter testFormatter = new Formatter(testStringBuilder);
            for (int i = 0; i < strActualResult.length(); i++) {
                String subStr = strActualResult.substring(i, i + 1);
                testFormatter.format("key_%s", subStr);
                driver.findElement(By.id(testStringBuilder.toString())).click();
                testStringBuilder.setLength(0);
            }
            int varTasks_passed_End = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_End = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_End = Integer.parseInt(driver.findElement(tasks_remain).getText());
            assert varTasks_remain_End == varTasks_remain_Begin - 1 : "positiveTestCorrectAnswers: tasks remain";//
            assert varTasks_failed_Begin == varTasks_failed_End : "positiveTestCorrectAnswers: tasks failed";
            assert varTasks_passed_End == varTasks_passed_Begin + 1 : "positiveTestCorrectAnswers: tasks passed";
        }
        int varTasks_passed_AfterCycle  = Integer.parseInt(driver.findElement(tasks_passed).getText());
        int varTasks_failed_AfterCycle = Integer.parseInt(driver.findElement(tasks_failed).getText());
        int varTasks_remain_AfterCycle = Integer.parseInt(driver.findElement(tasks_remain).getText());
        assert (varTasks_passed_AfterCycle + varTasks_failed_AfterCycle + varTasks_remain_AfterCycle) == qtyTasks : "positiveTestCorrectAnswers: tasks summ" ;//
    }

    public void timeOutTest(int getQtyOfIterationsForWrongAnswers) {

        (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(tasks_remain));
        int qtyTasks_Before_Cycle = Integer.parseInt(driver.findElement(tasks_all).getText());int varTasks_passed_Before_Cycle  = Integer.parseInt(driver.findElement(tasks_passed).getText());
        int varTasks_failed_Before_Cycle = Integer.parseInt(driver.findElement(tasks_failed).getText());
        for(int iter = 0; iter < getQtyOfIterationsForWrongAnswers; iter++) {
            (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(num1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int varTasks_passed_Begin = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_Begin = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_Begin = Integer.parseInt(driver.findElement(tasks_remain).getText());
            int qtyTasksInLoop_Begin = Integer.parseInt(driver.findElement(tasks_all).getText());
            StringBuilder testStringBuilder = new StringBuilder();
            Formatter testFormatter = new Formatter(testStringBuilder);
            (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(clock_for_time_out));
            String CorrectAnswer = driver.findElement(result).getText();
            for (int b = 0; b < CorrectAnswer.length(); b++) {
                String subStr = CorrectAnswer.substring(b, b + 1);
                testFormatter.format("key_%s", subStr);
                driver.findElement(By.id(testStringBuilder.toString())).click();
                testStringBuilder.setLength(0);
            }
            int varTasks_passed_End = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_End = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_End = Integer.parseInt(driver.findElement(tasks_remain).getText());
            int qtyTasksInLoop_End = Integer.parseInt(driver.findElement(tasks_all).getText());
            assert varTasks_remain_Begin == varTasks_remain_End  : "negativeTestTimeOut: tasks remain";//
            assert varTasks_failed_End == (varTasks_failed_Begin + 1) : "negativeTestTimeOut: tasks failed";
            assert varTasks_passed_End == varTasks_passed_Begin : "negativeTestTimeOut: tasks passed";
            assert qtyTasksInLoop_End == qtyTasksInLoop_Begin + 1 : "negativeTestTimeOut: tasks all";
        }
        int varTasks_failed_After_Cycle = Integer.parseInt(driver.findElement(tasks_failed).getText());
        int qtyTasks_After_Cycle = Integer.parseInt(driver.findElement(tasks_all).getText());
        assert varTasks_failed_After_Cycle - varTasks_failed_Before_Cycle == qtyTasks_After_Cycle - qtyTasks_Before_Cycle : "negativeTestTimeOut: incorrect relation";//
        //System.out.println("Time out test passed");
    }
    public void timeOutTest() {

        (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(tasks_remain));
        int qtyTasks_Before_Cycle = Integer.parseInt(driver.findElement(tasks_all).getText());int varTasks_passed_Before_Cycle  = Integer.parseInt(driver.findElement(tasks_passed).getText());
        int varTasks_failed_Before_Cycle = Integer.parseInt(driver.findElement(tasks_failed).getText());
        int varTasksRemain = Integer.parseInt(driver.findElement(tasks_remain).getText());
        for(int iter = 0; iter < varTasksRemain; iter++) {
            (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(num1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int varTasks_passed_Begin = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_Begin = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_Begin = Integer.parseInt(driver.findElement(tasks_remain).getText());
            int qtyTasksInLoop_Begin = Integer.parseInt(driver.findElement(tasks_all).getText());
            StringBuilder testStringBuilder = new StringBuilder();
            Formatter testFormatter = new Formatter(testStringBuilder);
            (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(clock_for_time_out));
            String CorrectAnswer = driver.findElement(result).getText();
            for (int b = 0; b < CorrectAnswer.length(); b++) {
                String subStr = CorrectAnswer.substring(b, b + 1);
                testFormatter.format("key_%s", subStr);
                driver.findElement(By.id(testStringBuilder.toString())).click();
                testStringBuilder.setLength(0);
            }
            int varTasks_passed_End = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_End = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_End = Integer.parseInt(driver.findElement(tasks_remain).getText());
            int qtyTasksInLoop_End = Integer.parseInt(driver.findElement(tasks_all).getText());
            assert varTasks_remain_Begin == varTasks_remain_End  : "negativeTestTimeOut: tasks remain";//
            assert varTasks_failed_End == (varTasks_failed_Begin + 1) : "negativeTestTimeOut: tasks failed";
            assert varTasks_passed_End == varTasks_passed_Begin : "negativeTestTimeOut: tasks passed";
            assert qtyTasksInLoop_End == qtyTasksInLoop_Begin + 1 : "negativeTestTimeOut: tasks all";
        }
        int varTasks_failed_After_Cycle = Integer.parseInt(driver.findElement(tasks_failed).getText());
        int qtyTasks_After_Cycle = Integer.parseInt(driver.findElement(tasks_all).getText());
        assert varTasks_failed_After_Cycle - varTasks_failed_Before_Cycle == qtyTasks_After_Cycle - qtyTasks_Before_Cycle : "negativeTestTimeOut: incorrect relation";//
        //System.out.println("Time out test passed");
    }

    public void incorrectAnswersTest(int getQtyOfIterationsForWrongAnswers) {

        (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(tasks_remain));
        int qtyTasks_Before_Cycle = Integer.parseInt(driver.findElement(tasks_all).getText());
        int varTasks_failed_Before_Cycle = Integer.parseInt(driver.findElement(tasks_failed).getText());
        for(int iter = 0; iter < getQtyOfIterationsForWrongAnswers; iter++) {
            (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(num1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int varTasks_passed_Begin = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_Begin = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_Begin = Integer.parseInt(driver.findElement(tasks_remain).getText());
            int qtyTasksInLoop_Begin = Integer.parseInt(driver.findElement(tasks_all).getText());
            String str1 = driver.findElement(num1).getText();
            String str2 = driver.findElement(num2).getText();
            String str4 = driver.findElement(By.id("mo_operation")).getText();
            int actualResult = 0;
            if (str4.equals("+")) {
                actualResult = Integer.parseInt(str1.trim()) + Integer.parseInt(str2.trim());
            } else {
                if (str4.equals("-")) {
                    actualResult = Integer.parseInt(str1.trim()) - Integer.parseInt(str2.trim());
                } else {
                    System.out.println("Incorrect operator");
                }
            }
            String strActualResult = new Integer(actualResult + 1).toString();
           // System.out.println(str1 + " " + str4 + " " + str2 + " = " + strActualResult);
            StringBuilder testStringBuilder = new StringBuilder();
            Formatter testFormatter = new Formatter(testStringBuilder);
            for (int i = 0; i < strActualResult.length(); i++) {
                String subStr = strActualResult.substring(i, i + 1);
                testFormatter.format("key_%s", subStr);
                driver.findElement(By.id(testStringBuilder.toString())).click();
                testStringBuilder.setLength(0);
            }
            String CorrectAnswer = driver.findElement(result).getText();
            for (int b = 0; b < CorrectAnswer.length(); b++) {
                String subStr = CorrectAnswer.substring(b, b + 1);
                testFormatter.format("key_%s", subStr);
                driver.findElement(By.id(testStringBuilder.toString())).click();
                testStringBuilder.setLength(0);
            }
            int varTasks_passed_End = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_End = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_End = Integer.parseInt(driver.findElement(tasks_remain).getText());
            int qtyTasksInLoop_End = Integer.parseInt(driver.findElement(tasks_all).getText());
            assert varTasks_remain_Begin == varTasks_remain_End  : "negativeTestWrongAnswers: tasks remain";//
            assert varTasks_failed_End == (varTasks_failed_Begin + 1) : "negativeTestWrongAnswers: tasks failed";
            assert varTasks_passed_End == varTasks_passed_Begin : "negativeTestWrongAnswers: tasks passed";
            assert qtyTasksInLoop_End == qtyTasksInLoop_Begin + 1 : "negativeTestWrongAnswers: tasks all";
        }
        int varTasks_failed_After_Cycle = Integer.parseInt(driver.findElement(tasks_failed).getText());
        int qtyTasks_After_Cycle = Integer.parseInt(driver.findElement(tasks_all).getText());
        assert varTasks_failed_After_Cycle - varTasks_failed_Before_Cycle == qtyTasks_After_Cycle - qtyTasks_Before_Cycle : "negativeTestWrongAnswers: incorrect relation";//
        //System.out.println("Wrong Answers test passed");
    }

    public void incorrectAnswersTest(){
        (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(tasks_remain));
        int qtyTasks_Before_Cycle = Integer.parseInt(driver.findElement(tasks_all).getText());
        int varTasks_failed_Before_Cycle = Integer.parseInt(driver.findElement(tasks_failed).getText());
        int varTasksRemain = Integer.parseInt(driver.findElement(tasks_remain).getText());
        for(int iter = 0; iter < varTasksRemain; iter++) {
            (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(num1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int varTasks_passed_Begin = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_Begin = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_Begin = Integer.parseInt(driver.findElement(tasks_remain).getText());
            int qtyTasksInLoop_Begin = Integer.parseInt(driver.findElement(tasks_all).getText());
            String str1 = driver.findElement(num1).getText();
            String str2 = driver.findElement(num2).getText();
            String str4 = driver.findElement(By.id("mo_operation")).getText();
            int actualResult = 0;
            if (str4.equals("+")) {
                actualResult = Integer.parseInt(str1.trim()) + Integer.parseInt(str2.trim());
            } else {
                if (str4.equals("-")) {
                    actualResult = Integer.parseInt(str1.trim()) - Integer.parseInt(str2.trim());
                } else {
                    System.out.println("Incorrect operator");
                }
            }
            String strActualResult = new Integer(actualResult + 1).toString();
            // System.out.println(str1 + " " + str4 + " " + str2 + " = " + strActualResult);
            StringBuilder testStringBuilder = new StringBuilder();
            Formatter testFormatter = new Formatter(testStringBuilder);
            for (int i = 0; i < strActualResult.length(); i++) {
                String subStr = strActualResult.substring(i, i + 1);
                testFormatter.format("key_%s", subStr);
                driver.findElement(By.id(testStringBuilder.toString())).click();
                testStringBuilder.setLength(0);
            }
            String CorrectAnswer = driver.findElement(result).getText();
            for (int b = 0; b < CorrectAnswer.length(); b++) {
                String subStr = CorrectAnswer.substring(b, b + 1);
                testFormatter.format("key_%s", subStr);
                driver.findElement(By.id(testStringBuilder.toString())).click();
                testStringBuilder.setLength(0);
            }
            int varTasks_passed_End = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_End = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_End = Integer.parseInt(driver.findElement(tasks_remain).getText());
            int qtyTasksInLoop_End = Integer.parseInt(driver.findElement(tasks_all).getText());
            assert varTasks_remain_Begin == varTasks_remain_End  : "negativeTestWrongAnswers: tasks remain";//
            assert varTasks_failed_End == (varTasks_failed_Begin + 1) : "negativeTestWrongAnswers: tasks failed";
            assert varTasks_passed_End == varTasks_passed_Begin : "negativeTestWrongAnswers: tasks passed";
            assert qtyTasksInLoop_End == qtyTasksInLoop_Begin + 1 : "negativeTestWrongAnswers: tasks all";
        }
        int varTasks_failed_After_Cycle = Integer.parseInt(driver.findElement(tasks_failed).getText());
        int qtyTasks_After_Cycle = Integer.parseInt(driver.findElement(tasks_all).getText());
        assert varTasks_failed_After_Cycle - varTasks_failed_Before_Cycle == qtyTasks_After_Cycle - qtyTasks_Before_Cycle : "negativeTestWrongAnswers: incorrect relation";
    }

    public void checkButtonShowHideTime() throws InterruptedException {

        (new WebDriverWait(driver,100)).until(ExpectedConditions.visibilityOfElementLocated(num1));
        assert (driver.findElement(clock).isDisplayed()) : "time on/off function error";
        driver.findElement(clock_img).click();
        driver.findElement(clock_img).click();
        Thread.sleep(1000);
        assert  (!(driver.findElement(clock).isDisplayed())) : "time on/off function error";
        driver.findElement(clock_img).click();
        System.out.println("checkButtonShowHideTime: success");

    }

    public void checkButtonShowHideKeys() throws InterruptedException {

        (new WebDriverWait(driver,100)).until(ExpectedConditions.visibilityOfElementLocated(num1));
        assert (driver.findElement(keys).isDisplayed()) : "time on/off function error";
        driver.findElement(keys_img).click();
        driver.findElement(keys_img).click();
        Thread.sleep(1000);
        assert  (!(driver.findElement(keys).isDisplayed())) : "time on/off function error";
        driver.findElement(keys_img).click();
        System.out.println("checkButtonShowHideKeys: success");

    }

    public void checkButtonShowHideHero() throws InterruptedException {

        (new WebDriverWait(driver,100)).until(ExpectedConditions.visibilityOfElementLocated(num1));
        assert (driver.findElement(image).isDisplayed()) : "time on/off function error";
        driver.findElement(image_img).click();
        driver.findElement(image_img).click();
        Thread.sleep(1000);
        assert  (!(driver.findElement(image).isDisplayed())) : "time on/off function error";
        driver.findElement(image_img).click();
        System.out.println("checkButtonShowHideHero: success");

    }


}



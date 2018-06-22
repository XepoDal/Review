package com.google;

public class TestGamePlayCorrectAnswers extends HeirClass{

    public void testGamePlayCorrectAnswers() {
        MainPage mainPage = new MainPage(driver);
        mainPage.pageOpen();
        GameObject Game1Obj = mainPage.game1Open();
        Game1Obj.correctAnswersTest();
    }

}

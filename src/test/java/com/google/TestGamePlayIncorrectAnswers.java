package com.google;

public class TestGamePlayIncorrectAnswers extends HeirClass{

    public void testGamePlayIncorrectAnswers() {
        MainPage mainPage = new MainPage(driver);
        mainPage.pageOpen();
        GameObject Game1Obj = mainPage.game1Open();
        Game1Obj.incorrectAnswersTest();
    }
}

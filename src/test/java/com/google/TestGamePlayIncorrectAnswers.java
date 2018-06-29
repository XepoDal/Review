package com.google;

public class TestGamePlayIncorrectAnswers extends InvisibleRun{

    public void testGamePlayIncorrectAnswers() {
        MainPage mainPage = new MainPage(driver);
        mainPage.pageOpen();
        GameObject Game1Obj = mainPage.game1Open();
        Game1Obj.incorrectAnswersTest();
    }
}

package com.google;

public class TestGamePlayCommon extends InvisibleRun{

    public void testGamePlayCommon() {
        MainPage mainPage = new MainPage(driver);
        mainPage.pageOpen();
        Game1 Game1Obj = (Game1) mainPage.game1Open();
        Game1Obj.timeOutTest(10);
        Game1Obj.incorrectAnswersTest(10);
        Game1Obj.correctAnswersTest(10);
    }

}

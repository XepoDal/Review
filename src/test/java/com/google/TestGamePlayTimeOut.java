package com.google;

public class TestGamePlayTimeOut extends InvisibleRun{

    public void testGamePlayTimeOut() {
    MainPage mainPage = new MainPage(driver);
    mainPage.pageOpen();
    GameObject Game1Obj = mainPage.game1Open();
    Game1Obj.incorrectAnswersTest();
    }
}

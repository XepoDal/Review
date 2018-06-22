package com.google;

public class TestGamePlayHideShowOptionsTime extends HeirClass{

    public void testGamePlayHideShowOptionsTime() {
        MainPage mainPage = new MainPage(driver);
        mainPage.pageOpen();
        Game1 Game1Obj = (Game1) mainPage.game1Open();
        try {
            Game1Obj.checkButtonShowHideTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

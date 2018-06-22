package com.google;

public class TestGamePlayHideShowOptionsKeys extends HeirClass{

    public void testGamePlayHideShowOptionsKeys() {
        MainPage mainPage = new MainPage(driver);
        mainPage.pageOpen();
        Game1 Game1Obj = (Game1) mainPage.game1Open();
        try {
            Game1Obj.checkButtonShowHideKeys();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

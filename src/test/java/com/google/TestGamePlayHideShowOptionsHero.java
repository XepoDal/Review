package com.google;

public class TestGamePlayHideShowOptionsHero extends HeirClass{

    public void testGamePlayHideShowOptionsHero() {
        MainPage mainPage = new MainPage(driver);
        mainPage.pageOpen();
        Game1 Game1Obj = (Game1) mainPage.game1Open();
        try {
            Game1Obj.checkButtonShowHideHero();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

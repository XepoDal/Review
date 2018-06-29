package com.google;

public class TestOpenAllGames extends InvisibleRun {

    public void testOpenAllGamesWithCheckResult () {
        MainPage main_page = new MainPage(driver);
        main_page.pageOpen();
        GameObject Game1Obj = main_page.game1Open();
        Game1Obj.checkResult();
        Game1Obj.winClose();
        GameObject Game2Obj = main_page.game2Open();
        Game2Obj.checkResult();
        Game2Obj.winClose();
        GameObject Game3Obj = main_page.game3Open();
        Game3Obj.checkResult();
        Game3Obj.winClose();
        GameObject Game4Obj = main_page.game4Open();
        Game4Obj.checkResult();
        Game4Obj.winClose();
        GameObject Game5Obj = main_page.game5Open();
        Game5Obj.checkResult();
        Game5Obj.winClose();
    }
}


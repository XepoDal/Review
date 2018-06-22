package com.google;

public class TestOpenInfoPages extends HeirClass {

    public void testOpenAllInfoPages () {
        //replace into setUp
        MainPage main_page = new MainPage(driver);
        main_page.pageOpen();
        assertEquals("SuperMath - Математика, обучение сложению, вычитанию, умножению и делению", driver.getTitle());// create method for getter mainPage and test it
        //
        PageObject HelpPageObj = main_page.helpClick();
        HelpPageObj.pageClose();
        PageObject AboutPageObj = main_page.aboutClick();
        AboutPageObj.pageClose();
        SignInPage SignInObj = (SignInPage) main_page.signInClick();
        SignInObj.typeEmail();
        SignInObj.typePassword();
        SignInObj.pageClose();
    }
}


package com.google;

public abstract class GameObject {

    abstract void checkResult();//rename checkGameResult
    abstract void winClose();//rename clickCloseGame
    abstract void timeOutTest(int summ);//rename waitGameTimeOut
    abstract void timeOutTest();//rename waitGameTimeOut
    abstract void incorrectAnswersTest(int summ);//rename enterIncorrectResult
    abstract void incorrectAnswersTest();
    abstract void correctAnswersTest(int breakpoint);
    abstract void correctAnswersTest();
}

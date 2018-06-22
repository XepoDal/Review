package com.google;

public abstract class GameObject {

    abstract void checkResult();
    abstract void winClose();
    abstract void timeOutTest(int summ);
    abstract void timeOutTest();
    abstract void incorrectAnswersTest(int summ);
    abstract void incorrectAnswersTest();
    abstract void correctAnswersTest(int breakpoint);
    abstract void correctAnswersTest();
}

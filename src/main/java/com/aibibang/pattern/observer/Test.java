package com.aibibang.pattern.observer;

/**
 * @author Truman.P.Du
 * @date 2020/06/26
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer a = new AObserver();
        Observer b = new BObserver();
        subject.add(a);
        subject.add(b);


        subject.notifyObserver();

    }
}

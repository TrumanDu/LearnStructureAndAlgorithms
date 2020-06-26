package com.aibibang.pattern.observer;

/**
 * @author Truman.P.Du
 * @date 2020/06/26
 * @description
 */
public class ConcreteSubject extends Subject {
    @Override
    public void notifyObserver() {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");
        for (Object obs : observers) {
            ((Observer) obs).response("change");
        }
    }
}

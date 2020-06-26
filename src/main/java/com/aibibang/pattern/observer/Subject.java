package com.aibibang.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Truman.P.Du
 * @date 2020/06/26
 * @description
 */
public abstract class Subject {
    protected List<Observer> observers = new ArrayList<Observer>();

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }
    public abstract void notifyObserver();
}

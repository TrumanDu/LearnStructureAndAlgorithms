package com.aibibang.pattern.observer;



/**
 * @author Truman.P.Du
 * @date 2020/06/26
 * @description
 */
public class BObserver implements Observer {

    @Override
    public void response(String msg) {
        System.out.println("B Observer received message:"+msg);
    }
}

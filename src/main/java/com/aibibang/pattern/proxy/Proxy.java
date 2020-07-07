package com.aibibang.pattern.proxy;

/**
 * @author: Truman.P.Du
 * @date: 2020/6/26 22:34
 * @description:
 */
public class Proxy implements Subject {

    private Subject subject = new ConcreteSubject();
    public void preRequest() {
        System.out.println("pre");
    }
    @Override
    public void request() {
       preRequest();
       subject.request();
       afterRequest();
    }
    public void afterRequest() {
        System.out.println("after");
    }
}

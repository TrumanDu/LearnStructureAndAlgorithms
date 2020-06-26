package com.aibibang.pattern.template;

/**
 * @author Truman.P.Du
 * @date 2020/06/19
 * @description
 */
public abstract class AbstractClass {
    public void init() {
        System.out.println("初始化。。。");
    }

    public void method() {
        init();
        execute();
        close();
    }

    public abstract void execute();
    public void close() {
        System.out.println("关闭资源。。。");
    }
}

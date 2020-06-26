package com.aibibang.pattern.single;

/**
 * @author Truman.P.Du
 * @date 2020/06/26
 * @description 饿汉单例模式
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}

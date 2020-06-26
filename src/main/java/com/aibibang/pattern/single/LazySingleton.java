package com.aibibang.pattern.single;

/**
 * @author Truman.P.Du
 * @date 2020/06/26
 * @description 懒汉单例
 */
public class LazySingleton {
    private static volatile LazySingleton instance = null;

    private LazySingleton() {
    }

    public synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

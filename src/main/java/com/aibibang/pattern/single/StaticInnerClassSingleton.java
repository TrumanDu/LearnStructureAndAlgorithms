package com.aibibang.pattern.single;

/**
 * @author Truman.P.Du
 * @date 2020/06/26
 * @description 静态内部类实现单例，性能更佳
 */
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {
    }

    public static StaticInnerClassSingleton getInstance() {
        return LazyHolder.innerClassSingleton;
    }

    private static class LazyHolder {
        private static StaticInnerClassSingleton innerClassSingleton = new StaticInnerClassSingleton();
    }
}

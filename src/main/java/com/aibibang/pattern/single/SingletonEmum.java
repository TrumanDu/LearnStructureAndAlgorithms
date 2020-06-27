package com.aibibang.pattern.single;

/**
 * @author Truman.P.Du
 * @date 2020/06/26
 * @description
 */
public enum SingletonEmum {
    INSTANCE;
    /**
     * 测试
      */
    String value;

    SingletonEmum(){
        value = "hello";
        System.out.println("init");
    }
    public void doSomething() {
        System.out.println(value);
    }

}

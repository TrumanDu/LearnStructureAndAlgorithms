package com.aibibang.pattern.single;

/**
 * @author Truman.P.Du
 * @date 2020/06/26
 * @description
 */
public enum SingletonEmum {
    INSTANCE;

    public SingletonEmum getInstance(){
        return INSTANCE;
    }
}

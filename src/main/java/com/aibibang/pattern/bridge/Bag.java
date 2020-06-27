package com.aibibang.pattern.bridge;

/**
 * @author Truman.P.Du
 * @date 2020/06/27
 * @description
 */
public abstract class Bag {
    Color color;
    public void setColor(Color color) {
        this.color = color;
    }

    abstract void echoName();
}

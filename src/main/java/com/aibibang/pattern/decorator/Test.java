package com.aibibang.pattern.decorator;

/**
 * @author Truman.P.Du
 * @date 2020/06/27
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Decorator decorator = new ConcreteDecoratorA(component);
        decorator.operation();
    }
}

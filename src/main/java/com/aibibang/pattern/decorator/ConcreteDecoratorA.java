package com.aibibang.pattern.decorator;

/**
 * @author Truman.P.Du
 * @date 2020/06/27
 * @description
 */
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    public void addFunction(){
        System.out.println("add a function");
    }

    @Override
    public void operation() {
        addFunction();
        super.operation();
    }
}

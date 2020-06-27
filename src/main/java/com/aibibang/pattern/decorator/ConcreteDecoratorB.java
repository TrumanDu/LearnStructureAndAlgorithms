package com.aibibang.pattern.decorator;

/**
 * @author Truman.P.Du
 * @date 2020/06/27
 * @description
 */
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    public void addFunction(){
        System.out.println("add b function");
    }

    @Override
    public void operation() {
        addFunction();
        super.operation();
    }
}

package com.aibibang.pattern.decorator;

/**
 * @author Truman.P.Du
 * @date 2020/06/27
 * @description
 */
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("Concrete Component operation");
    }
}

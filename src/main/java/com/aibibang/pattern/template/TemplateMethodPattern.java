package com.aibibang.pattern.template;

/**
 * @author Truman.P.Du
 * @date 2020/06/19
 * @description
 */
public class TemplateMethodPattern {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteAClass();
        abstractClass.method();
        AbstractClass b = new AbstractClass() {
            @Override
            public void execute() {
                System.out.println("执行B");
            }
        };
        b.method();
    }
}

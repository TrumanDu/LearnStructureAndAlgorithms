package com.aibibang.pattern.command;

/**
 * @author Truman.P.Du
 * @date 2020/06/26
 * @description
 */
public class Client {
    public static void main(String[] args) {
        Command command = new ConcreteCommand();
        Invoker invoker = new Invoker(command);
        invoker.execute();
    }
}

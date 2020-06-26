package com.aibibang.pattern.command;

/**
 * @author Truman.P.Du
 * @date 2020/06/26
 * @description
 */
public class ConcreteCommand implements Command {

    private Received received;

    public ConcreteCommand() {
        this.received = new Received();
    }

    @Override
    public void execute() {
        System.out.println("执行ConcreteCommand命令！");
        received.receiver();
    }
}

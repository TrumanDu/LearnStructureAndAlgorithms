package com.aibibang.pattern.command;

/**
 * @author Truman.P.Du
 * @date 2020/06/26
 * @description
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }
}

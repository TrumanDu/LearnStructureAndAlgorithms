package com.aibibang.pattern.bridge;

/**
 * @author Truman.P.Du
 * @date 2020/06/27
 * @description
 */
public class Wallet extends Bag {

    @Override
    void echoName() {
        System.out.println(color.getColor() + "的钱包");
    }
}

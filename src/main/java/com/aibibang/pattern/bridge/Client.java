package com.aibibang.pattern.bridge;

/**
 * @author Truman.P.Du
 * @date 2020/06/27
 * @description
 */
public class Client {


    public static void main(String[] args) {
        Color yellow = new Yellow();
        Color red = new Red();
        Bag bag = new Wallet();
        bag.setColor(yellow);
        bag.echoName();
        Bag handBag = new HandBag();
        handBag.setColor(red);
        handBag.echoName();
    }
}

package com.aibibang.stack;

/**
 * @author Truman.P.Du
 * @date 2019/08/27
 * @description 用数组实现一个顺序栈
 * 用链表实现一个链式栈
 * 编程模拟实现一个浏览器的前进、后退功能
 * <p>
 * 用数组实现一个顺序队列
 * 用链表实现一个链式队列
 * 实现一个循环队列
 */
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("测试ArrayStack：------------------------");
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        for (int i = 0; i < 6; i++) {
            try {
                stack.push(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 7; i++) {
            try {
                System.out.println(stack.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("测试LinkedStack：------------------------");
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        for (int i = 0; i < 6; i++) {
            try {
                linkedStack.push(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 7; i++) {
            try {
                System.out.println(linkedStack.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("测试浏览器：------------------------");
        Browser browser = new Browser();
        for (int i = 0; i < 10; i++) {
            browser.add("http://www.baidu.com" + i);
        }

        System.out.println(browser.backURL());
        System.out.println(browser.backURL());
        System.out.println(browser.backURL());
        System.out.println(browser.forwardURL());
        System.out.println(browser.forwardURL());
        System.out.println(browser.forwardURL());
    }
}

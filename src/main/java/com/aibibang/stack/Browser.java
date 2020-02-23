package com.aibibang.stack;

/**
 * @author Truman.P.Du
 * @date 2020/02/23
 * @description 编程模拟实现一个浏览器的前进、后退功能
 */
public class Browser {
    private LinkedStack<String> forwardStack = new LinkedStack<>();
    private LinkedStack<String> backStack = new LinkedStack<>();

    public String forward() throws Exception {
        String url = backStack.pop();
        forwardStack.push(url);
        return url;
    }

    public String back() throws Exception {
        String url = forwardStack.pop();
        backStack.push(url);
        return url;
    }

    public void view(String url) {
        forwardStack.push(url);
    }

    public static void main(String[] args) throws Exception {
        Browser browser = new Browser();

        browser.view("baidu.com");
        browser.view("google.com");
        browser.view("github.com");
        browser.view("aibibang.com");

        System.out.println(browser.back());
        System.out.println(browser.back());
        System.out.println(browser.back());
        System.out.println(browser.back());

        try {
            System.out.println(browser.back());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(browser.forward());
        System.out.println(browser.forward());
        System.out.println(browser.forward());
        System.out.println(browser.forward());

    }

}

package com.aibibang.stack;

/**
 * @author Truman.P.Du
 * @date 2019/08/30
 * @description
 * 编程模拟实现一个浏览器的前进、后退功能
 */
public class Browser {
    private LinkedStack<String> back = new LinkedStack();
    private LinkedStack<String> forward = new LinkedStack();

    public void add(String url) {
        back.push(url);
    }

    public String backURL() throws Exception {
        String url = back.pop();
        forward.push(url);
        return url;
    }

    public String forwardURL() throws Exception {
        String str = forward.pop();
        back.push(str);
        return str;
    }
}

package com.aibibang.character;

/**
 * @author: Truman.P.Du
 * @date: 2020/3/9 21:41
 * @description: 实现朴素的字符串匹配算法
 */
public class IncludeChar {

    public boolean isIncude(char[] a, char[] b) {

        char[] temp;
        if (a.length < b.length) {
            temp = a;
            a = b;
            b = temp;
        }
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[index]) {
                index = 0;
                continue;
            } else {
                index++;
                if (index == b.length) {
                    return true;
                }
            }
            if (a.length - (i + 1) < b.length - index) {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        IncludeChar includeChar = new IncludeChar();
        System.out.println(includeChar.isIncude("hello".toCharArray(), "h".toCharArray()));
        System.out.println(includeChar.isIncude("hello".toCharArray(), "hi".toCharArray()));
        System.out.println(includeChar.isIncude("hello".toCharArray(), "h2".toCharArray()));
        System.out.println(includeChar.isIncude("hello".toCharArray(), "hello".toCharArray()));
        System.out.println(includeChar.isIncude("hello".toCharArray(), "llo".toCharArray()));
    }
}

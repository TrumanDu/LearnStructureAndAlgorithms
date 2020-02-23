package com.aibibang.algorithms;

/**
 * @author Truman.P.Du
 * @date 2019/08/27
 * @description 编程实现斐波那契数列求值 f(n)=f(n-1)+f(n-2）
 * 编程实现求阶乘 n!
 * 编程实现一组数据集合的全排列
 */
public class Recursion {

    /**
     * 编程实现斐波那契数列求值 f(n)=f(n-1)+f(n-2）
     *
     * @param n
     * @return
     */
    public long method(int n) {
        if (n == 2 || n == 1) {
            return 1 ;
        }
        long result = method(n - 1) + method(n - 2);
        return result;
    }

    public long factorial(int n) {
        if (n == 2) {
            return 2 * 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println(recursion.method(30));
        System.out.println(recursion.factorial(10));
    }
}

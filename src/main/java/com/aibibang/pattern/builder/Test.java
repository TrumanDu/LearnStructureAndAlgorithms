package com.aibibang.pattern.builder;

/**
 * @author Truman.P.Du
 * @date 2020/06/26
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Bean bean = new Bean.Builder().a("a").b("b").c("c").build();
        System.out.println(bean.toString());
    }
}

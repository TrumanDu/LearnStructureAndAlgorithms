package com.aibibang.linked.node;

/**
 * @author Truman.P.Du
 * @date 2020/02/23
 * @description
 */
public class DoubleNode {
    public Object value;
    public DoubleNode pre = null;
    public DoubleNode next = null;

    public DoubleNode(Object value) {
        this.value = value;
    }
}

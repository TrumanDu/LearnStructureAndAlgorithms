package com.aibibang.stack;


import com.aibibang.linked.node.DoubleNode;

/**
 * @author Truman.P.Du
 * @date 2020/02/23
 * @description 用链表实现一个链式栈
 */
public class LinkedStack<E> {
    DoubleNode doubleNode;

    public void push(E element) {
        if (doubleNode == null) {
            doubleNode = new DoubleNode(element);
        } else {
            DoubleNode node = new DoubleNode(element);
            doubleNode.next = node;
            DoubleNode temp = doubleNode;
            doubleNode = node;
            doubleNode.pre = temp;
        }
    }


    public E pop() throws Exception {
        if (doubleNode != null) {
            DoubleNode node = doubleNode;
            doubleNode = doubleNode.pre;
            return (E) node.value;
        } else {
            throw new Exception("stack has no element!");
        }
    }

    public static void main(String[] args) throws Exception {
        LinkedStack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i <5 ; i++) {
            stack.push(i);
        }

        for (int i = 0; i <6 ; i++) {
            System.out.println(stack.pop());
        }
    }
}

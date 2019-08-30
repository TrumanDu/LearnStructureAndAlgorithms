package com.aibibang.stack;

/**
 * @author Truman.P.Du
 * @date 2019/08/29
 * @description
 */
public class LinkedStack<E> {

    private Node<E> tail;


    public void push(E element) {
        Node node = new Node<>(element);
        if (tail == null) {
            tail = node;
        } else {
            node.pre = tail;
            tail.next = node;
            tail = node;
        }

    }

    public E pop() throws Exception {
        if (tail == null) {
            throw new Exception("栈内无数据");
        }
        Node node = tail;
        tail = node.pre;
        return ((E) node.value);
    }


    class Node<E> {
        private E value;
        private Node next = null;
        private Node pre = null;

        public Node(E value) {
            this.value = value;
        }
    }
}

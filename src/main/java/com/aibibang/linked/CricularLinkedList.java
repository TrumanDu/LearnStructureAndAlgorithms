package com.aibibang.linked;

/**
 * @author Truman.P.Du
 * @date 2019/08/16
 * @description 循环链表
 */
public class CricularLinkedList {
    private Node head;
    private Node tail;

    public CricularLinkedList() {
        tail.next = head;
    }

    class Node {
        private Object value;
        private Node next;

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}



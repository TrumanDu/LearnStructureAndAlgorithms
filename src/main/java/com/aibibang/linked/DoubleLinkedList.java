package com.aibibang.linked;

/**
 * @author Truman.P.Du
 * @date 2019/08/16
 * @description
 */
public class DoubleLinkedList<E> {
    private Node head = new Node();

    class Node {
        private Object value;
        private Node pre;
        private Node next;

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

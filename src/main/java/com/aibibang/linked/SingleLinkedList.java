package com.aibibang.linked;

/**
 * @author Truman.P.Du
 * @date 2019/08/16
 * @description 实现单链表
 * 实现单链表反转
 */
public class SingleLinkedList<E> {
    /**
     * 放入哨兵节点，空节点，
     * add不用考虑第一个节点为null情况
     * delete不用对比第一个节点
     */
    private Node head = new Node();

    public void add(E element) {
        Node node = new Node(element);
        node.next = head.next;
        head.next = node;


    }


    public void remove(E value) {
        Node pre = head;
        Node current = head.next;
        while (current != null) {
            if (current.value.equals(value)) {
                pre.next = current.next;
                break;
            }
            pre = current;
            current = current.next;
        }
    }

    /**
     * 单链表反转
     *
     * @return
     */
    public Node revert() {
        Node pre = head;
        Node current = head.next;
        pre.next = null;
        while (current != null) {
            Node tempNode = current.next;
            current.next = pre;
            pre = current;
            current = tempNode;
        }
        return pre;
    }

    /**
     * 实现求链表的中间结点
     * 利用快慢指针法
     *
     * @return
     */
    public E findMiddleValue(Node node) {
        Node quick = node;
        Node slow = node;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;

        }
        return ((E) slow.value);
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList();
        for (int i = 0; i < 13; i++) {
            list.add(i);
        }
        //list.remove(19);

        com.aibibang.linked.SingleLinkedList.Node node = list.head;
        while (node != null) {
            if (node.value != null) {
                System.out.println(node.value);
            }
            node = node.next;
        }
        System.out.println("middle value:" + list.findMiddleValue(list.head.next));
        //单链表反转
        com.aibibang.linked.SingleLinkedList.Node nodes = list.revert();
        System.out.println("反转结果：");
        while (nodes != null) {
            if (nodes.value != null) {
                System.out.println(nodes.value);
            }
            nodes = nodes.next;
        }


    }

    public class Node {
        private Object value;
        private Node next;

        public Node(E element) {
            this.value = element;
            this.next = null;
        }

        public Node() {
            this.value = null;
        }

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

package com.aibibang.linked;

/**
 * @author Truman.P.Du
 * @date 2020/02/21
 * @description 单链表
 */
public class SingleLinked {


    private Node head = null;
    private Node tail = null;

    public void add(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public boolean remove(Node node) {
        if (head == null) {
            return false;
        } else {
            Node current = head;
            Node pre = null;
            while (current != null) {
                if (current.value.equals(node.value)) {
                    if (pre == null) {
                        head = head.next;
                        return true;
                    }
                    pre.next = current.next;
                    return true;
                }
                pre = current;
                current = current.next;
            }
        }

        return false;
    }

    public void printAll() {
        Node node = head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    /**
     * 单链表反转
     *
     * @param node
     * @return
     */
    public Node invert(Node node) {
        Node pre = null;
        Node current = node;

        while (current != null) {
            Node next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    /**
     * 实现两个有序的链表合并为一个有序链表
     * @param n1
     * @param n2
     * @return
     */
    public Node mergeSortedNode(Node n1, Node n2) {
        //处理边界
        if (n1 == null || n2 == null) {
            return n1 == null ? n2 : n1;
        }
        Node node = null;
        if (Integer.parseInt((String) n1.value) < Integer.parseInt((String) n2.value)) {
            node = n1;
            n1 = n1.next;
        } else {
            node = n2;
            n2 = n2.next;
        }
        node.next = mergeSortedNode(n1, n2);
        return node;
    }


    public static void main(String[] args) {
        SingleLinked singleLinked = new SingleLinked();
        singleLinked.add(new Node("1"));
        singleLinked.add(new Node("2"));
        singleLinked.add(new Node("3"));
        singleLinked.add(new Node("4"));


        singleLinked.printAll();
        System.out.println("--------------");
        singleLinked.remove(new Node("1"));
        singleLinked.add(new Node("5"));
        singleLinked.printAll();
        System.out.println("-------invert-------");
        Node node = singleLinked.invert(singleLinked.head);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }

        System.out.println("-------merge-------");
        Node n1 = new Node("1");
        n1.next = new Node("4");
        n1.next.next = new Node("6");
        n1.next.next.next = new Node("8");

        Node n2 = new Node("2");
        n2.next = new Node("3");
        n2.next.next = new Node("5");
        n2.next.next.next = new Node("6");
        n2.next.next.next.next = new Node("7");

        Node reuslt = singleLinked.mergeSortedNode(n1,n2);
        while (reuslt != null) {
            System.out.println(reuslt.value);
            reuslt = reuslt.next;
        }
    }
}

class Node {
    public Object value;
    public Node next;

    public Node(Object value) {
        this.value = value;
    }
}

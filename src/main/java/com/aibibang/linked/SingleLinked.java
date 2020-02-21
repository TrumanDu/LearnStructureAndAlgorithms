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
    }
}

class Node {
    public Object value;
    public Node next;

    public Node(Object value) {
        this.value = value;
    }
}

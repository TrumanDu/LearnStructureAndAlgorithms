package com.aibibang.linked;

import com.aibibang.linked.node.Node;

/**
 * @author Truman.P.Du
 * @date 2020/02/21
 * @description 循环链表
 */
public class CircularLinked {
    private Node head = null;
    private Node tail = null;

    public void add(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
            tail.next = head;
        }
    }

    public Node getNode(){
        return this.head;
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
                        tail.next = head;
                        return true;
                    }
                    if (current == tail) {
                        pre.next = head;
                        tail = pre;
                        tail.next = head;
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
        if (head == tail) {
            System.out.println(head.value);
            return;
        }
        Node node = head;
        while (node != null && node.next != head) {
            System.out.println(node.value);
            node = node.next;
        }
        //输出最后一个元素
        if (node != null && node.next == head) {
            System.out.println(node.value);
        }
    }


    public static void main(String[] args) {
        CircularLinked linked = new CircularLinked();
        linked.add(new Node("1"));
        linked.add(new Node("2"));
        linked.add(new Node("3"));
        linked.add(new Node("4"));


        linked.printAll();
        System.out.println("--------------");
        linked.remove(new Node("4"));
        linked.add(new Node("5"));
        linked.printAll();
    }
}


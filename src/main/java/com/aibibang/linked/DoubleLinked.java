package com.aibibang.linked;

import com.aibibang.linked.node.DoubleNode;

/**
 * @author Truman.P.Du
 * @date 2020/02/21
 * @description 双向链表
 */
public class DoubleLinked {
    private DoubleNode head;
    private DoubleNode tail;

    public void add(DoubleNode node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        DoubleNode temp = tail;
        tail.next = node;
        tail = node;
        tail.pre = temp;
    }

    public boolean remove(DoubleNode node) {
        DoubleNode temp = head;
        while (temp != null) {
            if (temp.value.equals(node.value)) {
                if (temp == head) {
                    head = temp.next;
                    return true;
                }
                if (temp == tail) {
                    tail = temp.pre;
                    tail.next = null;
                    return true;
                }
                temp.pre.next = temp.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void printAll() {
        DoubleNode node = head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DoubleLinked linked = new DoubleLinked();
        linked.add(new DoubleNode("1"));
        linked.add(new DoubleNode("2"));
        linked.add(new DoubleNode("3"));
        linked.add(new DoubleNode("4"));


        linked.printAll();
        System.out.println("--------------");
        linked.remove(new DoubleNode("4"));
        linked.add(new DoubleNode("5"));
        linked.printAll();
    }

}


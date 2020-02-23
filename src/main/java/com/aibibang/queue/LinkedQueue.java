package com.aibibang.queue;

import com.aibibang.linked.node.Node;

/**
 * @author Truman.P.Du
 * @date 2020/02/23
 * @description 用链表实现一个链式队列
 */
public class LinkedQueue<E> {
    private Node tailLinked;
    private Node headLinked;


    public boolean add(E element) {
        Node node = new Node(element);
        if (tailLinked == null) {
            tailLinked = node;
            headLinked = tailLinked;
            return true;
        }
        tailLinked.next = node;
        tailLinked = node;
        return true;
    }

    public E poll() throws Exception {
        if (headLinked == null) {
            throw new Exception("queue is empty.");
        }
        E element = (E) headLinked.value;
        headLinked = headLinked.next;
        if(headLinked==null){
            tailLinked=null;
        }
        return element;
    }

    public static void main(String[] args) throws Exception {

        LinkedQueue linkedQueue = new LinkedQueue();
        for (int i = 0; i < 10; i++) {
            linkedQueue.add(i);
            System.out.println(linkedQueue.poll());
        }

        for (int i = 0; i < 10; i++) {
            linkedQueue.add(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(linkedQueue.poll());
        }

    }
}

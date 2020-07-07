package com.aibibang.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Truman.P.Du
 * @date: 2020/7/2 22:11
 * @description:
 */
class LRUCache {
    private Map<Integer, Node> map;
    private DoubleLinked linked = new DoubleLinked();
    private int size;

    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>(capacity);
        size = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            put(key, node.value);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            Node tempNode = map.get(key);
            linked.removeNode(tempNode);
        } else {
            if (linked.size() == size) {
                //删除最后一个
                int tailKey = linked.tail.key;
                map.remove(tailKey);
                linked.removeTail();
            }
        }


        linked.addHead(node);
        map.put(key, node);
    }

    class Node {
        int key;
        int value;
        public Node next, pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleLinked {
        Node head;
        Node tail;
        int size;

        public void addHead(Node node) {
            size = size + 1;
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            Node next = head;
            head = node;
            head.next = next;
            next.pre = head;
        }


        public void removeNode(Node node) {
            size = size - 1;
            if (head == node) {
                head = head.next;
                if (head != null) {
                    head.pre = null;
                }
                return;
            }
            if (tail == node) {
                tail = tail.pre;
                if (tail != null) {
                    tail.next = null;
                }
                return;
            }
            node.pre.next = node.next;
        }

        public void removeTail() {
            if (tail == null) {
                return;
            }
            tail = tail.pre;
            if (tail != null) {
                tail.next = null;
            }
            size = size - 1;
        }

        public int size() {
            return this.size;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(5, 5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
    }

}

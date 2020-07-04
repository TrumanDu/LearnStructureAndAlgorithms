package com.aibibang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Truman.P.Du
 * @date 2020/07/04
 * @description
 * https://leetcode-cn.com/problems/lru-cache/
 * LRU (最近最少使用) 缓存机制。
 *
 * 解题思路：双端链表+map
 *
 * 注意双端链表的操作，不仅要操作前面的节点还得操作后面的节点
 * 为了避免首尾特殊处理，这里采用两个空节点，head和tail 也就是哨兵模式
 * addHead操作能看到双端链表的特殊
 * removeNode比较典型。
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
                int lastKey = linked.tail.pre.key;
                map.remove(lastKey);
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

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleLinked {
        Node head;
        Node tail;
        int size;

        public DoubleLinked() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        public void addHead(Node node) {
            size = size + 1;
            node.pre = head;
            node.next = head.next;

            head.next.pre = node;
            head.next = node;


        }


        public void removeNode(Node node) {
            size = size - 1;
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void removeTail() {
            Node node = tail.pre;
            removeNode(node);
        }

        public int size() {
            return this.size;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        System.out.println(lruCache.get(2));
        lruCache.put(3, 2);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
    }

}

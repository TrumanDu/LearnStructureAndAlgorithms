package com.aibibang.hash;

/**
 * @author: Truman.P.Du
 * @date: 2020/3/9 12:25
 * @description: 实现一个LRU缓存淘汰算法
 */
public class LRUCache<K, V> {
    private Node<K, V>[] array;
    private int size;
    private int length;
    private Node<K, V> head;
    private Node<K, V> tail;

    public LRUCache(int initialCapatity) {
        size = initialCapatity;
        array = new Node[initialCapatity / 8];
    }

    public void put(K k, V v) {

        int index = index(k);
        Node<K, V> node = new Node<>(k, v);
        if (length + 1 > size) {
            K tk = tail.key;
            if (array[index(tk)].hasNext == null) {
                array[index(tk)] = null;
            } else {
                Node pre = null;
                Node current = array[index(tk)];
                while (current != tail) {
                    pre = node;
                    current = current.hasNext;
                }
                if (pre == null) {
                    array[index(tk)] = current.hasNext;
                } else {
                    pre.hasNext = current.hasNext;
                }
            }
            tail = tail.pre;
            tail.next = null;
        }

        if (head == null) {
            head = node;
            tail = node;
            array[index] = node;
            length++;
        } else {
            node.next = head;
            head.pre = node;
            head = node;

            if (array[index] == null) {
                array[index] = node;
                length++;
            } else {
                Node temp = array[index];
                while (temp.hasNext != null && (!temp.key.equals(k))) {
                    temp = temp.hasNext;
                }
                if (temp.key.equals(k)) {
                    temp.key = k;
                    temp.value = v;
                } else {
                    temp.hasNext = node;
                    length++;
                }

            }
        }
    }

    public V get(K k) {
        int index = index(k);
        Node<K, V> node = array[index];
        if (node == null) {
            return null;
        } else {
            if (node.hasNext == null) {
                if (node.key.equals(k)) {
                    if (head != node) {
                        if (node.next == null) {
                            tail = node.pre;
                        }
                        node.pre.next = node.next;
                        node.next = head;
                        node.pre = null;
                        head = node;


                    }
                    return node.value;
                } else {
                    return null;
                }
            } else {
                while (node != null && (!node.key.equals(k))) {
                    node = node.hasNext;
                }

                if (node != null && node.key.equals(k)) {
                    if (head != node) {
                        if (node.next == null) {
                            tail = node.pre;
                        }
                        node.pre.next = node.next;

                        node.next = head;
                        node.pre = null;
                        Node temp = head;
                        head = node;

                        temp.pre = head;
                    }
                    return node.value;
                }
            }
        }

        return null;
    }

    public void echoAllNode() {
        Node<K, V> node = head;
        while (node != null) {
            System.out.println(node.key + ":" + node.value);
            node = node.next;
        }

    }

    private int index(K k) {
        return k.hashCode() % array.length;
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache(16);
        for (int i = 0; i < 200; i++) {
            lruCache.put(i, i);
        }

        lruCache.echoAllNode();

        for (int i = 0; i < 200; i++) {
            System.out.println(lruCache.get(i));
        }
        lruCache.echoAllNode();
    }


    class Node<K, V> {
        private K key;
        private V value;
        private Node pre;
        private Node next;
        private Node hasNext;

        public Node(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }
}

package com.aibibang.hash;

/**
 * @author: Truman.P.Du
 * @date: 2020/3/5 23:05
 * @description: 实现一个基于链表法解决冲突问题的散列表
 */
public class CustomerHashTable<K, V> {
    private Node<K, V>[] array;
    private int size;
    private double factor = 0.75;

    public CustomerHashTable() {
        array = new Node[16];
    }

    public void put(K k, V v) {
        if (size + 1 > array.length * factor) {
            resize();
        }

        int index = k.hashCode() & (array.length - 1);
        Node newNode = new Node(k, v);
        if (array[index] == null) {
            array[index] = newNode;
        } else {
            Node node = array[index];
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
            newNode.pre = node;
        }
        size++;
    }

    private void resize() {
        Node[] newArray = new Node[array.length << 1];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                continue;
            }
            if (array[i].next == null) {
                if ((array[i].key.hashCode() & array.length) == 0) {
                    newArray[i] = array[i];
                } else {
                    newArray[i + array.length] = array[i];
                }
            } else {
                Node node = array[i];
                while (node != null) {
                    if ((node.key.hashCode() & array.length) == 0) {
                        newArray[i] = node;
                    } else {
                        newArray[i + array.length] = node;
                    }
                    node = node.next;
                }
            }
        }
        array = newArray;
    }

    public V get(K k) {
        int index = k.hashCode() & (array.length - 1);
        if (array[index] == null) {
            return null;
        }

        if (array[index].next == null) {
            return array[index].value;
        } else {
            Node<K, V> node = array[index];
            Node<K, V> tempNode = node;
            while ((!node.key.equals(k)) && node.next != null) {
                tempNode = node.next;
                node = node.next;
            }
            if (tempNode.key.equals(k)) {
                return tempNode.value;
            } else {
                return null;
            }
        }
    }

    public void remove(K k) {
        int index = k.hashCode() & (array.length - 1);
        if (array[index] == null) {
            return;
        }

        if (array[index].next == null) {
            array[index] = null;
        } else {
            Node<K, V> node = array[index];
            Node<K, V> tempNode = node;
            while ((!node.key.equals(k)) && node.next != null) {
                tempNode = node.next;
                node = node.next;
            }
            if (tempNode.key.equals(k)) {
                Node pre = tempNode.pre;
                Node next = tempNode.next;
                if (pre == null) {
                    array[index] = next;
                    return;
                }
                pre.next = next;
                if (next != null) {
                    next.pre = pre;
                }
            }
        }
    }


    public static void main(String[] args) {
        CustomerHashTable<Integer, Integer> customerHashTable = new CustomerHashTable<>();
        for (int i = 0; i < 20000; i++) {
            customerHashTable.put(i, i);
        }
        customerHashTable.remove(2);
        customerHashTable.remove(3);

        for (int i = 0; i < 20000; i++) {
            if (customerHashTable.get(i) == null) {
                System.out.println(i + ":" + customerHashTable.get(i));
                continue;
            }
            if (customerHashTable.get(i) != i) {
                System.out.println(customerHashTable.get(i));
            }
        }
    }

    class Node<K, V> {
        private K key;
        private V value;
        private Node pre;
        private Node next;

        public Node(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
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

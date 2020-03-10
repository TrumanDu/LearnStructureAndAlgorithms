package com.aibibang.tree;

/**
 * @author: Truman.P.Du
 * @date: 2020/3/10 21:27
 * @description: 实现一个二叉查找树，并且支持插入、删除、查找操作
 * <p>
 * 知识点：二叉查找树是左节点比右节点大的树
 * 时间复杂度:两个极端情况的时间复杂度分别是 O(n) 和 O(logn)
 * </p>
 */
public class BinaryFindTree {
    Node root;

    public void insert(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
            return;
        }
        Node p = root;
        while (p != null) {
            if (p.data > data) {
                if (p.left == null) {
                    p.left = node;
                    return;
                }
                p = p.left;
            } else if (p.data == data) { // 不考虑重复情况
                return;
            } else {
                if (p.right == null) {
                    p.right = node;
                    return;
                }
                p = p.right;
            }
        }

        p = node;
    }

    public Node find(int data) {
        Node p = root;
        while (p != null) {
            if (p.data == data) {
                return p;
            } else if (p.data > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    /**
     * 可以使用刪除标记法，实现略
     *
     * @param data
     */
    public void remove(int data) {

    }


    class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}

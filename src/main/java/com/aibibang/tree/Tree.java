package com.aibibang.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Truman.P.Du
 * @date: 2020/3/10 21:54
 * @description: 实现二叉树前、中、后序以及按层遍历
 */
public class Tree {

    public void forward(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        forward(node.left);
        forward(node.right);
    }

    public void middle(Node node) {
        if (node == null) {
            return;
        }
        middle(node.left);
        System.out.println(node.data);
        middle(node.right);
    }

    public void back(Node node) {
        if (node == null) {
            return;
        }
        back(node.left);
        back(node.right);
        System.out.println(node.data);
    }

    /**
     * 借助队列实现按层遍历
     *
     * @param node
     */
    public void level(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.println(n.data);
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
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

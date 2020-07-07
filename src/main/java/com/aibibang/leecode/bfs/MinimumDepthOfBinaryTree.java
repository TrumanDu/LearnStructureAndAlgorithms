package com.aibibang.leecode.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: Truman.P.Du
 * @date: 2020/7/7 22:24
 * @description:
 * 给定一个二叉树，找出其最小深度。
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * 解题思路：bfs解题模板
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        if (root == null) {
            return 0;
        }
        int step = 1;
        queue.add(root);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (isEnd(node)) {
                    return step;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            step++;
        }

        return -1;
    }

    public boolean isEnd(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        } else {
            return false;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

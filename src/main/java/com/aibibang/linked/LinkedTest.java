package com.aibibang.linked;

/**
 * @author Truman.P.Du
 * @date 2019/08/16
 * @description
 */
public class LinkedTest {

    public static class LinkNode {
        int data;
        LinkNode next;

        public LinkNode() {
        }

        public LinkNode(int data) {
            this.data = data;
        }
    }

    /**
     * 实现两个有序的链表合并为一个有序链表
     *
     * @param node1
     * @param node2
     * @return
     */
    public LinkNode merge(LinkNode node1, LinkNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        LinkNode temp = new LinkNode();
        LinkNode head = temp;
        while (node1 != null && node2 != null) {
            if (node1.data > node2.data) {
                head.next = node2;
                node2 = node2.next;
            } else {
                head.next = node1;
                node1 = node1.next;
            }

            head = head.next;
        }

        if (node1 == null) {
            head.next = node2;
        }
        if (node2 == null) {
            head.next = node1;
        }
        return temp.next;
    }

    /**
     * 单链表反转
     *
     * @param node
     * @return
     */
    public LinkNode revert(LinkNode node) {
        LinkNode pre = null;
        LinkNode current = node;
        while (current != null) {
            LinkNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

    /**
     * 链表中环的检测
     * 快慢指针法
     *
     * @param node
     * @return
     */
    public boolean isLoopNode(LinkNode node) {

        if (node == null || node.next == null) {
            return false;
        }
        LinkNode quick = node.next.next;
        LinkNode slow = node.next;
        while (quick != null && quick.next != null && slow != null) {
            if (quick.data == slow.data || quick.next.data == slow.data) {
                return true;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        return false;
    }

    /**
     * 查找中间节点
     *
     * @param node
     * @return
     */
    public LinkNode findMiddleNode(LinkNode node) {
        LinkNode quick = node.next.next;
        LinkNode slow = node.next;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 查找倒数第 n 个结点
     *
     * @param node
     * @param n
     * @return
     */
    public LinkNode findNNode(LinkNode node, int n) {
        LinkNode quick = node;
        for (int i = 0; i < n - 1; i++) {
            quick = quick.next;
        }
        LinkNode slow = node;
        while (quick != null && quick.next != null) {
            quick = quick.next;
            slow = slow.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(1);
        node1.next = new LinkNode(3);

        LinkNode node2 = new LinkNode(2);
        node2.next = new LinkNode(4);
        node2.next.next = new LinkNode(6);
        LinkedTest linkedTest = new LinkedTest();
        LinkNode result = linkedTest.merge(node1, node2);
        LinkNode temp = result;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

        LinkNode revertResult = linkedTest.revert(result);
        LinkNode tempResult = revertResult;
        while (tempResult != null) {
            System.out.println(tempResult.data);
            tempResult = tempResult.next;
        }


        System.out.println(linkedTest.isLoopNode(revertResult));

        LinkNode loopNode = new LinkNode(1);
        loopNode.next = new LinkNode(2);
        loopNode.next.next = loopNode;
        System.out.println(linkedTest.isLoopNode(loopNode));

        System.out.println(linkedTest.findMiddleNode(revertResult).data);

        System.out.println(linkedTest.findNNode(revertResult, 4).data);

    }
}

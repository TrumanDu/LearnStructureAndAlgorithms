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

    //实现两个有序的链表合并为一个有序链表
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

    //单链表反转
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

    // 链表中环的检测
    public boolean isLoopNode(LinkNode node) {
        //TODO
        return false;
    }

    //查找中间节点
    public LinkNode findMiddleNode(LinkNode node) {
        //TODO
        return node;
    }

    //查找倒数第 n 个结点
    public LinkNode findNNode(LinkNode node) {
        //TODO
        return node;
    }

    //删除链表倒数第 n 个结点
    public LinkNode deleteNNode(LinkNode node) {
        //TODO
        return node;
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


    }
}

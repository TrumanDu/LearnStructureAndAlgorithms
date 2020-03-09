package com.aibibang.character;

/**
 * @author: Truman.P.Du
 * @date: 2020/3/9 21:17
 * @description: 实现一个字符集，只包含a～z这26个英文字母的Trie树
 */
public class TrieTree {
    private TrieNode root = new TrieNode('/');

    public void insert(char[] str) {
        TrieNode p = root;
        for (int i = 0; i < str.length; i++) {
            int index = str[i] - 'a';
            if (p.nodes[index] == null) {
                p.nodes[index] = new TrieNode(str[i]);
            }
            p = p.nodes[index];
        }
        p.isEnd = true;
    }

    public boolean find(char[] str) {
        TrieNode p = root;
        for (int i = 0; i < str.length; i++) {
            int index = str[i] - 'a';
            if (p.nodes[index] == null) {
                return false;
            }
            p = p.nodes[index];
        }
        if (p.isEnd) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();

        trieTree.insert("hello".toCharArray());
        trieTree.insert("truman".toCharArray());
        System.out.println(trieTree.find("hello".toCharArray()));
        System.out.println(trieTree.find("test".toCharArray()));
    }

    public class TrieNode {
        private char data;
        private TrieNode[] nodes = new TrieNode[26];
        private boolean isEnd = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}

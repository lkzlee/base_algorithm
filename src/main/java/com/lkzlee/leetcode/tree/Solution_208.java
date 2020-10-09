package com.lkzlee.leetcode.tree;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/10/9 9:48
 * @desc: 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_208 {
    class Trie {
        //多个节点的子树数目或者字符串中的字符种类
        private final int SIZE = 26;
        //字典数的根
        private TrieNode root = new TrieNode();

        private class TrieNode {
            //所有儿子节点或一级节点
            private TrieNode[] child;
            //是否结束的节点,即叶子节点
            private boolean isLeaf;

            public TrieNode() {
                this.isLeaf = false;
                this.child = new TrieNode[SIZE];
            }
        }

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            insert(word, root);
        }

        private void insert(String word, TrieNode node) {
            int idx = word.charAt(0) - 'a';
            if (node.child[idx] == null) {
                node.child[idx] = new TrieNode();
            }
            if (word.length() == 1) node.child[idx].isLeaf = true;
            else insert(word.substring(1), node.child[idx]);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return search(word, root);
        }

        private boolean search(String word, TrieNode node) {
            if (node == null) return false;
            int idx = word.charAt(0) - 'a';
            if (node.child[idx] == null) return false;
            if (word.length() == 1) return node.child[idx].isLeaf;
            return search(word.substring(1), node.child[idx]);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return startsWith(prefix, root);
        }

        private boolean startsWith(String prefix, TrieNode node) {
            if (node == null) return false;
            if (prefix.length() == 0) return true;
            int idx = prefix.charAt(0) - 'a';
            if (node.child[idx] == null) return false;
            return startsWith(prefix.substring(1), node.child[idx]);
        }
    }
}

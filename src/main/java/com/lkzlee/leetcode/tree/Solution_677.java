package com.lkzlee.leetcode.tree;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/10/9 10:38
 * @desc: 实现一个 MapSum 类里的两个方法，insert 和 sum。
 * <p>
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 * <p>
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-sum-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_677 {
    class MapSum {
        private final int SIZE = 26;

        private class TrieNode {
            private TrieNode[] child = new TrieNode[SIZE];
            private boolean isWord = false;
            private int value;
        }

        private TrieNode root = new TrieNode();

        /**
         * Initialize your data structure here.
         */
        public MapSum() {

        }

        public void insert(String key, int val) {
            insert(key, val, root);
        }

        private void insert(String key, int val, TrieNode node) {
            int idx = key.charAt(0) - 'a';
            if (node.child[idx] == null) {
                node.child[idx] = new TrieNode();
            }
            if (key.length() == 1) {
                node.child[idx].value = val;
                node.child[idx].isWord = true;
                return;
            }
            insert(key.substring(1), val, node.child[idx]);
        }

        public int sum(String prefix) {
            return sum(prefix, root);
        }

        private int sum(String prefix, TrieNode node) {
            if (prefix.length() == 0) return 0;
            int idx = prefix.charAt(0) - 'a';
            if (node.child[idx] == null) return 0;
            if (prefix.length() == 1) {
                //计算所有已该前缀开头的所有字符串总和
                return dfs(node.child[idx]);
            }
            return sum(prefix.substring(1), node.child[idx]);

        }

        private int dfs(TrieNode trieNode) {
            if (trieNode == null) return 0;
            int sum = 0;
            if (trieNode.isWord) {
                sum += trieNode.value;
            }
            for (TrieNode node : trieNode.child) {
                sum += dfs(node);
            }
            return sum;
        }
    }
}

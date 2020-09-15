package com.lkzlee.leetcode.tree;

import com.lkzlee.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/9/15 14:11
 * @desc:给定一个二叉树，在树的最后一行找到最左边的值。 示例 1:
 * <p>
 * 输入:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出:
 * 1
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * 输出:
 * 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_513 {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ret = root.val;
        while (!queue.isEmpty()) {
            int len = queue.size();
            int n = len;
            while (len > 0) {
                TreeNode node = queue.poll();
                if (n == len)
                    ret = node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                len--;
            }
        }
        return ret;
    }
}

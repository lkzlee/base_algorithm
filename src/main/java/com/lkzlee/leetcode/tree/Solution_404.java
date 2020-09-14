package com.lkzlee.leetcode.tree;

import com.lkzlee.leetcode.datastructure.TreeNode;

/***
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_404 {
    public int doSumLeftLeaves(TreeNode root, int sum, boolean isLeft) {
        if (root == null) return sum;
        if (root.left == null && root.right == null) { //首先判断叶子节点
            if (isLeft) {
                return sum + root.val;
            } else {
                return sum;
            }
        }
        int s1 = doSumLeftLeaves(root.left, sum, true);
        int s2 = doSumLeftLeaves(root.right, sum, false);
        return s1 + s2;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return doSumLeftLeaves(root, 0, false);
    }
}

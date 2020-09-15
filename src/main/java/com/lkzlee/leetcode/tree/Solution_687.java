package com.lkzlee.leetcode.tree;

import com.lkzlee.leetcode.datastructure.TreeNode;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/9/15 9:07
 * @desc:给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * 输出:
 * <p>
 * 2
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * 输出:
 * <p>
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_687 {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = startWithRootDepthPath(root.left, root.val);
        int rightDepth = startWithRootDepthPath(root.right, root.val);
        int max = Math.max(leftDepth + rightDepth, longestUnivaluePath(root.left));
        return Math.max(max, longestUnivaluePath(root.right));
    }

    private int startWithRootDepthPath(TreeNode root, int val) {
        if (root == null || root.val != val) return 0;
        int leftDepth = startWithRootDepthPath(root.left, val);
        int rightDepth = startWithRootDepthPath(root.right, val);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

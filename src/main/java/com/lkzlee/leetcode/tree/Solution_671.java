package com.lkzlee.leetcode.tree;

import com.lkzlee.leetcode.datastructure.TreeNode;

/***
 * @author:lkzlee
 * @date: 2018/2/26 19:52
 * @Desc: 二叉树找出第二小值的数,
 * 有几个重要条件需要注意：
 * 	1. 父节点的值一定不大于子节点
 * 	2. 节点不存在子节点或者存在两个子节点
 * 	3. 两个子节点之间没有大小关系
 * 思路：
 * 	 依据此重要条件可以如下思路分治法：
 * 	 求出左子树与右子树的值，由于左右子节点值肯定不小于父节点的值，所以左右最小的即为第二小的值（然后切记对于临界条件及值处理即可）
 *
 */
public class Solution_671 {
    /**
     * 一个节点要么具有 0 个或 2 个子节点，如果有子节点，那么根节点是最小的节点。
     */
    public int findSecondMinimumValue(TreeNode root) {
        //return solveOld(root);
        if (root == null) return -1;
        int min = findMinTreeValue(root, root.val);
        return min == root.val ? -1 : min;
    }

    private int findMinTreeValue(TreeNode root, int min) {
        if (root == null) return min;
        if (root.val != min) {
            return root.val;
        }
        int lmin = findMinTreeValue(root.left, min);
        int rmin = findMinTreeValue(root.right, min);
        if (lmin == min || rmin == min) {
            return Math.max(lmin, rmin);
        }
        return Math.min(lmin, rmin);
    }

    private int solveOld(TreeNode root) {
        int min = root.val;
        int second = search(root, min);
        return (min == second || second == Integer.MAX_VALUE) ? -1 : second;
    }

    public int search(TreeNode t, int min) {
        if (t == null) {
            return -1;
        }
        if (min != t.val) {
            return t.val;
        }
        int t1 = search(t.left, min);
        int t2 = search(t.right, min);
        return (t1 == -1 || t2 == -1) ? Math.max(t1, t2) : Math.min(t1, t2);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(7);
        t.right = new TreeNode(5);
        int sec = new Solution_671().findSecondMinimumValue(t);
        System.out.println(sec);
    }
}

package com.lkzlee.leetcode.tree;

import com.lkzlee.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/9/15 16:12
 * @desc:给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 *  
 * <p>
 * 例如：
 * <p>
 * 输入: 原始二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        //最笨的办法，没有用到二叉搜索树条件
//        List<Integer> rsList = new ArrayList<>();
//        inOrderTree(root, rsList);
//        return preOrderTreeSum(root, rsList);
        //受到二叉搜索树启发，应该只计算右子树即可
        calcSumTree(root);
        return root;
    }

    private void calcSumTree(TreeNode root) {
        if (root == null) return;
        if (root.right != null) {
            calcSumTree(root.right);
        }
        sum += root.val;
        root.val = sum;
        if (root.left != null) {
            calcSumTree(root.left);
        }
    }

    private TreeNode preOrderTreeSum(TreeNode root, List<Integer> rsList) {
        if (root == null) return null;
        int sum = 0;
        for (int i = 0; i < rsList.size(); i++) {
            if (rsList.get(i) < root.val) continue;
            sum += rsList.get(i);
        }
        root.val = sum;
        preOrderTreeSum(root.left, rsList);
        preOrderTreeSum(root.right, rsList);
        return root;
    }

    private void inOrderTree(TreeNode root, List<Integer> rsList) {
        if (root == null) return;
        inOrderTree(root.left, rsList);
        rsList.add(root.val);
        inOrderTree(root.right, rsList);
    }
}

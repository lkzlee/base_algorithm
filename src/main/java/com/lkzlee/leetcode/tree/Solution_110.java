package com.lkzlee.leetcode.tree;

import com.lkzlee.leetcode.datastructure.TreeNode;

/***
 * @author:lkzlee
 * @date: 2018/3/10 18:23
 * @Desc:给定一个二叉树，确定它是高度平衡的。
 * 对于这个问题，一棵高度平衡二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过 1。
 * 思路：求出左右两个子树的深度，相差超过1 则直接返回不平衡，否则遍历完整个二叉树也找不到则返回true
 */
public class Solution_110
{
	public boolean isBalanced(TreeNode root)
	{
		if (root == null)
			return true;
		int ldepth = calcDepthTree(root.left, 1);
		int rdepth = calcDepthTree(root.right, 1);
		if (Math.abs(rdepth - ldepth) > 1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}

	private int calcDepthTree(TreeNode node, int depth)
	{
		if (node == null)
			return depth;
		return Math.max(calcDepthTree(node.left, depth + 1), calcDepthTree(node.right, depth + 1));

	}
}

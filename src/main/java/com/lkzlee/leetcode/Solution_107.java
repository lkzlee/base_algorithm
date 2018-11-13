package com.lkzlee.leetcode;

import com.lkzlee.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * @author:lkzlee
 * @date: 2018/11/13 17:48
 * @Desc:
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class Solution_107
{
	public List<List<Integer>> levelOrderBottom(TreeNode root)
	{
		List<List<Integer>> rsList = new ArrayList<>();
		if (root == null)
			return rsList;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty())
		{
			int nsize = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < nsize; i++)
			{
				TreeNode t = queue.poll();
				list.add(t.val);
				if (t.left != null)
					queue.add(t.left);
				if (t.right != null)
					queue.add(t.right);
			}
			rsList.add(0, list);
		}
		return rsList;
	}

	public static void main(String[] args)
	{
		// 构建二叉树
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		List<List<Integer>> rs = new Solution_107().levelOrderBottom(root);
		System.out.println(rs);
	}
}

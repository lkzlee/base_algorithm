package com.lkzlee.leetcode;

import com.lkzlee.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * @author:lkzlee
 * @date: 2018/11/13 17:36
 * @Desc:
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class Solution_199
{
	public List<Integer> rightSideView(TreeNode root)
	{
		List<Integer> rsList = new ArrayList<>();
		if (root == null)
			return rsList;
		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);
		while (!queue.isEmpty())
		{
			int size = queue.size();
			for (int i = 0; i < size; i++)
			{
				TreeNode t = queue.poll();
				if (t.right != null)
				{
					queue.add(t.right);
				}
				if (t.left != null)
				{
					queue.add(t.left);
				}
				if (i == size - 1)
				{
					rsList.add(t.val);
				}
			}
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
		List<Integer>rs=new Solution_199().rightSideView(root);
		System.out.println(rs);
	}
}

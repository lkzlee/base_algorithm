package com.lkzlee.algorithm;

import com.lkzlee.leetcode.datastructure.TreeNode;

import java.util.*;

/***
 * @author:lkzlee
 * @date: 2018/11/13 17:16
 * @Desc:
 */
public class TreeSearch
{
	public List<TreeNode> leftLook(TreeNode root)
	{
		List<TreeNode> list = new ArrayList<>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<>();
		Map<Integer, TreeNode> bitMap = new HashMap<>();
		stack.push(root);
		root.level = 0;
		bitMap.put(0, root);
		while (!stack.isEmpty())
		{
			TreeNode t = stack.pop();

			if (!bitMap.containsKey(t.level))
			{
				bitMap.put(t.level, t);
			}
			if (t.right != null)
			{
				t.right.level = t.level + 1;
				stack.push(t.right);
			}
			if (t.left != null)
			{
				t.left.level = t.level + 1;
				stack.push(t.left);
			}
		}

		for (TreeNode n : bitMap.values())
		{
			list.add(n);
		}
		return list;
	}

	public List<TreeNode> topLook(TreeNode root)
	{
		List<TreeNode> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> queue = new LinkedList<>();
		Map<Integer, TreeNode> bitMap = new HashMap<>();
		queue.add(root);
		root.level = 0;
		bitMap.put(0, root);
		while (!queue.isEmpty())
		{
			TreeNode t = queue.poll();
			if (!bitMap.containsKey(t.level))
			{
				bitMap.put(t.level, t);
			}
			if (t.left != null)
			{
				t.left.level = t.level - 1;
				queue.add(t.left);
			}
			if (t.right != null)
			{
				t.right.level = t.level + 1;
				queue.add(t.right);
			}

		}

		for (TreeNode n : bitMap.values())
		{
			list.add(n);
		}
		return list;
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

		List<TreeNode> list = new TreeSearch().leftLook(root);
		for (TreeNode t : list)
			System.out.println(t.val);
		System.out.println("----");
		List<TreeNode> list2 = new TreeSearch().topLook(root);
		for (TreeNode t : list2)
			System.out.println(t.val);
	}

}

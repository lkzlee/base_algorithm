package com.lkzlee.leetcode.datastructure;

/***
 * @author:lkzlee
 * @date: 2018/2/26 19:57
 * @Desc: leetcode二叉树结构
 */
public class TreeNode
{

	public int val;
	public TreeNode left;
	public TreeNode right;
	public int level;

	public TreeNode(int x)
	{
		val = x;
	}

	@Override
	public String toString()
	{
		return "TreeNode{" +
				"val=" + val +
				", left=" + left +
				", right=" + right +
				", level=" + level +
				'}';
	}
}

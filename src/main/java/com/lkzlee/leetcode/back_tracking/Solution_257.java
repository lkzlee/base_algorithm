package com.lkzlee.leetcode.back_tracking;

import com.lkzlee.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/10/12 15:13
 * @Desc:
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class Solution_257
{
	public List<String> binaryTreePaths(TreeNode root)
	{
		List<String> list = new ArrayList<>();
		if (root == null)
			return list;
		backTrackPath(root, new StringBuilder(), list);
		//		List<Integer> nodeList = new ArrayList<>();
		//		backTrackNewPath(root, nodeList, list);
		return list;
	}

	private void backTrackNewPath(TreeNode root, List<Integer> nodeList, List<String> list)
	{
		if (root == null)
			return;
		nodeList.add(root.val);
		if (root.left == null && root.right == null)
		{
			list.add(buildTreePath(nodeList));
		}
		else
		{
			backTrackNewPath(root.left, nodeList, list);
			backTrackNewPath(root.right, nodeList, list);
		}
		nodeList.remove(nodeList.size() - 1);
	}

	private String buildTreePath(List<Integer> nodeList)
	{
		if (nodeList == null || nodeList.size() <= 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nodeList.size(); i++)
		{
			sb.append(nodeList.get(i));
			if (i < nodeList.size() - 1)
				sb.append("->");
		}
		return sb.toString();
	}

	private void backTrackPath(TreeNode root, StringBuilder tempPath, List<String> list)
	{
		if (root == null)
			return;
		String part = root.val + "";
		if (tempPath.length() != 0)
		{
			part = "->" + part;
		}
		tempPath.append(part);
		if (root.left == null && root.right == null)
		{
			list.add(tempPath.toString());
		}
		else
		{
			backTrackPath(root.left, tempPath, list);
			backTrackPath(root.right, tempPath, list);
		}
		tempPath.delete(tempPath.length() - part.length(), tempPath.length());
		return;
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		List<String> rs = new Solution_257().binaryTreePaths(root);
		System.out.println(rs);
	}
}

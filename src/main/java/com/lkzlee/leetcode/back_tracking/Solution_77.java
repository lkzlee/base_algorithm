package com.lkzlee.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/10/15 10:57
 * @Desc:
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Solution_77
{
	public List<List<Integer>> combine(int n, int k)
	{
		List<List<Integer>> list = new ArrayList<>();
		if (n == 0 || k == 0)
			return list;
		List<Integer> tempList = new ArrayList<>();
		doCombine(n, 1, k, tempList, list);
		return list;
	}

	private void doCombine(int n, int start, int k, List<Integer> tempList, List<List<Integer>> list)
	{
		if (tempList.size() == k)
		{
			List<Integer> rsList = new ArrayList<>();
			rsList.addAll(tempList);
			list.add(rsList);
			return;
		}
		for (int i = start; i <= n; i++)
		{
			tempList.add(i);
			doCombine(n, i+1, k, tempList, list);
			tempList.remove(tempList.size() - 1);

		}
	}

	public static void main(String[] args)
	{
		List<List<Integer>> rs = new Solution_77().combine(4, 2);
		System.out.println(rs);
	}
}

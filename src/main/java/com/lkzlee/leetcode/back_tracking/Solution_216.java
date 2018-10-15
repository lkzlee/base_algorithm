package com.lkzlee.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/10/15 14:28
 * @Desc:
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Solution_216
{
	public List<List<Integer>> combinationSum3(int k, int n)
	{
		List<List<Integer>> list = new ArrayList<>();
		if (k <= 0 || n <= 0)
			return list;
		List<Integer> tempList = new ArrayList<>();
		doCombination(n - 1, n, 1, k, list, tempList);
		return list;
	}

	private void doCombination(int n, int target, int start, int k, List<List<Integer>> list, List<Integer> tempList)
	{

		if (k == 0)
		{
			if (target == 0)
			{
				List<Integer> rsList = new ArrayList<>();
				rsList.addAll(tempList);
				list.add(rsList);
			}
			return;
		}
//		for (int i = start; i <= n; i++)
		for (int i = start; i <= 9; i++)
		{
			tempList.add(i);
			doCombination(n, target - i, i + 1, k - 1, list, tempList);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args)
	{
		List<List<Integer>> rs = new Solution_216().combinationSum3(2, 18);
		System.out.println(rs);
	}
}

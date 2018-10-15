package com.lkzlee.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/10/15 11:28
 * @Desc:
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class Solution_40
{
	public List<List<Integer>> combinationSum2(int[] candidates, int target)
	{
		List<List<Integer>> list = new ArrayList<>();
		if (candidates == null || candidates.length <= 0)
			return list;
		Arrays.sort(candidates);
		List<Integer> tempList = new ArrayList<>();
		boolean[] mark = new boolean[candidates.length];
		doCombination(candidates, 0, target, tempList, list, mark);
		return list;
	}

	private void doCombination(int[] candidates, int start, int target, List<Integer> tempList,
			List<List<Integer>> list, boolean[] mark)
	{
		if (target < 0)
			return;
		if (target == 0)
		{
			List<Integer> rsList = new ArrayList<>();
			rsList.addAll(tempList);
			list.add(rsList);
			return;
		}
		for (int i = start; i < candidates.length; i++)
		{
			if (candidates[i] > target)
				continue;
			if (i > 0 && candidates[i] == candidates[i - 1] && !mark[i - 1])
				continue;
			tempList.add(candidates[i]);
			mark[i]=true;
			doCombination(candidates, i + 1, target - candidates[i], tempList, list, mark);
			tempList.remove(tempList.size() - 1);
			mark[i]=false;
		}
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> rs = new Solution_40().combinationSum2(nums, target);
		System.out.println(rs);
	}
}

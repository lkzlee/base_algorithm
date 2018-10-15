package com.lkzlee.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/10/15 11:17
 * @Desc:
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Solution_39
{
	public List<List<Integer>> combinationSum(int[] candidates, int target)
	{
		List<List<Integer>> list = new ArrayList<>();
		if (candidates == null || candidates.length <= 0)
			return list;
		List<Integer> tempList = new ArrayList<>();
		doCombinationSum(candidates, 0,target, tempList, list);
		return list;

	}

	private void doCombinationSum(int[] candidates,int start, int target, List<Integer> tempList, List<List<Integer>> list)
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

			tempList.add(candidates[i]);
			doCombinationSum(candidates, i,target - candidates[i], tempList, list);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args)
	{
		int[] nums=new int[]{2,3,6,7};
		int target=7;
		List<List<Integer>> rs=new Solution_39().combinationSum(nums,target);
		System.out.println(rs);
	}
}

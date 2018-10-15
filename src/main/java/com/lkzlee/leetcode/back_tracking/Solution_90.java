package com.lkzlee.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/10/15 14:51
 * @Desc:
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Solution_90
{
	public List<List<Integer>> subsetsWithDup(int[] nums)
	{
		List<List<Integer>> list = new ArrayList<>();
		if (nums == null || nums.length <= 0)
		{
			list.add(new ArrayList<>());
			return list;
		}
		Arrays.sort(nums);

		boolean[] mark = new boolean[nums.length];
		for (int k = 0; k <= nums.length; k++)
		{
			List<Integer> tempList = new ArrayList<>();
			doSub2(nums, k, 0, tempList, list, mark);

		}
		return list;
	}

	private void doSub2(int[] nums, int k, int start, List<Integer> tempList, List<List<Integer>> list, boolean[] mark)
	{
		if (k == 0)
		{
			List<Integer> rsList = new ArrayList<>();
			rsList.addAll(tempList);
			list.add(rsList);
			return;
		}
		for (int i = start; i < nums.length; i++)
		{
			if (i > 0 && nums[i] == nums[i - 1] && !mark[i - 1])
				continue;
			if (mark[i])
				continue;
			tempList.add(nums[i]);
			mark[i] = true;
			doSub2(nums, k - 1, i + 1, tempList, list, mark);
			mark[i] = false;
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 1, 2, 2 };
		List<List<Integer>> rs = new Solution_90().subsetsWithDup(nums);
		System.out.println(rs);
	}
}

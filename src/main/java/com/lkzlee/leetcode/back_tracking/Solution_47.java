package com.lkzlee.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/10/12 16:29
 * @Desc:
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class Solution_47
{

	public List<List<Integer>> permuteUnique(int[] nums)
	{
		List<List<Integer>> list = new ArrayList<>();
		if (nums == null || nums.length <= 0)
			return list;
		/***
		 * 先进行排序
		 */
		Arrays.sort(nums);
		List<Integer> tmpList = new ArrayList<>();
		boolean[] mark = new boolean[nums.length];
		doPermuteByBackTracking(nums, tmpList, list, mark);
		return list;
	}

	private void doPermuteByBackTracking(int[] nums, List<Integer> tmpList, List<List<Integer>> list, boolean[] mark)
	{
		if (tmpList.size() == nums.length)
		{
			List<Integer> rsList = new ArrayList<>();
			rsList.addAll(tmpList);
			list.add(rsList);
			return;
		}
		for (int i = 0; i < nums.length; i++)
		{
			if (mark[i])
				continue;
			if (i > 0 && nums[i] == nums[i - 1] && !mark[i - 1])
				continue;
			tmpList.add(nums[i]);
			mark[i] = true;
			doPermuteByBackTracking(nums, tmpList, list, mark);
			tmpList.remove(tmpList.size() - 1);
			mark[i] = false;
		}
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 1, 1, 1, 2 };
		List<List<Integer>> rs = new Solution_47().permuteUnique(nums);
		System.out.println(rs);
	}
}

package com.lkzlee.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/10/15 14:39
 * @Desc:
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Solution_78
{
	public List<List<Integer>> subsets(int[] nums)
	{
		List<List<Integer>> list = new ArrayList<>();

		if (nums == null || nums.length <= 0)
			return list;
		/***
		 * 	求一遍所有元素的Cn-k
		 */

		for (int k = 0; k <= nums.length; k++)
		{
			List<Integer> tempList = new ArrayList<>();
			doSub(nums, k, 0, tempList, list);
		}
		return list;
	}

	private void doSub(int[] nums, int k, int start, List<Integer> tempList, List<List<Integer>> list)
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
			tempList.add(nums[i]);
			doSub(nums, k - 1, i + 1, tempList, list);
			tempList.remove(tempList.size() - 1);
		}

	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> rs = new Solution_78().subsets(nums);
		System.out.println(rs);
	}
}

package com.lkzlee.leetcode;

import java.util.Arrays;

/***
 * @author:lkzlee
 * @date: 2018/5/8 10:30
 * @Desc:给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution_1
{
	public int[] twoSum(int[] nums, int target)
	{
		int[] rs = new int[2];
		for (int i = 0; i < nums.length - 1; i++)
		{
			for (int j = i + 1; j < nums.length; j++)
			{
				if (nums[i] + nums[j] == target)
				{
					rs[0] = i;
					rs[1] = j;
					return rs;
				}
			}
		}
		return null;
	}

	public static void main(String[] args)
	{
		int[] arr = { 1, 2, 3, 4 };
		int[] rs = new Solution_1().twoSum(arr, 5);
		System.out.println(Arrays.toString(rs));
	}
}

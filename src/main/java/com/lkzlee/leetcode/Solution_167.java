package com.lkzlee.leetcode;

import java.util.Arrays;

/***
 * @author:lkzlee
 * @date: 2018/9/26 17:59
 * @Desc:
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class Solution_167
{
	public int[] twoSum(int[] numbers, int target)
	{
		if (numbers == null || numbers.length <= 0)
			return null;

		for (int i = 0, j = numbers.length - 1; i < j; )
		{
			int sum = numbers[i] + numbers[j];
			if (sum == target)
				return new int[] { i + 1, j + 1 };
			else if (sum < target)
				i++;
			else
				j--;
		}
		return null;
	}

	public static void main(String[] args)
	{
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int[] rs = new Solution_167().twoSum(nums, 4);
		System.out.println(Arrays.toString(rs));
	}
}

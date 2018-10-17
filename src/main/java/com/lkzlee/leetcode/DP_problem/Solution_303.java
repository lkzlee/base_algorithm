package com.lkzlee.leetcode.DP_problem;

import java.util.Arrays;

/***
 * @author:lkzlee
 * @date: 2018/10/17 10:49
 * @Desc:
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 */
public class Solution_303
{
	static class NumArray
	{

		private int[] sum;

		public NumArray(int[] nums)
		{
			sum = new int[nums.length + 1];
			Arrays.fill(sum, 0);
			for (int i = 1; i <= nums.length; i++)
			{
				sum[i] = sum[i - 1] + nums[i - 1];
			}
		}

		public int sumRange(int i, int j)
		{
			return sum[j+1] - sum[i];
		}
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { -2, 0, 3, -5, 2, -1 };
		NumArray obj = new NumArray(nums);
		int i = 0, j = 2;
		int rs = obj.sumRange(i, j);
		System.out.println(rs);
	}

}

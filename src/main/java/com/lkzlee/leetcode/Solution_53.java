package com.lkzlee.leetcode;

/***
 * @author:lkzlee
 * @date: 2018/10/9 11:23
 * @Desc:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class Solution_53
{
	public int maxSubArray(int[] nums)
	{
		if (nums == null || nums.length <= 0)
			return 0;
		/***
		 * 该题感觉应该用动态规划，定义一个数组p[i] 表示从0...i间最大和的连续子数组和
		 * 最后发现自己想多了
		 */
		int preSum = nums[0];
		int maxSum = preSum;
		for (int i = 1; i < nums.length; i++)
		{
			if (preSum > 0)
				preSum = preSum + nums[i];
			else
				preSum = nums[i];
			if (preSum > maxSum)
				maxSum = preSum;
		}
		return maxSum;
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int rs = new Solution_53().maxSubArray(nums);
		System.out.println(rs);
	}
}

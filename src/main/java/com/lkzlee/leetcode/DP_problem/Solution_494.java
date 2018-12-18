package com.lkzlee.leetcode.DP_problem;

/***
 * @author:lkzlee
 * @date: 2018/12/17 17:40
 * @Desc:
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -
 * 。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 *
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 * 注意:
 *
 * 数组的长度不会超过20，并且数组中的值全为正数。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果为32位整数。*
 */
public class Solution_494
{
	public int findTargetSumWays(int[] nums, int S)
	{
		if (nums == null || nums.length <= 0)
			return 0;
		//		return findTargetNum(nums, 0, 0, S);

		/**
		 * 还有一种动态规划的解法
		 * 该问题可以转换为 Subset Sum 问题，从而使用 0-1 背包的方法来求解。
		 * 可以将这组数看成两部分，P 和 N，其中 P 使用正号，N 使用负号，有以下推导：
		 * sum(P) - sum(N) = target
		 * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
		 * 2 * sum(P) = target + sum(nums)
		 * 因此只要找到一个子集，令它们都取正号，并且和等于 (target + sum(nums))/2，就证明存在解。
		 * 太他妈强了
		 */
		int sum = calcSum(nums);
		if (S > sum || ((sum + S) & 0x01) != 0)
			return 0;
		int target = (S + sum) / 2;
		int[] dp = new int[target + 1];
		dp[0] = 1;
		/***
		 * 子集合的subset sum问题，dp[i] 表示可以从数组num[]找到一个子集和等于i的个数使得等于target，
		 * 通过推导，dp[i]=dp[i]+dp[i-num[x]]
		 */
		for (int num : nums)
		{
			for (int j = target; j >= num; j--)
			{
				dp[j] = dp[j] + dp[j - num];
			}
		}
		return dp[target];
	}

	private int calcSum(int[] nums)
	{
		int sum = 0;
		for (int t : nums)
			sum += t;
		return sum;
	}

	private int findTargetNum(int[] nums, int i, int s, int target)
	{
		if (i >= nums.length)
		{
			if (s == target)
				return 1;
			else
				return 0;
		}
		return findTargetNum(nums, i + 1, s + nums[i], target) + findTargetNum(nums, i + 1, s - nums[i], target);
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 1, 2, 7, 9, 981 };
		int rs = new Solution_494().findTargetSumWays(nums, 1000000000);
		System.out.println(rs);
	}
}

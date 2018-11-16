package com.lkzlee.leetcode.DP_problem;

/***
 * @author:lkzlee
 * @date: 2018/10/25 17:36
 * @Desc:给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class Solution_300
{
	public int lengthOfLIS(int[] nums)
	{
		/***
		 * 我的算法是通过dp[i] 表示以nums[i]结尾的最大子序列长度
		 */
		if (nums == null || nums.length <= 0)
			return 0;
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++)
		{
			int maxLen = 1;
			for (int j = 0; j < i; j++)
			{
				if (nums[j] < nums[i])
					maxLen = Math.max(maxLen, dp[j] + 1);
			}
			dp[i] = maxLen;
		}
		int maxLen = 0;
		for (int i = 0; i < dp.length; i++)
		{
			maxLen = Math.max(maxLen, dp[i]);
		}
		return maxLen;
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
		int rs = new Solution_300().lengthOfLIS(nums);
		System.out.println(rs);
	}
}

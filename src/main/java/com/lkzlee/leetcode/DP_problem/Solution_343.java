package com.lkzlee.leetcode.DP_problem;

/***
 * @author:lkzlee
 * @date: 2018/10/22 17:53
 * @Desc:
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class Solution_343
{
	public int integerBreak(int n)
	{
		if (n <= 1)
			return 0;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++)
		{
			for (int j = 1; j < i; j++)
			{
				dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, j * (i - j)));
			}
		}
		return dp[n];
	}

	public static void main(String[] args)
	{
		int rs = new Solution_343().integerBreak(10);
		System.out.println(rs);
	}
}

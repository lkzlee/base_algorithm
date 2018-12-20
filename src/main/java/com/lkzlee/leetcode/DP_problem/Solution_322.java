package com.lkzlee.leetcode.DP_problem;

import java.util.Arrays;

/***
 * @author:lkzlee
 * @date: 2018/12/20 10:52
 * @Desc:
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class Solution_322
{
	public int coinChange(int[] coins, int amount)
	{
		if (coins == null || coins.length <= 0)
			return -1;
		if (amount == 0)
			return 0;
		//		return backPackAll(coins, amount);
		/**
		 * 完全背包优化版,先掌握完全背包基本写法，再来写完全背包优化版，才有意义。
		 */
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int c : coins)
		{
			for (int j = c; j <= amount; j++)
			{
				dp[j] = Math.min(dp[j], dp[j - c] + 1);
			}
		}
		if (dp[amount] == amount + 1)
			return -1;
		return dp[amount];
	}

	private int backPackAll(int[] coins, int amount)
	{
		/***
		 * 定义一个数组dp[i][j]表示选取前i个元素，可以凑成总金额j的最小硬币个数
		 */
		int[][] dp = new int[coins.length + 1][amount + 1];
		/**
		 * 需要注意初始化为amount+1；
		 *
		 */
		for (int i = 0; i < dp.length; i++)
		{
			for (int j = 0; j < dp[i].length; j++)
			{
				if (j == 0)
					dp[i][j] = 0;
				else
					dp[i][j] = amount + 1;
			}
		}
		for (int i = 1; i <= coins.length; i++)
		{
			int w = coins[i - 1];
			for (int j = 1; j <= amount; j++)
			{
				if (j < w)
				{
					dp[i][j] = dp[i - 1][j];
					continue;
				}
				for (int k = 1; k * w <= j; k++)
				{
					dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j], dp[i - 1][j - k * w] + k));
				}
			}
		}
		if (dp[coins.length][amount] == amount + 1)
			return -1;
		return dp[coins.length][amount];
	}

	public static void main(String[] args)
	{
		int[] coins = new int[] { 186, 419, 83, 408 };
		int amount = 6249;
		int rs = new Solution_322().coinChange(coins, amount);
		System.out.println(rs);
	}
}

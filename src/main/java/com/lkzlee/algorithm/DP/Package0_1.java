package com.lkzlee.algorithm.DP;

/***
 * @author:lkzlee
 * @date: 2018/12/17 14:50
 * @Desc:
 * 有一个容量为N个物品的背包，要用这个背包装下物品的价值最大，这些物品有两个属性：重量 w 和价值 v
 */
public class Package0_1
{
	public int knapsack(int W, int N, int[] weights, int[] values)
	{
		if (W <= 0 || N <= 0 || weights == null || weights.length <= 0 || values == null || values.length <= 0)
			return 0;
		/***
		 * dp问题的转移方程：dp[i][j]表示前 i 件物品重量不超过 j 的情况下能达到的最大价值，
		 * dp[i][j]=dp[i-1][j-w]+v
		 * dp[i][j]=dp[i-1][j]
		 */
		int[][] dp = new int[N + 1][W + 1];
		for (int i = 1; i <= weights.length; i++)
		{

			int w = weights[i - 1];
			int v = values[i - 1];
			for (int j = 1; j <= w; j++)
			{
				if (j >= w)
				{
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
				}
				else
				{
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[N][W];
	}

	/***
	 * 观察状态转移方程可以知道，前 i 件物品的状态仅与前 i-1 件物品的状态有关
	 */
	public int knapsackVOpt(int W, int N, int[] weights, int[] values)
	{
		if (W <= 0 || N <= 0 || weights == null || weights.length <= 0 || values == null || values.length <= 0)
			return 0;
		/***
		 * dp问题的转移方程：dp[j]表示前 i 件物品重量不超过 j 的情况下能达到的最大价值，
		 * dp[j]=Math.max(dp[j],dp[j-w]+v)
		 */
		int[] dp = new int[W + 1];
		for (int i = 1; i <= N; i++)
		{

			int w = weights[i - 1];
			int v = values[i - 1];
			for (int j = 1; j <= w; j++)
			{
				if (j >= w)
				{
					dp[j] = Math.max(dp[j], dp[j - w] + v);
				}
			}
		}
		return dp[W];
	}

	public static void main(String[] args)
	{

	}
}

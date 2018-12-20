package com.lkzlee.algorithm.DP;

/***
 * @author:lkzlee
 * @date: 2018/12/18 14:29
 * @Desc:完全背包
 * 给定 n 种物品和一个容量为 C 的背包，物品 i 的重量是 wi，其价值为 vi，每个物品都有无限多件，
 * 现在往背包里面装东西，怎么装能使背包的内物品价值最大？
 */
public class BackPackageAll
{
	public int knapsack(int W, int N, int[] weights, int[] values)
	{
		if (W <= 0 || N <= 0 ||
				weights == null || weights.length <= 0 ||
				values == null || values.length <= 0)
			return 0;
		int[][] dp = new int[N + 1][W + 1];
		/***
		 * N==weight.length
		 * dp[i][j] 表示前 i 种物品恰放入一个容量为 j 的背包的最大权值
		 * 只不过物品数量没任何限制因此状态转移方程为:
		 * dp[i][j]=Math.max(dp[i-1][j-k*w]+kv,dp[i-1][j])
		 */
		for (int i = 1; i <= weights.length; i++)
		{
			int w = weights[i];
			int v = values[i];
			for (int j = 1; j <= W; j++)
			{
				for (int k = 1; k <= j / w; k++)
				{
					if (j < k * w)
						dp[i][j] = dp[i - 1][j];
					else
						dp[i][j] = Math.max(dp[i - 1][j - k * w] + v, dp[i - 1][j]);
				}
			}
		}
		return dp[N][W];
	}

	public int knapsackOpt(int W, int N, int[] weights, int[] values)
	{
		if (W <= 0 || N <= 0 ||
				weights == null || weights.length <= 0 ||
				values == null || values.length <= 0)
			return 0;
		int[] dp = new int[W + 1];
		/***
		 * dp[i]=max(dp[i],dp[i-w[i]]+v[i])
		 *
		 */
		for (int i = 1; i <= weights.length; i++)
		{
			int w = weights[i];
			int v = values[i];
			for (int j = w; j <= W; j++)
			{
				dp[j] = Math.max(dp[j], dp[j - w] + v);
			}
		}
		return dp[W];
	}

	public static void main(String[] args)
	{

	}
}

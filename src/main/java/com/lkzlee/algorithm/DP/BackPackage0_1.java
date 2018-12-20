package com.lkzlee.algorithm.DP;

/***
 * @author:lkzlee
 * @date: 2018/12/17 14:50
 * @Desc:
 * 背包问题9讲（这个讲的特别好，强烈推荐）：
 * https://www.kancloud.cn/kancloud/pack/70131
 *
 * 有一个容量为N个物品的背包，要用这个背包装下物品的价值最大，这些物品有两个属性：重量 w 和价值 v
 */
public class BackPackage0_1
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
			for (int j = 1; j <= W; j++)
			{
				if (j < w)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
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
			/***
			 * 因为 dp[j-w] 表示 dp[i-1][j-w]，因此不能先求 dp[i][j-w]，以防将 dp[i-1][j-w] 覆盖。
			 * 也就是说要先计算 dp[i][j] 再计算 dp[i][j-w]，在程序实现时需要按倒序来循环求解。
			 */
			for (int j = W; j >= w; j--)
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

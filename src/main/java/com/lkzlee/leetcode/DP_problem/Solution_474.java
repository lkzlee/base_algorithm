package com.lkzlee.leetcode.DP_problem;

/***
 * @author:lkzlee
 * @date: 2018/12/19 14:06
 * @Desc:
 *
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
 *
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 *
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 *
 * 注意:
 *
 * 给定 0 和 1 的数量都不会超过 100。
 * 给定字符串数组的长度不会超过 600。
 * 示例 1:
 *
 * 输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * 输出: 4
 *
 * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 * 示例 2:
 *
 * 输入: Array = {"10", "0", "1"}, m = 1, n = 1
 * 输出: 2
 *
 * 解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
 */
public class Solution_474
{
	public int findMaxForm(String[] strs, int m, int n)
	{

		/***
		 * 定义一个二维背包问题
		 * dp[i][j][k] 表示前i个元素，使用j个0和k个1 所能拼出的最大字符串的数量
		 * 转移方程为：
		 * 	dp[i][j][k]=Math.max(dp[i-1][j][k],dp[i-1][j-zeros[i]][k-ones[i]]+1);
		 */
		if (strs == null || strs.length <= 0)
			return 0;
		//		return backPack(strs, m, n);
		return backPackOpt(strs, m, n);
	}

	private int backPackOpt(String[] strs, int m, int n)
	{
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= strs.length; i++)
		{
			int ones = 0;
			int zeros = 0;
			for (int t = 0; t < strs[i - 1].length(); t++)
			{
				if (strs[i - 1].charAt(t) == '0')
					zeros++;
				else
					ones++;
			}
			for (int j = m; j >= zeros; j--)
			{
				for (int k = n; k >= ones; k--)
				{

					dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
				}
			}
		}
		return dp[m][n];
	}

	private int backPack(String[] strs, int m, int n)
	{
		int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
		for (int i = 1; i <= strs.length; i++)
		{
			int ones = 0;
			int zeros = 0;
			for (int t = 0; t < strs[i - 1].length(); t++)
			{
				if (strs[i - 1].charAt(t) == '0')
					zeros++;
				else
					ones++;
			}
			for (int j = 0; j <= m; j++)
			{
				for (int k = 0; k <= n; k++)
				{
					if (j < zeros || k < ones)
						dp[i][j][k] = dp[i - 1][j][k];
					else
						dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
				}
			}
		}
		return dp[strs.length][m][n];
	}

	public static void main(String[] args)
	{
		String[] strs = new String[] { "10", "1", "0" };
		int rs = new Solution_474().findMaxForm(strs, 1, 1);
		System.out.println(rs);
	}
}

package com.lkzlee.algorithm.DP;

/***
 * @author:lkzlee
 * @date: 2018/10/16 17:55
 * @Desc:
 *
 * 程序员代码面试指南-P181
 *
 * 题目描述：假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛。每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量。
 *
 * 第 i 年成熟的牛的数量为：dp[i]=dp[i-1]+dp[i-3]
 */
public class CowGenProblem
{
	public int cow(int n)
	{
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (n == 3)
			return 2;
		int[] dp = new int[n + 1];

		dp[1] = 1;
		dp[2] = dp[3] = 2;
		for (int i = 4; i <= n; i++)
		{
			dp[i] = dp[i - 1] + dp[i - 3];
		}
		return dp[n];
	}

	public static void main(String[] args)
	{
		int rs = new CowGenProblem().cow(5);
		System.out.println(rs);
	}
}

package com.lkzlee.algorithm.DP;

/***
 * @author:lkzlee
 * @date: 2018/10/16 17:18
 * @Desc:
 *
 * 信件错排
 *
 * 题目描述：有 N 个 信 和 信封，它们被打乱，求错误装信方式的数量。
 *
 * 定义一个数组 dp 存储错误方式数量，dp[i] 表示前 i 个信和信封的错误方式数量。
 * 假设第 i 个信装到第 j 个信封里面，而第 * j 个信装到第 k 个信封里面。
 * 根据 i 和 k 是否相等，有两种情况：
 *
 * i==k，交换 i 和 k 的信后，它们的信和信封在正确的位置，但是其余 i-2 封信有 dp[i-2] 种错误装信的方式。
 * 由于 j 有 i-* 1 种取值，因此共有 (i-1)*dp[i-2] 种错误装信方式。
 * i != k，交换 i 和 j 的信后，第 i 个信和信封在正确的位置，
 * 其余 i-1 封信有 dp[i-1] 种错误装信方式。
 * 由于 j 有 i-1 * 种取值，因此共有 (i-1)*dp[i-1] 种错误装信方式。
 * 综上所述，错误装信数量方式数量为：
 * 		dp[i]=(i-1)*dp[i-2]+(i-1)*dp[i-1]
 */
public class MailSort
{
	public int permute(int n)
	{
		if (n == 1)
			return 0;
		if (n == 2)
			return 1;
		return (n - 1) * (permute(n - 2) + permute(n - 1));
	}

	public int permuteDP(int n)
	{
		if (n == 1)
			return 0;
		if (n == 2)
			return 1;
		int[] dp = new int[n + 1];
		dp[1] = 0;
		dp[2] = 1;
		for (int i = 3; i <= n; i++)
		{
			dp[i] = (i - 1) * (dp[i - 2] + dp[i - 1]);
		}
		return dp[n];
	}

	public static void main(String[] args)
	{
		int rs = new MailSort().permuteDP(5);
		System.out.println(rs);
	}
}

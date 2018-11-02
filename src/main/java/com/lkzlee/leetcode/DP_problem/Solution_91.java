package com.lkzlee.leetcode.DP_problem;

/***
 * @author:lkzlee
 * @date: 2018/10/25 16:11
 * @Desc:
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class Solution_91
{
	public int numDecodings(String s)
	{
		/***
		 * 使用动态规划解决该题，dp[i]表示以字符s[i]结尾的字符编码总数
		 *
		 * dp[i]=dp[i-1] ,s[i]和s[i-1]	组成的编码不在1-26之间，则无效
		 * dp[i]=dp[i-1]+dp[i-2], s[i]和s[i-1]	组成的编码不在1-26之间，则有效
		 */
		if (s == null || s.length() <= 0)
			return 0;
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= s.length(); i++)
		{

			int one = Integer.parseInt(s.substring(i - 1, i));
			if (one != 0)
				dp[i] = dp[i - 1];
			if (s.charAt(i - 2) == '0')
				continue;
			int two = Integer.parseInt(s.substring(i - 2, i));
			if (two <= 26)
				dp[i] += dp[i - 2];

		}
		return dp[s.length()];
	}

	public static void main(String[] args)
	{
		int rs = new Solution_91().numDecodings("100");
		System.out.println(rs);
	}
}
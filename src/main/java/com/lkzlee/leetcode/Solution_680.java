package com.lkzlee.leetcode;

/***
 * @author:lkzlee
 * @date: 2018/9/26 19:01
 * @Desc:给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 示例 1:
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 */
public class Solution_680
{
	public boolean validPalindrome(String s)
	{
		if (s == null || "".equals(s))
			return false;
		for (int i = 0, j = s.length() - 1; i < j; i++, j--)
		{
			if (s.charAt(i) != s.charAt(j))
			{
				return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
			}
		}
		return true;
	}

	private boolean isPalindrome(String s, int i, int j)
	{
		while (i < j)
		{
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args)
	{
		boolean rs = new Solution_680().validPalindrome("abccdba");
		System.out.println(rs);
	}
}

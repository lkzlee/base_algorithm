package com.lkzlee.leetcode;

/***
 * @author:lkzlee
 * @date: 2018/9/26 19:01
 * @Desc:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
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

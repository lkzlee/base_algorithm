package com.lkzlee.leetcode;

/***
 * @author:lkzlee
 * @date: 2018/9/26 18:09
 * @Desc:给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * 示例1:
 *
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *
 * 示例2:
 * 输入: 3
 * 输出: False
 */
public class Solution_633
{
	public boolean judgeSquareSum(int c)
	{
		if (c < 0)
			return false;
		int i = 0;
		int j = (int) Math.sqrt(c);
		while (i <= j)
		{
			int pwSum = i * i + j * j;
			if (pwSum == c)
				return true;
			else if (pwSum < c)
			{
				i++;
			}
			else
			{
				j--;
			}
		}
		return false;
	}

	public static void main(String[] args)
	{
		boolean rs = new Solution_633().judgeSquareSum(2);
		System.out.println(rs);
	}

}

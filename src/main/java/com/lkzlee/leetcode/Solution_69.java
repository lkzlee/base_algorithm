package com.lkzlee.leetcode;

/***
 * @author:lkzlee
 * @date: 2018/5/8 19:48
 * @Desc:实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class Solution_69
{
	public int mySqrt(int x)
	{
		if (x < 0)
			return -1;
		int l = 1, h = x;
		while (l <= h)
		{
			int mid = l + (h - l) / 2;
			int rsX = x / mid;
			if (rsX == mid)
				return mid;
			else if (rsX < mid)
				h = mid - 1;
			else
				l = mid + 1;
		}
		return h;
	}

	public static void main(String[] args)
	{
		int st = new Solution_69().mySqrt(2147395599);
		System.out.println(st);
	}
}

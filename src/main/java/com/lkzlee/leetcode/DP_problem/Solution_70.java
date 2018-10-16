package com.lkzlee.leetcode.DP_problem;

/***
 * @author:lkzlee
 * @date: 2018/10/16 10:51
 * @Desc:
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class Solution_70
{
	public int climbStairs(int n)
	{
		if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		int t1 = 1;
		int t2 = 2;
		for (int i = 3; i <= n; i++)
		{
			int t = t1 + t2;
			t1 = t2;
			t2 = t;
		}
		return t2;
	}

	public static void main(String[] args)
	{
		int rs=new Solution_70().climbStairs(3);
		System.out.println(rs);
	}
}

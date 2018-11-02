package com.lkzlee.leetcode.BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * @author:lkzlee
 * @date: 2018/10/10 11:22
 * @Desc:
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 * n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class Solution_279
{
	public int numSquares(int n)
	{
		/***
		 * 生成一个平方数序列，然后进行广度优先遍历
		 * 第一种解法采用广度优先遍历找出最小的平方数个数
		 */
		//		return BFS(n);
		/**
		 * 第二种算法采用动态规划，定义dp[i] 表示i的最小平方数个数
		 */
		int[] dp = new int[n + 1];
		dp[1] = 1;
		/***
		 * 还要另外一种四平方定理
		 */
		List<Integer> squaresList = generateSquaresList(n);
		for (int i = 2; i <= n; i++)
		{
			int minNums = Integer.MAX_VALUE;
			for (int t : squaresList)
			{
				if (i < t)
					break;
				minNums = Math.min(minNums, dp[i - t] + 1);
			}
			dp[i] = minNums;
		}
		return dp[n];
	}

	private int BFS(int n)
	{
		int[][] direct = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		List<Integer> squaresList = generateSquaresList(n);
		int minNums = 0;
		while (!queue.isEmpty())
		{
			minNums++;
			int size = queue.size();
			while (size-- > 0)
			{
				int t = queue.poll();
				for (int s : squaresList)
				{
					int p = t - s;
					if (p < 0)
						break;
					if (p == 0)
						return minNums;
					queue.add(p);
				}
			}
		}
		return -1;
	}

	private List<Integer> generateSquaresList(int n)
	{
		int i = 1;
		List<Integer> list = new ArrayList<>();
		while (i * i <= n)
		{
			list.add(i * i);
			i++;
		}
		return list;
	}

	public static void main(String[] args)
	{
		int rs = new Solution_279().numSquares(13);
		System.out.println(rs);
	}
}

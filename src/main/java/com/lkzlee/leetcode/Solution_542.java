package com.lkzlee.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @author:lkzlee
 * @date: 2018/2/24 18:23
 * @Desc:
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * 找出矩阵中与0最近的距离，该元素有上下左右四个方向，
 * 思路：1.使用分治法比较笨;
 * 		2.采用动态规划比较合适，可以使用原矩阵记录上次的结果，具体保存该上次结果的思路是记录每个元素的上下左右最短距离，未计算标记为-1
 */
public class Solution_542
{
	public int[][] updateMatrix(int[][] matrix)
	{

		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (matrix[i][j] == 0)
				{
					queue.offer(new int[] { i, j });
				}
				else
				{
					matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		while (!queue.isEmpty())
		{
			int[] t = queue.poll();
			for (int[] d : dirs)
			{
				int x = t[0] + d[0];
				int y = t[1] + d[1];
				if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[x].length
						|| matrix[t[0]][t[1]] + 1 >= matrix[x][y])
				{
					continue;
				}
				matrix[x][y] = matrix[t[0]][t[1]] + 1;
				queue.offer(new int[] { x, y });
			}
		}
		return matrix;
	}

	public static void main(String[] args)
	{
		int m[][] = { { 0, 0, 0 },
				{ 0, 1, 0 },
				{ 1, 1, 1 } };
		m = new Solution_542().updateMatrix(m);
		for (int i = 0; i < m.length; i++)
		{
			for (int j = 0; j < m[i].length; j++)
			{
				System.out.print(m[i][j] + " ");
			}
			System.out.println("\b");
		}
	}
}

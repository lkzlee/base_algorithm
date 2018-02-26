package com.lkzlee.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***
 * @author:lkzlee
 * @date: 2018/2/24 18:23
 * @Desc:
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * 找出矩阵中与0最近的距离，该元素有上下左右四个方向，
 * 思路：
 * 1.使用BFS广度遍历，初始化矩阵：0入队，1改为最大，然后出队计算，以0节点向四个方向遍历，越界或者如果当前值v+1大于该方向上的值，则不做更新直接返回，否则更新该方向上的值并入队;
 * 2.采用巧妙思路，先遍历上、左，然后倒序（上次错在没有倒序）遍历走下、右遍历更新该矩阵的值
 */
public class Solution_542
{
	public int[][] updateMatrix(int[][] matrix)
	{
		//		return SolutionBFS(matrix);
		return SolutionBest(matrix);
	}

	private int[][] SolutionBest(int[][] matrix)
	{
		int[][] rs = new int[matrix.length][matrix[0].length];
		for (int[] r : rs)
		{
			Arrays.setAll(r, t -> {
				return Integer.MAX_VALUE - 1;
			});
		}
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (matrix[i][j] == 0)
				{
					rs[i][j] = 0;
				}
				else
				{
					if (i > 0)
					{
						rs[i][j] = Math.min(rs[i][j], rs[i - 1][j] + 1);
					}
					if (j > 0)
					{
						rs[i][j] = Math.min(rs[i][j], rs[i][j - 1] + 1);
					}
				}
			}
		}
		for (int i = matrix.length - 1; i >= 0; i--)
		{
			for (int j =matrix[i].length-1; j >=0; j--)
			{

				if (rs[i][j] == 0 || rs[i][j] == 1)
				{
					continue;
				}
				if (i < matrix.length - 1)
				{
					rs[i][j] = Math.min(rs[i][j], rs[i + 1][j] + 1);
				}
				if (j < matrix[i].length - 1)
				{
					rs[i][j] = Math.min(rs[i][j], rs[i][j + 1] + 1);
				}

			}
		}
		return rs;
	}

	private int[][] SolutionBFS(int[][] matrix)
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

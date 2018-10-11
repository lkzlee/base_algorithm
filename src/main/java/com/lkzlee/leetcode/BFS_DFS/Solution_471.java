package com.lkzlee.leetcode.BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/10/11 18:12
 * @Desc:
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 *
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。

 *
 * 提示：
 * 输出坐标的顺序不重要
 *  和 n 都小于150
 *
 *
 * 示例：
 *
 * 给定下面的 5x5 矩阵:
 *  太平  ~   ~   ~   ~   ~
 *       ~  1   2   2   3  (5) *
 *       ~  3   2   3  (4) (4) *
 *       ~  2   4  (5)  3   1  *
 *       ~ (6) (7)  1   4   5  *
 *       ~ (5)  1   1   2   4  *
 *          *   *   *   *   * 大西洋
 * 返回:
 * [0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 */
public class Solution_471
{
	int[][] direction = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public List<int[]> pacificAtlantic(int[][] matrix)
	{
		List<int[]> list = new ArrayList<>();
		if (matrix == null || matrix.length <= 0 || matrix[0] == null || matrix[0].length <= 0)
			return list;
		boolean[][] reachA = new boolean[matrix.length][matrix[0].length];
		boolean[][] reachB = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++)
		{
			dfs(matrix, i, 0, reachA);
			dfs(matrix, i, matrix[i].length - 1, reachB);
		}
		for (int j = 0; j < matrix[0].length; j++)
		{
			dfs(matrix, 0, j, reachA);
			dfs(matrix, matrix.length - 1, j, reachB);
		}
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (reachA[i][j] && reachB[i][j])
					list.add(new int[] { i, j });
			}
		}
		return list;
	}

	private void dfs(int[][] matrix, int i, int j, boolean[][] reach)
	{
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length)
			return;
		if (reach[i][j])
			return;
		reach[i][j] = true;
		for (int[] d : direction)
		{
			int x = i + d[0];
			int y = j + d[1];
			if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[i].length)
				continue;
			if (reach[x][y])
				continue;
			if (matrix[x][y] < matrix[i][j])
				continue;
			dfs(matrix, x, y, reach);
		}

	}

	public static void main(String[] args)
	{
		int[][] matrix = new int[][] {
				{ 1, 2, 2, 3, 5 },
				{ 3, 2, 3, 4, 4 },
				{ 2, 4, 5, 3, 1 },
				{ 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		List<int[]> rs = new Solution_471().pacificAtlantic(matrix);
		for (int[] t : rs)
		{
			System.out.println(Arrays.toString(t));
		}
	}
}

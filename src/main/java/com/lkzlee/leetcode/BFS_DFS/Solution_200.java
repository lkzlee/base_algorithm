package com.lkzlee.leetcode.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/***
 * @author:lkzlee
 * @date: 2018/3/8 11:17
 * @Desc:给定 '1'（陆地）和 '0'（水）的二维网格图，计算岛屿的数量。一个岛被水包围，
 * 并且通过水平或垂直连接相邻的陆地而形成。你可以假设网格的四个边均被水包围。
 * 思路：1.设置一个访问标示矩阵，从一个点出发找出是否是一个岛屿，
 * 			如果为'0'则不是岛屿返回0个，
 * 			如果已被访问则返回0个表示已经被计算在内，
 * 		2.其余进行可采用BFS或DFS遍历方式，标记访问矩阵为已访问，最后返回岛屿数量1(记得判空,切记是字符'0')
 */
public class Solution_200
{
	public int numIslands(char[][] grid)
	{
		if (grid == null || grid.length <= 0 || grid[0] == null || grid[0].length <= 0)
			return 0;
		boolean[][] vst = new boolean[grid.length][grid[0].length];
		int rst = 0;
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[i].length; j++)
			{
				rst += numBFS_queue(grid, vst, i, j);
			}
		}
		return rst;
	}

	/***
	 * 递归调用方式，容易栈溢出
	 * @param grid
	 * @param vst
	 * @param i
	 * @param j
	 * @return
	 */
	private int numDFS(char[][] grid, boolean[][] vst, int i, int j)
	{
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
			return 0;
		if (grid[i][j] == '0')
			return 0;
		if (vst[i][j])
			return 0;
		vst[i][j] = true;
		numDFS(grid, vst, i - 1, j);
		numDFS(grid, vst, i + 1, j);
		numDFS(grid, vst, i, j - 1);
		numDFS(grid, vst, i, j + 1);
		return 1;
	}

	/***
	 * 非递归调用方式
	 * @param grid
	 * @param vst
	 * @param i
	 * @param j
	 * @return
	 */
	private int numDFS_stack(char[][] grid, boolean[][] vst, int i, int j)
	{
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
			return 0;
		if (grid[i][j] == '0')
			return 0;
		if (vst[i][j])
			return 0;
		vst[i][j] = true;
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] { i, j });
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		while (!stack.isEmpty())
		{
			int[] d = stack.pop();
			for (int[] t : dir)
			{
				int x = d[0] + t[0];
				int y = d[1] + t[1];
				if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
					continue;
				/***
				 * 	如果已访问过
				 */
				if (grid[x][y] == '0' || vst[x][y])
					continue;
				vst[x][y] = true;
				stack.push(new int[] { x, y });
			}
		}
		return 1;
	}

	private int numBFS_queue(char[][] grid, boolean[][] vst, int i, int j)
	{
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
			return 0;
		if (grid[i][j] == '0')
			return 0;
		if (vst[i][j])
			return 0;
		vst[i][j] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		while (!queue.isEmpty())
		{
			int[] d = queue.poll();
			for (int[] t : dir)
			{
				int x = d[0] + t[0];
				int y = d[1] + t[1];
				if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
					continue;
				/***
				 * 	如果已访问过
				 */
				if (grid[x][y] == '0' || vst[x][y])
					continue;
				vst[x][y] = true;
				queue.add(new int[] { x, y });
			}
		}
		return 1;
	}

	public static void main(String[] args)
	{
		char[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
		int ts = new Solution_200().numIslands(grid);
		System.out.println(ts);
	}
}

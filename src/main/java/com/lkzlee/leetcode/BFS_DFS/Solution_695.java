package com.lkzlee.leetcode.BFS_DFS;

/***
 * @author:lkzlee
 * @date: 2018/10/10 18:38
 * @Desc:
 *
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) * 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 */
public class Solution_695
{
	public int maxAreaOfIsland(int[][] grid)
	{

		if (grid == null || grid.length <= 0 || grid[0] == null || grid[0].length <= 0)
			return 0;
		boolean[][] mark = new boolean[grid.length][grid[0].length];
		int maxArea = 0;
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[i].length; j++)
			{
				if (mark[i][j] || grid[i][j] == 0)
					continue;
				int area = DFS_AreaIsland(grid, i, j, mark);
				if (maxArea < area)
					maxArea = area;
			}
		}
		return maxArea;
	}

	private int DFS_AreaIsland(int[][] grid, int i, int j, boolean[][] mark)
	{
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
			return 0;
		if (mark[i][j])
			return 0;
		if (grid[i][j] == 0)
		{
			mark[i][j] = true;
			return 0;
		}
		int area = 1;
		mark[i][j]=true;
		area += DFS_AreaIsland(grid, i + 1, j, mark);
		area += DFS_AreaIsland(grid, i - 1, j, mark);
		area += DFS_AreaIsland(grid, i, j + 1, mark);
		area += DFS_AreaIsland(grid, i, j - 1, mark);
		return area;
	}

	public static void main(String[] args)
	{
		int[][] grid = new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		int rs = new Solution_695().maxAreaOfIsland(grid);
		System.out.println(rs);
	}
}

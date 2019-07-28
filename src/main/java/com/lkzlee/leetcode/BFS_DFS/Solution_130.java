package com.lkzlee.leetcode.BFS_DFS;

/***
 * @author:lkzlee
 * @date: 2018/10/11 17:17
 * @Desc:
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' * 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Solution_130
{
	public void solve(char[][] board)
	{
		/***
		 * 这个题可以用三种解法：DFS深度优先遍历、BFS广度优先遍历、并查集
		 */
		if (board == null || board.length <= 0 || board[0] == null || board[0].length <= 0)
			return;
		//从四个边界做四次dfs标记T，然后其余的全部标记为X，然后把T改回去
		for (int i = 0; i < board.length; i++)
		{
			dfs(board, i, 0);
			dfs(board, i, board[i].length - 1);
		}
		for (int j = 0; j < board[0].length; j++)
		{
			dfs(board, 0, j);
			dfs(board, board.length - 1, j);
		}
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				else if (board[i][j] == 'T')
					board[i][j] = 'O';
			}
		}
	}

	private void dfs(char[][] board, int i, int j)
	{
		if (i < 0 || j < 0 || i >= board.length || j >= board[i].length)
			return;
		if (board[i][j] == 'X'||board[i][j]=='T')
			return;
		board[i][j] = 'T';
		dfs(board, i + 1, j);
		dfs(board, i - 1, j);
		dfs(board, i, j + 1);
		dfs(board, i, j - 1);
	}

	public static void main(String[] args)
	{
		char[][] board = new char[][] { { 'O', 'O' },
				{ 'O', 'O' }};
		new Solution_130().solve(board);
		for (int i = 0; i < board.length; i++)
		{
			System.out.print("[");
			for (int j = 0; j < board[i].length; j++)
			{
				System.out.print(board[i][j] + ",");
			}
			System.out.println("]");
		}
	}
}

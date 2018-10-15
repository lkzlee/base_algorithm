package com.lkzlee.leetcode.back_tracking;

/***
 * @author:lkzlee
 * @date: 2018/10/12 14:50
 * @Desc:
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的* 字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class Solution_79
{
	int[][] direction = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public boolean exist(char[][] board, String word)
	{
		if (word == null || word.length() <= 0)
			return true;
		if (board == null || board.length <= 0)
			return false;
		boolean[][] mark = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				boolean isExist = backTracking(board, word, i, j, mark);
				if (isExist)
					return true;
			}
		}
		return false;
	}

	private boolean backTracking(char[][] board, String word, int i, int j, boolean[][] mark)
	{
		if (word.length() == 0)
			return true;
		if (i < 0 || j < 0 || i >= board.length || j >= board[i].length)
			return false;
		if (board[i][j] != word.charAt(0))
			return false;
		if (mark[i][j])
			return false;
		mark[i][j] = true;
		for (int[] d : direction)
		{
			int x = i + d[0];
			int y = j + d[1];
			boolean rs = backTracking(board, word.substring(1), x, y, mark);
			if (rs)
				return true;

		}
		mark[i][j] = false;
		return false;
	}

	public static void main(String[] args)
	{
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		boolean rs = new Solution_79().exist(board, word);
		System.out.println(rs);
	}

}

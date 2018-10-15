package com.lkzlee.leetcode.back_tracking;

import java.util.Arrays;

/***
 * @author:lkzlee
 * @date: 2018/10/15 15:11
 * @Desc:
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 *
 *
 * 一个数独。
 *
 *
 *
 * 答案被标成红色。
 *
 * Note:
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 */
public class Solution_37
{
	private boolean[][] rowsUsed = new boolean[9][10];
	private boolean[][] colsUsed = new boolean[9][10];
	private boolean[][] cubesUsed = new boolean[9][10];

	public void solveSudoku(char[][] board)
	{
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				if (board[i][j] == '.')
				{
					continue;
				}
				int num = board[i][j] - '0';
				rowsUsed[i][num] = true;
				colsUsed[j][num] = true;
				cubesUsed[getCubeIndex(i, j)][num] = true;
			}
		}
		doSolve(board, 0, 0);

	}

	private int getCubeIndex(int i, int j)
	{
		return i / 3 * 3 + j / 3;
	}

	private boolean doSolve(char[][] board, int i, int j)
	{

		if (i == board.length)
			return true;
		if (j == board[i].length)
			return doSolve(board, i + 1, 0);
		if (board[i][j] != '.')
			return doSolve(board, i, j + 1);
		for (int t = 1; t <= 9; t++)
		{
			char fillChar = (char) ('0' + t);
			if (rowsUsed[i][t] || colsUsed[j][t] || cubesUsed[getCubeIndex(i, j)][t])
				continue;

			board[i][j] = fillChar;
			rowsUsed[i][t] = true;
			colsUsed[j][t] = true;
			cubesUsed[getCubeIndex(i, j)][t] = true;
			boolean ifFlag = doSolve(board, i, j + 1);
			if (ifFlag)
				return true;
			board[i][j] = '.';
			rowsUsed[i][t] = false;
			colsUsed[j][t] = false;
			cubesUsed[getCubeIndex(i, j)][t] = false;
		}
		return false;
	}

	public static void main(String[] args)
	{
		char[][] board = new char[9][9];
		for (int i = 0; i < board.length; i++)
		{
			board[i] = new char[9];
			Arrays.fill(board[i], '.');
		}
		board[0][0] = '5';
		board[0][1] = '3';
		board[0][4] = '7';

		board[1][0] = '6';
		board[1][3] = '1';
		board[1][4] = '9';
		board[1][5] = '5';

		board[2][1] = '9';
		board[2][2] = '8';
		board[2][7] = '6';

		board[3][0] = '8';
		board[3][4] = '6';
		board[3][8] = '3';

		board[4][0] = '4';
		board[4][3] = '8';
		board[4][5] = '3';
		board[4][8] = '1';

		board[5][0] = '7';
		board[5][4] = '2';
		board[5][8] = '6';

		board[6][1] = '6';
		board[6][6] = '2';
		board[6][7] = '8';

		board[7][3] = '4';
		board[7][4] = '1';
		board[7][5] = '9';
		board[7][8] = '5';

		board[8][4] = '8';
		board[8][7] = '7';
		board[8][8] = '9';

		printBoard(board);
		new Solution_37().solveSudoku(board);
		printBoard(board);

	}

	private static void printBoard(char[][] board)
	{
		System.out.println();
		for (int i = 0; i < board.length; i++)
		{
			System.out.print("[");
			for (int j = 0; j < board[i].length; j++)
			{
				if (j > 0)
					System.out.print(",");
				System.out.print(board[i][j]);
			}
			System.out.println("]");
		}
	}

}

package com.lkzlee.leetcode.BFS_DFS;

/***
 * @author:lkzlee
 * @date: 2018/10/11 10:34
 * @Desc:
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
 * 如果已知 A 是 B 的朋友，B 是 C * 的朋友，那么我们可以认为 A 也是 C 的朋友。
 * 所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，
 * 表示已知第 i 个和 j * 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * 示例 1:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 示例 2:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 注意：
 *
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 */
public class Solution_547
{
	class QuickFind
	{
		private int[] id;
		private int count;

		public QuickFind(int n)
		{
			this.count = n;
			id = new int[n];
			for (int i = 0; i < id.length; i++)
			{
				id[i] = i;
			}
		}

		public int count()
		{
			return count;
		}

		public boolean isConnected(int p, int q)
		{
			return find(p) == find(q);
		}

		public int find(int p)
		{
			return id[p];
		}

		public void union(int p, int q)
		{
			int p_gid = find(p);
			int q_gid = find(q);
			if (p_gid == q_gid)
				return;
			for (int i = 0; i < id.length; i++)
			{
				if (id[i] == q_gid)
					id[i] = p_gid;
			}
			count--;
		}
	}

	public int findCircleNum(int[][] M)
	{
		/***
		 * 第一次接触该题，思路一开始是抄的，实在想不出来，最后看了并查集有点理解为啥需要boolean[] mark 一维数组
		 *
		 * 该题的核心点是N个人最多每个人都是孤立的自己跟自己玩，也就初始的mark数组为false，最大朋友圈个数N
		 * 从第一个人遍历他自身的朋友圈，标记已经是朋友的标记，确认是一个朋友圈，
		 * 这样DFS遍历检索下来未标记肯定和已标记不是一个朋友圈的，所以计数fcNum++。
		 *
		 * 第二种思路：并查集
		 */
		if (M == null || M.length <= 0 || M[0] == null || M[0].length <= 0)
			return 0;
		//		return dfs(M);

		QuickFind qf = new QuickFind(M.length);
		for (int i = 0; i < M.length; i++)
		{
			for (int j = 0; j < M[i].length; j++)
			{
				if (M[i][j] == 1)
					qf.union(i, j);
			}
		}
		return qf.count();
	}

	private int dfs(int[][] M)
	{
		int fcNum = 0;
		boolean[] mark = new boolean[M.length];
		for (int i = 0; i < M.length; i++)
		{
			if (!mark[i])
			{
				DFS_findCircleNum(M, i, mark);
				fcNum++;
			}

		}
		return fcNum;
	}

	private void DFS_findCircleNum(int[][] M, int i, boolean[] mark)
	{
		mark[i] = true;
		for (int j = 0; j < M[i].length; j++)
		{
			if (!mark[j] && M[i][j] == 1)
			{
				DFS_findCircleNum(M, j, mark);
			}
		}
	}

	public static void main(String[] args)
	{
		int[][] m = new int[][] {
				{ 1, 0, 0, 1 },
				{ 0, 1, 1, 0 },
				{ 0, 1, 1, 1 },
				{ 1, 0, 1, 1 } };
		int rs = new Solution_547().findCircleNum(m);
		System.out.println(rs);
	}

}

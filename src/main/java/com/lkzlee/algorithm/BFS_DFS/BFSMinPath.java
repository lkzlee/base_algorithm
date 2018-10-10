package com.lkzlee.algorithm.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @author:lkzlee
 * @date: 2018/10/10 17:11
 * @Desc:
 * 计算在网格中从原点到特定点的最短路径长度
 *
 * [[1,1,0,1],
 *  [1,0,1,0],
 *  [1,1,1,1],
 *  [1,0,1,1]]
 * 1 表示可以经过某个位置，求解从 (0, 0) 位置到 (tr, tc) 位置的最短路径长度。
 */
public class BFSMinPath
{
	public int minPathLength(int[][] grids, int tr, int tc)
	{
		if (grids == null || grids.length <= 0)
			return -1;
		Queue<int[]> queue = new LinkedList<>();
		int pathLen = 0;
		queue.add(new int[] { 0, 0 });
		int[][] direct = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
		while (!queue.isEmpty())
		{
			pathLen++;
			int size = queue.size();
			while (size-- > 0)
			{
				int[] point = queue.poll();
				int x = point[0], y = point[1];
				if (grids[x][y] == 0)
					continue;
				grids[x][y] = 0;

				for (int[] d : direct)
				{
					int x1 = x + d[0];
					int y1 = y + d[1];

					if (x1 < 0 || y1 < 0 || x1 >= grids.length || y1 >= grids[x1].length || grids[x1][y1] == 0)
						continue;
					if (x1 == tr && y1 == tc && grids[x1][y1] == 1)
						return pathLen;
					queue.add(new int[] { x1, y1 });
				}
			}
		}
		return -1;
	}

	public static void main(String[] args)
	{
		int[][] path = new int[][] { { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, { 1, 1, 1, 1 }, { 1, 0, 1, 1 } };
		int rs = new BFSMinPath().minPathLength(path, 3, 3);
		System.out.println(rs);
	}
}

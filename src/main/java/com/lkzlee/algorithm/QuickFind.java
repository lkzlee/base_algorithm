package com.lkzlee.algorithm;

/***
 * @author:lkzlee
 * @date: 2018/10/11 16:15
 * @Desc:并查集
 */
public class QuickFind
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

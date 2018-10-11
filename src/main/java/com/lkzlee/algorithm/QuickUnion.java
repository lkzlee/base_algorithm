package com.lkzlee.algorithm;

/***
 * @author:lkzlee
 * @date: 2018/10/11 16:52
 * @Desc: 并查集-数组多叉树的实现
 */
public class QuickUnion
{
	private int[] id;
	private int count;

	public QuickUnion(int n)
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
		while (p != id[p])
			p = id[p];
		return p;
	}

	public void union(int p, int q)
	{

		int p_root = find(p);
		int q_root = find(q);
		if (p_root == q_root)
			return;
		id[p_root] = q_root;
		count--;
	}
}

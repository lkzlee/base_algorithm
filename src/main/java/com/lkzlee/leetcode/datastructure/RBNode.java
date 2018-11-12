package com.lkzlee.leetcode.datastructure;

/***
 * @author:lkzlee
 * @date: 2018/11/12 14:42
 * @Desc:
 */
public class RBNode<T extends Comparable<T>>
{

	public boolean color;
	public T key;
	public RBNode<T> left;
	public RBNode<T> right;
	public RBNode<T> parent;

	public RBNode(boolean color, T key, RBNode<T> left, RBNode<T> right, RBNode<T> parent)
	{
		this.color = color;
		this.key = key;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	@Override
	public String toString()
	{
		return "RBNode{" +
				"color=" + color +
				", key=" + key +
				", left=" + left +
				", right=" + right +
				", parent=" + parent +
				'}';
	}
}

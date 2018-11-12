package com.lkzlee.algorithm;

import java.util.Stack;

/***
 * @author:lkzlee
 * @date: 2018/11/12 20:11
 * @Desc: 用两个栈实现一个队列的功能
 */
public class StackToQueue<T>
{
	private Stack<T> s1 = new Stack<T>();
	private Stack<T> s2 = new Stack<T>();

	public void add(T key)
	{
		s1.push(key);
	}

	public T pop()
	{
		if (!s2.isEmpty())
			return s2.pop();
		while (!s1.isEmpty())
		{
			s2.push(s1.pop());
		}
		return s2.pop();
	}

}

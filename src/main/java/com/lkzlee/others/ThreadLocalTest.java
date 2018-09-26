package com.lkzlee.others;

/***
 * @author:lkzlee
 * @date: 2018/5/30 18:35
 * @Desc:
 */
public class ThreadLocalTest
{
	public static ThreadLocal<String> t = new ThreadLocal<String>()
	{
		@Override
		protected String initialValue()
		{
			return "initValue";
		}
	};
	public static ThreadLocal<Integer> t2 = new ThreadLocal<Integer>()
	{
		@Override
		protected Integer initialValue()
		{
			return 1;
		}
	};

	public static void main(String[] args)
	{
		System.out.println(t.get() + "|" +t);
		System.out.println(t2.get() + "|" +t2);
	}
}

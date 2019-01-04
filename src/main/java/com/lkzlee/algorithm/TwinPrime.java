package com.lkzlee.algorithm;

import java.util.Arrays;

/***
 * @author:lkzlee
 * @date: 2019/1/4 10:35
 * @Desc:
 */
public class TwinPrime
{
	public int[] smallestPrimePair(int n)
	{
		/**
		 * 边界处理
		 */
		if (n <= 1)
			return null;

		/***
		 * 由于孪生素数已经被证明有无数多个，所以以下循环一定不是死循环
		 */
		/***
		 * 定义两个变量记录最近的素数，然后判断是否孪生
		 */
		int prime1, prime2;
		/***
		 * 先找到第一个素数
		 */
		for (int i = n; ; i++)
		{
			if (isPrime(i))
			{
				prime1 = i;
				break;
			}
		}
		/***
		 * 然后找第二个素数
		 */
		for (int i = prime1 + 1; ; i++)
		{
			if (!isPrime(i)) //判定素数可以优化
				continue;

			prime2 = i; //找到第二个素数

			/***
			 * 如果两个素数是孪生素数，直接返回
			 */
			if (Math.abs(prime1 - prime2) <= 2)
			{
				return new int[] { prime1, prime2 };
			}
			else
			{
				/**
				 * 如果不是孪生，则第二个素数赋值给第一个prime1，继续找第二个
				 */
				prime1 = prime2;
			}

		}

	}

	/***
	 * 素数只能被1和本身整除的数是素数（注意：1不是素数）
	 * @param n
	 * 这块可以优化
	 * @return
	 */

	public boolean isPrime(int n)
	{
		for (int i = 2; i < n; i++)
		{
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args)
	{
		int[] rs = new TwinPrime().smallestPrimePair(500);
		System.out.println(Arrays.toString(rs));
	}
}

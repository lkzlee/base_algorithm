package com.lkzlee.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***
 * @author:lkzlee
 * @date: 2018/11/14 10:58
 * @Desc:
 *
 * 给定一个数组，重新排列数组使得数组左不改变相对顺序，负数左边正数右边
 * 时空复杂度要求分别为：o(n)和o(1)。
 */
public class ClassSort
{
	public void partionClass(int[] nums)
	{
		if (nums == null || nums.length <= 0)
			return;
		//		normalMove(nums);

		/***
		 * 方法二：用partion ,这样会改变相对顺序，不符合要求
		 */

//		doubleQueue(nums);

		/***
		 * 从右往左扫描，寻找最大最近的负数区间，以及该负数区间左边最大最近的正数区间，
		 * 然后将这两个区间利用循环右移的方法移动，使得负数区间在正数区间的前面。
		 * 继续寻找最大最近的负数区间（在上一个负数区间的基础上），以及最大最近的正数区间。然后继续循环右移；
		 *
		 * （利用的是循环右移中，a,bcd->bcd,a中，bcd的相对顺序没有发生变化）
		 */

	}

	private void doubleQueue(int[] nums)
	{
		/***
		 * 建立2个大小为n的队列，一个存储正数，一个存储负数，遍历数组，将正数添加到正数队列，负数添加到负数队列。
		 * 然后分别将负数队列，以及正数队列出队到数组中。时间复杂度为O(n),空间复杂度为O(n);
		 * 其实也不符合要求，空间换时间了
		 */
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] < 0)
				queue.add(nums[i]);
			else
				queue2.add(nums[i]);
		}
		int idx = 0;
		while (!queue.isEmpty())
			nums[idx++] = queue.poll();
		while (!queue2.isEmpty())
			nums[idx++] = queue2.poll();
	}

	private void normalMove(int[] nums)
	{
		/***
		 * 最笨的办法：o(N*N)
		 * 从头到尾扫描数组，每次碰到一个正数时，就把位于这个数字之后的所有数字到往前挪动一位。挪动之后在数组的末尾有一个空位，把这个正数填进去。整体的时间复杂度为O(n^2)，空间复杂度为O(1)
		 */
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] < 0)
				continue;
			int t = findNegtive(nums, i + 1);
			if (t == -1)
				break;
			int tmp = nums[t];
			for (int j = t; j > i; j--)
			{
				nums[j] = nums[j - 1];
			}
			nums[i] = tmp;
		}
	}

	private int findNegtive(int[] nums, int start)
	{
		for (int i = start; i < nums.length; i++)
		{
			if (nums[i] < 0)
				return i;
		}
		return -1;
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { -6, 3 ,- 9, 5, 1, 4, -8, 7 };
		new ClassSort().partionClass(nums);
		System.out.println(Arrays.toString(nums));
	}
}

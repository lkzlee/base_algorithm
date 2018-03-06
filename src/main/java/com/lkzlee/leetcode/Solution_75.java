package com.lkzlee.leetcode;

import java.util.Arrays;

/***
 * @author:lkzlee
 * @date: 2018/3/6 16:53
 * @Desc:分类颜色问题
 * 给定一个包含红色、白色和蓝色，且含有 n 个元素的数组，对它们进行排序，使得相同颜色的元素相邻，颜色顺序为红色、白色、蓝色。
 * 此题中，我们使用整数 0, 1 和 2 分别表示红色，白色和蓝色。
 * 注意:不能使用代码库中的排序函数来解决这道题。
 */
public class Solution_75
{
	public void sortColors(int[] nums)
	{
		int i = 0;
		int j = 0;
		int n = nums.length - 1;
		while (i <= n)
		{
			if (nums[i] == 0)
			{
				swap(nums, i, j);
				i++;
				j++;
			}
			else if (nums[i] ==1)
			{
				i++;
			}
			else
			{
				swap(nums, i, n);
				n--;
			}
		}
	}

	private void swap(int[] nums, int i, int j)
	{
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	public static void main(String[] args)
	{
		int[] nums = { 0, 2, 1, 1, 1, 1, 1, 2, 0, 2, 2, 0, 1, 2, 1, 0, 0, 0 };
		new Solution_75().sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}

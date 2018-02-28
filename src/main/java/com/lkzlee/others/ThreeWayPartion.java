package com.lkzlee.others;

import java.util.Arrays;

/***
 * @author:lkzlee
 * @date: 2018/2/28 16:49
 * @Desc: 荷兰国旗颜色问题
 */
public class ThreeWayPartion
{
	public void three_way_partion(int[] nums, int midVal)
	{
		int lt = 0, gt = nums.length - 1;
		int i = lt;
		while (i <= gt)
		{
			if (nums[i] < midVal)
			{
				swap(nums, i, lt);
				i++;
				lt++;
			}
			else if (nums[i] > midVal)
			{
				swap(nums, i, gt);
				gt--;
			}
			else
			{
				i++;
			}
		}
	}

	/***
	 * 荷兰国旗问题原型 0 ：红色 1 白色 2 蓝色
	 * @param nums
	 */
	public void sortColors(int[] nums)
	{
		int pleft = 0;
		int p = 0;
		int pright = nums.length - 1;
		while (p <= pright)
		{
			if (nums[p] == 0)
				swap(nums, pleft++, p++);
			else if (nums[p] == 1)
				++p;
			else //if(nums[p] == 2)
				swap(nums, p, pright--);
		}
	}

	private void swap(int[] nums, int i, int lt)
	{
		int t = nums[i];
		nums[i] = nums[lt];
		nums[lt] = t;
	}

	public static void main(String[] args)
	{
		int[] nums = { 1, 4, 2, 3, 9, 6, 8, 7, 5 };
		new ThreeWayPartion().three_way_partion(nums, 6);
		System.out.println(Arrays.toString(nums));
	}
}

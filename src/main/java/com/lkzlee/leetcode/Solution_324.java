package com.lkzlee.leetcode;

import com.lkzlee.algorithm.sort.QuickSort;

import java.util.Arrays;

/***
 * @author:lkzlee
 * @date: 2018/2/27 17:07
 * @Desc:
 * Wiggle Sort II
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 * 该题的意思是一个无序数组，处理后需要保证中间位置大于两边相邻的数
 * 思路：
 * 1.这道题比较low逼的做法是先排序，然后从中间切分两部分，前半部分和后半部分，每次取后半部分一个，前半部分一个，
 * 该算法并不能保证o(n)的时间复杂度，所以只是一个初级算法。
 */
public class Solution_324
{
	public void wiggleSort(int[] nums)
	{
		lowBiSolution(nums);
	}

	public void lowBiSolution(int[] nums)
	{
		QuickSort.quickSort(nums, 0, nums.length - 1);
		int mid = (nums.length - 1) / 2;
		int[] newArr = new int[nums.length];
		int k = 0;
		int i = mid, j = nums.length - 1;
		for (; i >= 0 & j > mid; i--, j--)
		{
			newArr[k++] = nums[i];
			newArr[k++] = nums[j];
		}
		if (j <= mid && i >= 0)
		{
			newArr[k] = nums[i];
		}
		else if(j>mid)
		{
			newArr[k] = nums[j];
		}
		for (i = 0; i < nums.length; i++)
		{
			nums[i] = newArr[i];
		}
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 1, 5, 1, 1, 6, 4 };

		new Solution_324().wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}

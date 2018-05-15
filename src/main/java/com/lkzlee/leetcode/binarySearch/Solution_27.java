package com.lkzlee.leetcode.binarySearch;

import java.util.Arrays;

/***
 * @author:lkzlee
 * @date: 2018/3/10 17:48
 * @Desc:移除元素
 * 给定一个数组和一个值，在这个数组中原地移除指定值和返回移除后新的数组长度。
 * 不要为其他数组分配额外空间，你必须使用 O(1) 的额外内存原地修改这个输入数组。
 * 元素的顺序可以改变。超过返回的新的数组长度以外的数据无论是什么都没关系。
 * 示例:给定 nums = [3,2,2,3]，val = 3，
 * 你的函数应该返回 长度 = 2，数组的前两个元素是 2。
 * 思路：此题做法十分简单，可以采用partion类似的思路，不相等的扔到前面，相等的扔到后面，并用o(1)的空间复杂度记录长度
 * 切记对于新数组长度的计数从后边计数（本人重复计数了，swap的时候也做计数了，后续思考清楚改为这种才合理了）
 * while (low <= high && nums[high] == val)
 * {	high--;
 * 		nlens--;
 * }
 *
 */
public class Solution_27
{
	public int removeElement(int[] nums, int val)
	{
		if (nums == null || nums.length <= 0)
			return 0;
		int nlens = nums.length;
		int low = 0;
		int high = nums.length - 1;
		while (low <= high)
		{
			while (low <= high && nums[high] == val)
			{
				high--;
				nlens--;
			}
			while (low <= high && nums[low] != val)
				low++;
			if (low < high)
			{
				swap(nums, low, high);
			}
		}
		return nlens;
	}

	private void swap(int[] nums, int i, int lt)
	{
		int t = nums[i];
		nums[i] = nums[lt];
		nums[lt] = t;
	}

	public static void main(String[] args)
	{
		int[] nums = { 3, 2, 2, 3 };
		int lens = new Solution_27().removeElement(nums, 3);
		System.out.println(lens);
		System.out.println(Arrays.toString(nums));
	}
}

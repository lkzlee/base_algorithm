package com.lkzlee.leetcode.array;

import java.util.Arrays;

/***
 * @author:lkzlee
 * @date: 2018/10/8 18:25
 * @Desc:
 *
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 *
 * 示例 1:
 *
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 说明:  n 的范围为 [1, 10,000]。
 */
public class Solution_665
{
	public boolean checkPossibility(int[] nums)
	{
		/***
		 * 该题的解题思路，判断nums[i],nums[i+1]大小关系，如果出现递减，则改为最小的数，
		 * 关键是要判断num[i]=nums[i+1],还是nums[i+1]=nums[i]，
		 *
		 * 一般情况下，nums[i]>nums[i+1]出现一次，nums[i-1]< nums[i]>nums[i+1]只需要更改 nums[i]=nums[i+1]
		 * 因为存在一种特殊情况i>1,nums[i-1]= nums[i] > nums[i+1]，此时就需要更改nums[i+1]=nums[i]
		 *
		 */
		int cnt = 0;
		for (int i = 0; i < nums.length - 1 && cnt <= 2; i++)
		{
			if (nums[i] <= nums[i + 1])
				continue;
			cnt++;
			if (i >= 1 && nums[i - 1] > nums[i + 1])
				nums[i + 1] = nums[i];
			else
				nums[i] = nums[i + 1];
		}

		return cnt <= 1;
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 2, 3, 3, 2, 4 };
		System.out.println(Arrays.toString(nums));
		boolean rs = new Solution_665().checkPossibility(nums);
		System.out.println(rs);
		System.out.println(Arrays.toString(nums));
	}
}

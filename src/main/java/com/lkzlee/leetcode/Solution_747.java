package com.lkzlee.leetcode;

/***
 * @author:lkzlee
 * @date: 2018/4/2 16:44
 * @Desc:在一个给定的数组nums中，总是存在一个最大元素 。
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 如果是，则返回最大元素的索引，否则返回-1。
 * 示例 1:
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *
 * 示例 2:
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 */
public class Solution_747
{
	public int dominantIndex(int[] nums)
	{
		if (nums == null || nums.length <= 0)
			return -1;
		int maxVal = nums[0];
		int maxIndex = 0;
		for (int i = 1; i < nums.length; i++)
		{
			if (maxVal < nums[i])
			{
				maxVal = nums[i];
				maxIndex = i;
			}
		}
		for (int i = 0; i < nums.length; i++)
		{

			if (i != maxIndex && (2 * nums[i]) > maxVal)
				return -1;
		}
		return maxIndex;
	}

	public static void main(String[] args)
	{
		int[] m = { 3, 6, 1, 0 };
		int p = new Solution_747().dominantIndex(m);
		System.out.println(p);
		int[] m1 = { 1, 2, 3, 4 };
		int p1 = new Solution_747().dominantIndex(m1);
		System.out.println(p1);
	}
}

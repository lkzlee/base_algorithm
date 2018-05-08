package com.lkzlee.leetcode;

/***
 * @author:lkzlee
 * @date: 2018/5/8 20:50
 * @Desc:给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * 示例 1:
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 */
public class Solution_540
{
	public int singleNonDuplicate(int[] nums)
	{
		/***
		 * 这个题有两种做法，一种O(n)时间复杂度，也算比较低的，用异或,
		 * 这个主要适用于无序查找（编程之美中有），题目中提到了有序数组，这个未用到这个条件,属于比较low的方案
		 */
		//		return findNumberXoR(nums);
		/***
		 * 第二个方案需要用到数组坐标的奇偶性，举个例子，1，1，2，3，3，4，4，8，8
		 * 整体的数据是奇数个元素，并且是有序的
		 * 这个从下标0开始重复的都是偶数位，从下标8开始倒数重复的也是都偶数个元素的。
		 * 最终的思路是，求出mid=l+(h-l)/2,
		 * 如果mid是（下标从0开始）偶数，mid与mid+1相同，则前半部分都是成对出现，反之，则后半部分是成对出现的。这样便可以不断缩小范围
		 * 时间复杂度o(log n)
		 */
		if (nums == null || nums.length <= 0)
			return -1;
		int l = 0, h = nums.length - 1;
		while (l < h)
		{
			int mid = l + (h - l) / 2;
			if ((mid%2) == 1) //从偶数位开始判定，做修正
				mid--;
			if (nums[mid] == nums[mid + 1])
				l = mid + 2;
			else
				h = mid;

		}
		return nums[l];
	}

	private int findNumberXoR(int[] nums)
	{
		int x = 0;
		for (int t : nums)
		{
			x ^= t;
		}
		return x;
	}

	public static void main(String[] args)
	{
		int t = new Solution_540().singleNonDuplicate(new int[] {  1, 1,2 });
		System.out.println(t);
	}

}

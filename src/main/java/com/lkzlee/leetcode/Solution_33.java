package com.lkzlee.leetcode;

/***
 * @author:lkzlee
 * @date: 2018/2/26 17:22
 * @Desc:假设按照升序排序的数组在预先未知的某个关键点上旋转。
 * （即 0 1 2 4 5 6 7 将变成 4 5 6 7 0 1 2）。
 * 给你一个目标值来搜索，如果数组中存在这个数则返回它的索引，否则返回 -1。
 * 你可以假设数组中不存在重复。
 * 思路：二分查找，但是存在旋转的可能，所以先找出左边有序还是右边有序，然后二分查找
 */
public class Solution_33
{
	public int search(int[] nums, int target)
	{
		if (nums == null || nums.length <= 0)
		{
			return -1;
		}
		int low = 0;
		int high = nums.length - 1;
		while (low < high)
		{
			int mid = (low + high) / 2;
			if (nums[mid] == target)
			{
				return mid;
			}
			//左边升序,这个等号很特殊，对于3，1 和1的输入刚好可以处理，去掉就不过了
			if (nums[mid] >= nums[low])
			{
				if (target < nums[mid] && target >= nums[low])
				{
					high = mid - 1;
				}
				else
				{
					low = mid + 1;
				}

			}
			else //右边升序
			{
				if (target > nums[mid] && target <= nums[high])
				{
					low = mid + 1;
				}
				else
				{
					high = mid - 1;
				}
			}
		}
		if (target == nums[low])
		{
			return low;
		}
		if (target == nums[high])
		{
			return high;
		}
		return -1;
	}

	public static void main(String[] args)
	{
		int[] a = { 3, 1 };
		int index = new Solution_33().search(a, 1);
		System.out.println(index);
	}
}

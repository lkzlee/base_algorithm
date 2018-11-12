package com.lkzlee.leetcode;

/***
 * @author:lkzlee
 * @date: 2018/11/12 20:41
 * @Desc:
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Solution_33
{
	public int search(int[] nums, int target)
	{
		if (nums == null || nums.length <= 0)
			return -1;
		int low = 0, high = nums.length - 1;
		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] == nums[low])
				low++;
			else if (nums[low] < nums[mid])
			{
				if (nums[low] <= target && nums[mid] > target)
					high = mid - 1;
				else
					low = mid + 1;
			}
			else
			{
				if (nums[mid] < target && nums[high] >= target)
					low = mid + 1;
				else
					high = mid - 1;

			}
		}
		return -1;
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 4,5,6,7,0,1,2 };
		int rs = new Solution_33().search(nums, 7);
		System.out.println(rs);
	}
}

package com.lkzlee.leetcode;

/***
 * @author:lkzlee
 * @date: 2018/11/12 20:19
 * @Desc:
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 *
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 */
public class Solution_81
{
	/***
	 * 二分法思路
	 * 暂且不考虑nums[mid] = nums[left]的情况，本题大致可以简化为上图两种情况，可能的情况划分出来，那么解决本题就比较容易了：
	 * 当 nums[mid] = nums[left] 时，这时由于很难判断 target 会落在哪，那么只能采取 left++
	 *
	 * 当 nums[mid] > nums[left] 时，这时可以分为两种情况，判断左半部比较简单
	 *
	 * 当 nums[mid] < nums[left] 时，这时可以分为两种情况，判断右半部比较简单
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public boolean search(int[] nums, int target)
	{
		if (nums == null || nums.length <= 0)
			return false;
		int low = 0, high = nums.length - 1;
		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return true;
			else if (nums[low] == nums[mid])
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
		return false;
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 3, 1, 1 };
		boolean rs = new Solution_81().search(nums, 3);
		System.out.println(rs);
	}

}

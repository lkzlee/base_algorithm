package com.lkzlee.leetcode;

/***
 * @author:lkzlee
 * @date: 2018/5/10 16:18
 * @Desc:假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * (例如，数组 [0, 1, 2, 4, 5, 6, 7] 可能变为 [4, 5, 6, 7, 0, 1, 2])。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * 示例 1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 * 思路：如果旋转数组本身是有序的，是二分法的变形
 * 1. 如果元素mid大于high(说明mid...high是无序的)，则low=mid+1
 */
public class Solution_153
{
	public int findMin(int[] nums)
	{
		int low = 0, high = nums.length - 1;
		while (low < high)
		{
			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[high])
				low = mid + 1;
			else
				high = mid;
		}
		return nums[high];
	}

	public static void main(String[] args)
	{
		int[] arr={3,4,5,1,2};
		System.out.println(new Solution_153().findMin(arr));
	}
}

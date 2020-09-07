package com.lkzlee.leetcode.binarySearch;

import java.util.Arrays;

/***
 * @author:lkzlee
 * @date: 2018/5/10 16:46
 * @Desc:给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class Solution_34 {
    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length <= 0)
            return new int[]{-1, -1};
        int s = binarySearch(nums, target);
        int t = binarySearch(nums, target + 1) - 1;

        if (s == nums.length || nums[s] != target)
            return new int[]{-1, -1};
        return new int[]{s, Math.max(s, t)};
    }

    public static void main(String[] args) {
        int[] nums = {5, 5, 7, 7, 8, 8, 10};
        int[] rs = new Solution_34().searchRange(nums, 5);
        System.out.println(Arrays.toString(rs));
    }
}

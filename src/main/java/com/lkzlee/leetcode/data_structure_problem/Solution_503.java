package com.lkzlee.leetcode.data_structure_problem;

import sun.security.util.ArrayUtil;

import java.util.*;

/***
 * @author: lkzlee
 * @date: 2020-09-01 09:11
 * @desc:
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 *
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 */
public class Solution_503 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length <= 0) return new int[]{};
        int[] ret = new int[nums.length];
        Arrays.fill(ret, -1);
        //normalSovle(nums, ret, map);
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }

    private void normalSovle(int[] nums, int[] ret, Map<Integer, Integer> map) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    map.put(i, nums[j]);
                    break;
                }
            }
            if (map.containsKey(i)) continue;
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    map.put(i, nums[j]);
                    break;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(i)) {
                ret[i] = map.get(i);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 1, 11, 1, 120, 111, 123, 1, -1, -100};
        int[] rs = new Solution_503().nextGreaterElements(nums);
        System.out.println(Arrays.toString(rs));
        //[120,11,120,120,123,123,-1,100,100,100]
    }
}






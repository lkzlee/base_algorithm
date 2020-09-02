package com.lkzlee.leetcode.data_structure_problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/***
 * @author: lkzlee
 * @date: 2019-10-29 17:14
 * @desc:给定两个没有重复元素的数组 nums1 和 nums2 ，
 * 其中nums1 是 nums2 的子集。找到 nums1 中每个元素在nums2中的下一个比其大的值。
 *
 * nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。
 * 如果不存在，对应位置输出-1。
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 *     对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 *     对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于num1中的数字2，第二个数组中的下一个较大数字是3。
 *     对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 注意:
 *
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length <= 0) {
            return new int[]{};
        }
        int[] ret = new int[nums1.length];
        Arrays.fill(ret, -1);
        if (nums2 == null || nums2.length <= 0) return ret;
        //s1ForMe(nums1, nums2, ret);
        s2ForLeet(nums1, nums2, ret);
        return ret;
    }

    private void s2ForLeet(int[] nums1, int[] nums2, int[] ret) {
        Stack<Integer> stack=new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int n:nums2){
            while (!stack.isEmpty()&&n>stack.peek()){
                map.put(stack.pop(),n);
            }
            stack.add(n);
        }
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])) ret[i]=map.get(nums1[i]);
        }
    }

    private void s1ForMe(int[] nums1, int[] nums2, int[] ret) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < nums2.length; j++) {
            map.put(nums2[j], j);
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = map.get(nums1[i]) + 1; j < nums2.length; j++) {
                if(nums2[j]>nums1[i]){
                    ret[i]=nums2[j];
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{4, 1, 2};
        int[] num2 = new int[]{1, 3, 4, 2};
        int[] rs = new Solution_496().nextGreaterElement(num1, num2);
        System.out.println(Arrays.toString(rs));
    }
}

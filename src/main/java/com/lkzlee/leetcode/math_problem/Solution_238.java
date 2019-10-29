package com.lkzlee.leetcode.math_problem;

import java.util.Arrays;

/***
 * @author: lkzlee
 * @date: 2019-10-29 15:12
 * @desc:给定长度为 n 的整数数组 nums，其中 n > 1，
 * 返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 0) return new int[]{};
        int[] ret = new int[nums.length];
        //这个的思路是从左右两边分别计算乘积，然后进行相乘就是最后结果
        ret[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ret[i] = ret[i - 1] * nums[i - 1];  //这个计算的是从0...i-1 的左边乘积(不包含nums[i])
        }
        int right = 1;//right的值为从i+1....n的乘积
        for (int i = nums.length - 1; i >= 0; i--) {
            ret[i] = ret[i] * right; //
            right *= nums[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] rs = new Solution_238().productExceptSelf(nums);
        System.out.println(Arrays.toString(rs));
    }
}

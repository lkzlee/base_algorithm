package com.lkzlee.leetcode.math_problem;

import java.util.Arrays;

/***
 * @author: lkzlee
 * @date: 2019-10-28 15:37
 * @desc:
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，
 * 其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
 *
 * 例如:
 *
 * 输入:
 * [1,2,3]
 *
 * 输出:
 * 2
 *
 * 说明：
 * 只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）：
 *
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_462 {
    public int minMoves2(int[] nums) {
        /***
         * 这个题是一个找中位数的题，移动距离最小的方式是所有元素都移动到中位数，
         * 找到中位数求出所有与中位数的abs（diff）和就是最小移动距离
         * 设 m 为中位数。a 和 b 是 m 两边的两个元素，且 b > a。要使 a 和 b 相等，
         * 它们总共移动的次数为 b - a，
         * 这个值等于 (b - m) + (m - a)，也就是把这两个数移动到中位数的移动次数。
         */
        if (nums == null || nums.length <= 0) return 0;
        Arrays.sort(nums);
        int mid = (nums.length - 1) / 2;
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret += Math.abs(nums[i] - nums[mid]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 4, 5, 2, 2, 3};
        int rs = new Solution_462().minMoves2(nums);
        System.out.println(rs);
    }
}

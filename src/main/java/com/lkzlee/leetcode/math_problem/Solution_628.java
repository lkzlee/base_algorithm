package com.lkzlee.leetcode.math_problem;

import com.lkzlee.leetcode.DP_problem.Solution_62;

import java.util.Arrays;

/***
 * @author: lkzlee
 * @date: 2019-10-28 17:17
 * @desc:给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_628 {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        //这个题第一反应找出三个最大数，相乘即可
        //不过有负数的存在，有以下情况：
        //全是非负数；
        //全是非正数；
        //既有非负数也有负数。
        //
        //对于前两种情况最大值取在最大的三个数。
        //
        // 最后的一种情况如果只有一个负数，那么取最大的三个数；
        // 有两个负数及以上最大值一定非负，不可能取3个负，最大值要么取两个负数一个非负数，
        // 或者三个非负数，这样一来最大值要么一个最大非负数+两个最小负数，或者最大的三个数。
        //————————————————
       /* Arrays.sort(nums);
        int m1 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        int m2 = nums[0] * nums[1] * nums[nums.length - 1];
        if (m1 > m2 ) return m1;
        return m2;*/
        //还有第二种解法，和第一种类似，不过找出最大的三个数，和最小的2个数做乘积比较即可，不需要排序
        int m1 = Integer.MIN_VALUE;
        int m2 = Integer.MIN_VALUE;
        int m3 = Integer.MIN_VALUE;
        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (m1 < nums[i]) {
                m3 = m2;
                m2 = m1;
                m1 = nums[i];
            } else if (m2 < m1 && m2 < nums[i]) {
                m3 = m2;
                m2 = nums[i];
            } else if (m3 < m2 && m3 < nums[i]) m3 = nums[i];
            if (n1 > nums[i]) {
                n2 = n1;
                n1 = nums[i];
            } else if (n2 > n1 && n2 > nums[i]) n2 = nums[i];
        }
        int rs1 = m1 * m2 * m3;
        int rs2 = n1 * n2 * m1;
        return rs1 > rs2 ? rs1 : rs2;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int rs = new Solution_628().maximumProduct(nums);
        System.out.println(rs);
    }
}

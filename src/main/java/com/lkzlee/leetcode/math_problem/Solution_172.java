package com.lkzlee.leetcode.math_problem;

/***
 * @author: lkzlee
 * @date: 2019-10-28 15:05
 * @desc:给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_172 {
    /***
     * 尾部的 0 由 2 * 5 得来，2 的数量明显多于 5 的数量，因此只要统计有多少个 5 即可。
     *
     * 对于一个数 N，它所包含 5 的个数为：N/5 + N/52 + N/53 + ...，其中 N/5 表示不大于 N 的数中 5 的倍数贡献一个 5，N/52 表示不大于 N 的数中 52 的倍数再贡献一个 5 ...。
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        int rs = new Solution_172().trailingZeroes(8);
        System.out.println(rs);
    }
}

package com.lkzlee.leetcode.math_problem;

/***
 * @author: lkzlee
 * @date: 2019-10-28 16:45
 * @desc:给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 示例 1:
 * 输入: 27
 * 输出: true
 * 示例 2:
 * 输入: 0
 * 输出: false
 * 示例 3:
 * 输入: 9
 * 输出: true
 * 示例 4:
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_326 {
    public boolean isPowerOfThree(int n) {
       /* int i = 1;
        for (; i < n; i *= 3) ;
        return i == n;*/
        //如果题目是2的次方，可以用特别的做法：
        // 用二进制的方法，2的N次幂的特点：仅有首位为1，其余各位都为0。（ n & n-1 == 0）
        //对数的方法：一个数是3的次方，那么以3为底n的对数一定是个 整数。
        double rs = Math.log10(n) / Math.log10(3);
        return (rs - (int) rs) == 0;
    }

    public static void main(String[] args) {
        boolean rs = new Solution_326().isPowerOfThree(27);
        System.out.println(rs);
    }
}

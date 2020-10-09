package com.lkzlee.leetcode;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/10/9 14:18
 * @desc: 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 16
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_342 {
    public boolean isPowerOfFour(int num) {
        int rs = 1;
        while (rs <= num && rs > 0) {
            if (rs == num) return true;
            rs = rs << 2;
        }
        return false;

       // return Integer.toString(num, 4).matches("10*");
    }
}

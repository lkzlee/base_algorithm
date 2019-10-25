package com.lkzlee.leetcode.math_problem;

/***
 * @author: lkzlee
 * @date: 2019-10-23 11:08
 * @desc:给定一个整数，将其转化为7进制，并以字符串形式输出。
 *
 * 示例 1:
 *
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/base-7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_504 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean ifNegative = false;
        if (num < 0) {
            ifNegative = true;
            num = -num;
        }
        while (num > 0) {
            sb.insert(0, num % 7);
            num = num / 7;
        }
        if (ifNegative) {
            sb.insert(0, '-');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String rs = new Solution_504().convertToBase7(-7);
        System.out.println(rs);
    }
}

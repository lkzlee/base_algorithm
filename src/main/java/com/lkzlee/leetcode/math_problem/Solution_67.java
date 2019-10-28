package com.lkzlee.leetcode.math_problem;

/***
 * @author: lkzlee
 * @date: 2019-10-28 15:12
 * @desc:给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_67 {
    public String addBinary(String a, String b) {
        if (a == null || b == null || a.length() <= 0 || b.length() <= 0) {
            return "";
        }
        int jin = 0;
        StringBuilder rs = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            int ts = a.charAt(i) - '0' + b.charAt(j) - '0' + jin;
            if (ts == 2) {
                jin = 1;
                ts = 0;
            } else if (ts == 3) {
                jin = 1;
                ts = 1;
            } else {
                jin = 0;
            }
            rs.insert(0, (char) (ts + '0'));
        }
        for (; i >= 0; i--) {
            int ts = a.charAt(i) - '0' + jin;
            if (ts == 2) {
                jin = 1;
                ts = 0;
            } else {
                jin = 0;
            }
            rs.insert(0, (char) (ts + '0'));
        }
        for (; j >= 0; j--) {
            int ts = b.charAt(j) - '0' + jin;
            if (ts == 2) {
                jin = 1;
                ts = 0;
            } else {
                jin = 0;
            }
            rs.insert(0, (char) (ts + '0'));
        }
        if (jin == 1) {
            rs.insert(0, '1');
        }
        return rs.toString();
    }

    public static void main(String[] args) {
        String rs = new Solution_67().addBinary("1010", "1011");
        System.out.println(rs);
    }
}

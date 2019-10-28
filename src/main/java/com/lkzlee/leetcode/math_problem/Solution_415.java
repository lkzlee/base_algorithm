package com.lkzlee.leetcode.math_problem;

/***
 * @author: lkzlee
 * @date: 2019-10-28 15:27
 * @desc:给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_415 {
    public String addStrings(String num1, String num2) {
        if ((num1 == null || num1.length() <= 0) && (num2 == null || num2.length() <= 0)) return "";
        if (num1 == null || num1.length() <= 0) return num2;
        if (num2 == null || num2.length() <= 0) return num1;
        int i = num1.length() - 1, j = num2.length() - 1;
        int jin = 0;
        StringBuffer sb = new StringBuffer();
        for (; i >= 0 && j >= 0; i--, j--) {
            int chr = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + jin;
            sb.insert(0, (char) (chr % 10 + '0'));
            jin = chr / 10;
        }
        for (; i >= 0; i--) {
            int chr = (num1.charAt(i) - '0') + jin;
            sb.insert(0, (char) (chr % 10 + '0'));
            jin = chr / 10;
        }
        for (; j >= 0; j--) {
            int chr = (num2.charAt(j) - '0') + jin;
            sb.insert(0, (char) (chr % 10 + '0'));
            jin = chr / 10;
        }
        if (jin == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String rs = new Solution_415().addStrings("1234", "456");
        System.out.println(rs);
    }
}

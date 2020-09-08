package com.lkzlee.leetcode.data_structure_problem;

/***
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 *
 * 提示：
 *
 * 输入的字符串长度不会超过 1000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_647 {
    public int countSubstrings(String s) {
        if (s == null || s.length() <= 0) return 0;
        int cRet = 0;
        //该题的解题思路是从当前位置i开始进行扩展回文串
        for (int i = 0; i < s.length(); i++) {
            cRet += expandPanlindom(s, i, i); //奇数扩展
            cRet += expandPanlindom(s, i, i + 1); //偶数位扩展
        }
        return cRet;
    }

    //从start-end开始扩展判断回文数
    private int expandPanlindom(String s, int start, int end) {
        int cnt = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            cnt++;
            start--;
            end++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s="aaa";
        int rs=new Solution_647().countSubstrings(s);
        System.out.println(rs);
    }
}

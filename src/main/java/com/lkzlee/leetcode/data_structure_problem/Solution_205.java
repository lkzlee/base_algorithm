package com.lkzlee.leetcode.data_structure_problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.isEmpty() && t.isEmpty()) return true;
        if (s.isEmpty() || t.isEmpty()) return false;
        if (s.length() != t.length()) return false;
        int[] cnt = new int[256];
        int[] cnt2 = new int[256];
        Arrays.fill(cnt, -1);
        Arrays.fill(cnt2, -1);
        for (int i = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)] != cnt2[t.charAt(i)]) {
                return false;
            }
            cnt[s.charAt(i)] = i;
            cnt2[t.charAt(i)] = i;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg", t = "add";
        boolean rs = new Solution_205().isIsomorphic(s, t);
        System.out.println(rs);
    }
}

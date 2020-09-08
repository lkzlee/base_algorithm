package com.lkzlee.leetcode.data_structure_problem;

import java.util.Arrays;

/***
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_242 {
    /***
     * 解题思路
     * 字符串只包含小写字符，总共有 26 个小写字符。可以用 Hash Table 来映射字符与出现次数，
     * 因为键值范围很小，因此可以使用长度为 26 的整型数组对字符串出现的字符进行统计，比较两个字符串出现的字符数量是否相同。
     */
    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[26];
        Arrays.fill(cnt, 0);
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            cnt[t.charAt(j) - 'a']--;
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

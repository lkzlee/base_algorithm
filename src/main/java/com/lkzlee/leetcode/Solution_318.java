package com.lkzlee.leetcode;

import java.util.Arrays;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/10/9 15:18
 * @desc: 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 * <p>
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 * <p>
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_318 {
    public int maxProduct(String[] words) {
        if (words == null || words.length <= 0) return 0;
        int[] mark = new int[words.length];
        Arrays.fill(mark, 0);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                mark[i] = mark[i] | 1 << (words[i].charAt(j) - 'a');
            }
        }
        int maxVal = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((mark[i] & mark[j]) == 0) {
                    maxVal = Math.max(words[i].length() * words[j].length(), maxVal);
                }
            }
        }
        return maxVal;
    }
}

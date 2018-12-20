package com.lkzlee.leetcode.DP_problem;

import java.util.ArrayList;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/12/18 10:45
 * @Desc:
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class Solution_139
{
	public boolean wordBreak(String s, List<String> wordDict)
	{
		if (s == null || s.length() <= 0)
			return false;
		/***
		 * 第一种思路我用了回溯法（DFS），但是不满足时间要求TLE
		 */
		//		return backTrack(s, wordDict);
		/***
		 * 第二种是动态规划的思路
		 * dp[i]表示前i个字符能不能被dict完美划分
		 */

		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++)
		{
			for (String w : wordDict)
			{
				if (w.length() > i)
					continue;
				if (!w.equals(s.substring(i - w.length(), i)))
					continue;
				dp[i] = dp[i] || dp[i - w.length()];
			}
		}
		return dp[s.length()];

	}

	private boolean backTrack(String s, List<String> wordDict)
	{
		if (s == null || s.length() <= 0)
			return true;
		for (String w : wordDict)
		{
			if (s.length() < w.length())
				continue;
			if (!s.startsWith(w))
				continue;
			boolean rs = backTrack(s.substring(w.length()), wordDict);
			if (rs)
				return true;
		}
		return false;
	}

	public static void main(String[] args)
	{
		String s = "applepenapple";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("apple");
		wordDict.add("pen");

		boolean rs = new Solution_139().wordBreak(s, wordDict);
		System.out.println(rs);
	}
}

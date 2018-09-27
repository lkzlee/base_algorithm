package com.lkzlee.leetcode;

import java.util.ArrayList;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/9/27 15:06
 * @Desc:
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，
 * 该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。
 * 如果答案不存在，则返回空字符串。
 * 示例 1:
 * 输入:
 *
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * 输出:
 *
 * "apple"
 *
 * 示例 2:
 *
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 *
 * 输出:
 * "a"
 *
 * 说明:
 * 所有输入的字符串只包含小写字母。
 *
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 */
public class Solution_524
{
	public String findLongestWord(String s, List<String> d)
	{
		if (d == null || d.size() <= 0 || s == null || s.length() <= 0)
			return "";
		String longestWord = "";
		for (String t : d)
		{
			int l1 = longestWord.length();
			int l2 = t.length();
			if (l1 > l2 || (l1 == l2 && longestWord.compareTo(t) < 0))
				continue;
			if (isValidPattern(s, t))
			{
				longestWord = t;
			}
		}
		return longestWord;
	}

	private boolean isValidPattern(String s, String t)
	{
		int i = 0;
		int j = 0;
		while (i < s.length() && j < t.length())
		{
			char c1 = s.charAt(i);
			char c2 = t.charAt(j);
			if (c1 == c2)
			{
				j++;
			}
			i++;
		}
		if (j == t.length())
			return true;
		return false;
	}

	public static void main(String[] args)
	{

		List<String> list = new ArrayList<>();
		list.add("ale");
		list.add("apple");
		list.add("monkey");
		list.add("plea");
		String rs = new Solution_524().findLongestWord("abpcplea", list);
		System.out.println(rs);
	}
}

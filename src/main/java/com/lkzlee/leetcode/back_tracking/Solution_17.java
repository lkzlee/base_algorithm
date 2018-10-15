package com.lkzlee.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/10/12 10:22
 * @Desc:
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Solution_17
{
	private final static String[] keys = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
			"wxyz" };

	public List<String> letterCombinations(String digits)
	{
		List<String> list = new ArrayList<>();
		if (digits == null || digits.length() <= 0)
			return list;
		doCombination(new StringBuilder(), digits, list);
		return list;
	}

	private void doCombination(StringBuilder rs, String digits, List<String> list)
	{
		if (digits == null || digits.length() <= 0)
		{
			list.add(rs.toString());
			return;
		}

		int index = digits.charAt(0) - '0';
		String key = keys[index];
		for (int j = 0; j < key.length(); j++)
		{
			rs.append(key.charAt(j));
			doCombination(rs, digits.substring(1), list);
			rs.deleteCharAt(rs.length() - 1);
		}

	}

	public static void main(String[] args)
	{
		List<String> rs = new Solution_17().letterCombinations("23");
		System.out.println(rs);
	}
}

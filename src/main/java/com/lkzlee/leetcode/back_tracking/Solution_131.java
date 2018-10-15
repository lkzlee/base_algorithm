package com.lkzlee.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/10/15 15:00
 * @Desc:
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class Solution_131
{
	public List<List<String>> partition(String s)
	{
		List<List<String>> list = new ArrayList<>();
		if (s == null || s.length() <= 0)
			return list;
		List<String> tempList = new ArrayList<>();
		doPartion(s, tempList, list);
		return list;
	}

	private void doPartion(String s, List<String> tempList, List<List<String>> list)
	{
		if (s == null || s.length() == 0)
		{
			List<String> rsList = new ArrayList<>();
			rsList.addAll(tempList);
			list.add(rsList);
			return;
		}
		for (int i = 0; i < s.length(); i++)
		{
			String tmp = s.substring(0, i + 1);
			if (!isPanlindrome(tmp))
				continue;
			tempList.add(tmp);
			doPartion(s.substring(i + 1), tempList, list);
			tempList.remove(tempList.size() - 1);
		}
	}

	private boolean isPanlindrome(String tmp)
	{
		int i = 0, j = tmp.length()-1;
		while (i < j)
		{
			if (tmp.charAt(i) != tmp.charAt(j))
			{
				return false;
			}
			i++;
			j--;
		}
		return true;

	}

	public static void main(String[] args)
	{
		List<List<String>> rs = new Solution_131().partition("aab");
		System.out.println(rs);
	}
}

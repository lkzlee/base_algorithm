package com.lkzlee.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * @author:lkzlee
 * @date: 2018/2/24 17:43
 * @Desc: Partition Labels 切分子串,尽可能多地切分子串使得该子串中包含字符，确保每个部分的字母不在别的部分出现
 */
public class Solution_763
{
	public List<Integer> partitionLabels(String S)
	{
		List<Integer> list = new ArrayList<Integer>();
		Set<Character> set = new HashSet<Character>();
		int lens = 0;
		for (int i = 0; i < S.length(); i++)
		{

			char ch = S.charAt(i);
			set.add(ch);
			lens++;
			if (set.size() > 0 && !isContainS(S, i + 1, set))
			{
				list.add(lens);
				set.clear();
				lens = 0;
			}

		}
		return list;
	}

	private boolean isContainS(String s, int i, Set<Character> set)
	{
		if (set == null || set.size() <= 0)
		{
			throw new RuntimeException("set error");
		}
		for (char ch : set)
		{
			if (s.indexOf(ch, i) >= 0)
			{
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args)
	{
		String S = "ababcbacadefegdehijhklij";
		List<Integer> t = new Solution_763().partitionLabels(S);
		System.out.println(t);
	}

}

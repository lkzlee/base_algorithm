package com.lkzlee.leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * @author:lkzlee
 * @date: 2018/9/27 17:43
 * @Desc:给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * */
public class Solution_451
{
	public String frequencySort(String s)
	{

		if (s == null || s.length() <= 0)
			return s;
		/***
		 * solution——347的方式是能用的
		 */
		Map<Character, Integer> frMaps = new HashMap<>();
		for (int i = 0; i < s.length(); i++)
		{
			char ch = s.charAt(i);
			frMaps.put(ch, frMaps.getOrDefault(ch, 0) + 1);
		}
		List<Character>[] bucket = new List[s.length() + 1];
		for (Character ch : frMaps.keySet())
		{
			if (bucket[frMaps.get(ch)] == null)
			{
				bucket[frMaps.get(ch)] = new ArrayList<>();
			}
			bucket[frMaps.get(ch)].add(ch);
		}
		StringBuffer sb = new StringBuffer();
		for (int i = bucket.length - 1; i >= 0; i--)
		{
			if (bucket[i] != null)
			{
				List<Character> chList = bucket[i];
				for (Character ch : chList)
				{
					for (int j = 0; j < i; j++)
					{
						sb.append(ch); //添加同样的字符多少个
					}
				}

			}
		}
		return sb.toString();
	}

	public static void main(String[] args)
	{
		String rs=new Solution_451().frequencySort("Aabb");
		System.out.println(rs);
	}
}

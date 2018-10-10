package com.lkzlee.leetcode.BFS_DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * @author:lkzlee
 * @date: 2018/10/10 18:09
 * @Desc:
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord * 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class Solution_127
{
	public int ladderLength(String beginWord, String endWord, List<String> wordList)
	{
		int minLens = 0;
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		boolean[] mark = new boolean[wordList.size()];
		Arrays.fill(mark, false);
		while (!queue.isEmpty())
		{
			int size = queue.size();
			minLens++;
			while (size-- > 0)
			{
				String bw = queue.poll();
				for (int i = 0; i < wordList.size(); i++)
				{
					String ew = wordList.get(i);
					if (bw.equals(endWord))
						return minLens;
					if (mark[i])
						continue;
					if (isDirectGo(bw, ew))
					{
						queue.add(ew);
						mark[i] = true;
					}
				}
			}
		}
		return 0;

	}

	private boolean isDirectGo(String begin, String end)
	{
		int i = 0;
		int j = 0;
		int cnt = 0;
		while (i < begin.length() && j < end.length())
		{
			if (begin.charAt(i) != end.charAt(j))
				cnt++;
			i++;
			j++;
		}
		return cnt == 1;
	}

	public static void main(String[] args)
	{
		String[] words = new String[] { "hot", "dot", "dog", "lot", "log","cog" };
		int rs = new Solution_127().ladderLength("hit", "cog", Arrays.asList(words));
		System.out.println(rs);
	}
}

package com.lkzlee.leetcode.greedy;

import java.util.Stack;

/***
 * @author:lkzlee
 * @date: 2018/11/13 10:14
 * @Desc:
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class Solution_402
{
	public String removeKdigits(String num, int k)
	{
		if (num == null || num.length() <= 0)
			return num;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < num.length(); i++)
		{
			Character p = num.charAt(i);
			while (!stack.isEmpty() && stack.peek() > p && k > 0)
			{
				stack.pop();
				k--;
			}
			stack.push(p);
		}
		while (!stack.isEmpty() && k > 0)
		{
			stack.pop();
			k--;
		}
		int offset = 0; //找到第一个非0位置。
		while (offset < stack.size() && stack.get(offset) == '0')
			offset++;
		StringBuffer sb = new StringBuffer(num.length());
		for (int i = offset; i < stack.size(); i++)
		{
			Character ch = stack.get(i);
			sb.append(ch);
		}
		System.out.println(sb);
		if (sb.length() <= 0)
			return "0";
		return sb.toString();
	}

	public static void main(String[] args)
	{
		String num = "9";
		String rs = new Solution_402().removeKdigits(num, 1);
		System.out.println(rs);
	}
}

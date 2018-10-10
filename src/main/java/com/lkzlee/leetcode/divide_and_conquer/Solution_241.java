package com.lkzlee.leetcode.divide_and_conquer;

import java.util.ArrayList;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/10/9 16:11
 * @Desc:
 *
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
 * 你需要给出所有可能的组合的结果。* 有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 *
 * 输入: "2-1-1"
 * 输出: [0, 2]
 *
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * 示例 2:
 *
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 *
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class Solution_241
{
	public List<Integer> diffWaysToCompute(String input)
	{
		if (input == null || "".equals(input))
			return null;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < input.length(); i++)
		{
			char ch = input.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*')
			{
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1));
				for (int l : left)
				{
					for (int r : right)
					{
						switch (ch)
						{
							case '+':
								list.add(l + r);
								break;
							case '-':
								list.add(l - r);
								break;
							case '*':
								list.add(l * r);
								break;
						}
					}
				}

			}
		}
		if (list.size() == 0)
			list.add(Integer.parseInt(input));
		return list;
	}

	public static void main(String[] args)
	{
		String str = "2*3-4*5";
		List<Integer> rs = new Solution_241().diffWaysToCompute(str);
		System.out.println(rs);
	}
}

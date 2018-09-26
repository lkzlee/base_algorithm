package com.lkzlee.leetcode;

/***
 * @author:lkzlee
 * @date: 2018/9/26 18:21
 * @Desc:编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 *
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 *
 * 原音字母有哪些（这个早忘了）？
 * a e i o u
 *
 * 解题思路：双指针
 */
public class Solution_345
{
	public String reverseVowels(String s)
	{
		if (s == null || "".equals(s))
			return s;
		char[] str = s.toCharArray();
		int i = 0, j = str.length - 1;
		while (i <= j)
		{
			boolean y1 = isYuan(str[i]);
			boolean y2 = isYuan(str[j]);
			if (!y1)
			{
				i++;
			}
			if (!y2)
			{
				j--;
			}
			if (y1 && y2)
			{
				char tmp = str[i];
				str[i] = str[j];
				str[j] = tmp;
				i++;
				j--;
			}

		}
		return new String(str);
	}

	private boolean isYuan(char ch)
	{

		if (ch == 'a' || ch == 'A' ||
				ch == 'e' || ch == 'E' ||
				ch == 'i' || ch == 'I' ||
				ch == 'o' || ch == 'O' ||
				ch == 'u' || ch == 'U')
			return true;
		return false;
	}

	public static void main(String[] args)
	{
		String rs = new Solution_345().reverseVowels("leetcode");
		System.out.println(rs);
	}

}

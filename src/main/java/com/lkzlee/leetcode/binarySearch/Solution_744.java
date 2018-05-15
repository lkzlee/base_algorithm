package com.lkzlee.leetcode.binarySearch;

/***
 * @author:lkzlee
 * @date: 2018/5/8 20:12
 * @Desc:给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 * 示例:
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 *
 *  输入:
 *  letters = ["c", "f", "j"]
 *  target = "j"
 *  输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 */
public class Solution_744
{
	public char nextGreatestLetter(char[] letters, char target)
	{
		int l = 0, h = letters.length - 1;
		if (letters[0] > target || letters[h] <= target)
			return letters[0];
		while (l < h)
		{
			int mid = l + (h - l) / 2;
			if (letters[mid] <= target)
				l = mid + 1;
			else
				h = mid;
		}
		return letters[h];
	}

	public static void main(String[] args)
	{
		char ch = new Solution_744().nextGreatestLetter(new char[] { 'e', 'e', 'e','e','n','n','n','n' }, 'f');
		System.out.println(ch);
	}
}

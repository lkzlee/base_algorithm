package com.lkzlee.leetcode;

import com.lkzlee.leetcode.datastructure.ListNode;

/***
 * @author:lkzlee
 * @date: 2018/4/2 17:45
 * @Desc:给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 进阶:
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 示例:
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
public class Solution_445
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		if (l1 == null || l2 == null)
			return null;
		if (l1.val == 0)
			return l2;
		if (l2.val == 0)
			return l1;
		int lens1 = getListNodeLens(l1);
		int lens2 = getListNodeLens(l2);
		ListNode t1 =

	}

	private int getListNodeLens(ListNode l1)
	{
		if (l1 == null)
			return 0;
		int lens = 0;
		while (l1 != null)
		{
			lens++;
			l1 = l1.next;
		}
		return lens;
	}
}

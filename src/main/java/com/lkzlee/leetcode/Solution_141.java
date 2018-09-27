package com.lkzlee.leetcode;

import com.lkzlee.leetcode.datastructure.ListNode;

/***
 * @author:lkzlee
 * @date: 2018/9/27 14:59
 * @Desc:给定一个链表，判断链表中是否有环。
 * 进阶：
 * 你能否不使用额外空间解决此题？
 */
public class Solution_141
{
	public boolean hasCycle(ListNode head)
	{
		if (head == null)
			return false;
		ListNode p1 = head;
		ListNode p2 = head.next;
		while (p1 != null && p2 != null)
		{
			if (p1 == p2)
				return true;
			p1 = p1.next;
			p2 = p2.next;
			if (p2 != null)
				p2 = p2.next;

		}
		return false;
	}

	public static void main(String[] args)
	{

	}
}

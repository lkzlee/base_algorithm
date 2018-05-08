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
		/***
		 * 第一种算法，链表逆转,然后进行想加
		 */
		l1 = reverseList(l1);
		l2 = reverseList(l2);
		//		printListNode(l1);
		//		printListNode(l2);
		ListNode rs = new ListNode(-1);
		int ifJin = 0;
		while (l1 != null && l2 != null)
		{
			int v = l1.val + l2.val + ifJin;
			if (v < 10)
			{
				ifJin = 0;
			}
			else
			{
				ifJin = 1;
				v = v - 10;
			}
			ListNode t = rs.next;
			ListNode vNode = new ListNode(v);
			rs.next = vNode;
			vNode.next = t;
			l1 = l1.next;
			l2 = l2.next;
		}
		ifJin = addListNode(l2, rs, ifJin);
		ifJin = addListNode(l1, rs, ifJin);
		if (ifJin > 0)
		{
			ListNode vNode = new ListNode(1);
			ListNode t = rs.next;
			rs.next = vNode;
			vNode.next = t;
		}
		return rs.next;
	}

	private int addListNode(ListNode ln, ListNode p, int ifJin)
	{
		while (ln != null)
		{
			int v = ln.val + ifJin;
			if (v < 10)
			{
				ifJin = 0;
			}
			else
			{
				ifJin = 1;
				v = v - 10;
			}
			ListNode t = p.next;
			ListNode vNode = new ListNode(v);
			p.next = vNode;
			vNode.next = t;
			ln = ln.next;
		}
		return ifJin;
	}

	private void printListNode(ListNode l1)
	{
		while (l1 != null)
		{
			System.out.print(l1.val);
			l1 = l1.next;
			if (l1 != null)
				System.out.print("-->");
			else
				System.out.println();
		}
	}

	private ListNode reverseList(ListNode l)
	{
		if (l == null)
			return null;
		ListNode t1 = new ListNode(-1);
		while (l != null)
		{
			ListNode p = l.next;
			l.next = t1.next;
			t1.next = l;
			l = p;
		}
		return t1.next;
	}

	public static void main(String[] args)
	{
		ListNode ln1 = new ListNode(7);
		ListNode p = ln1;
		p.next = new ListNode(2);
		p = p.next;
		p.next = new ListNode(4);
		p = p.next;
		p.next = new ListNode(3);
		p = p.next;
		p.next = new ListNode(5);

		ListNode ln2 = new ListNode(9);
		p = ln2;
		p.next = new ListNode(0);
		p = p.next;
		p.next = new ListNode(2);
		p = p.next;
		p.next = new ListNode(7);

		ListNode r = new Solution_445().addTwoNumbers(ln1, ln2);
		new Solution_445().printListNode(r);
	}

}

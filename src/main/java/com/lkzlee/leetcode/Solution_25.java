package com.lkzlee.leetcode;

import com.lkzlee.leetcode.datastructure.ListNode;

/***
 * @author:lkzlee
 * @date: 2018/11/15 10:37
 * @Desc:
 *
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution_25
{
	public ListNode reverseKGroup(ListNode head, int k)
	{
		if (k == 0 || head == null || head.next == null)
			return head;
		ListNode p, q;
		int idx = 1;
		p = new ListNode(-1);
		p.next = head;
		q = head;
		head = p;
		while (q != null)
		{
			if (idx == k)
			{
				ListNode h = q.next;
				ListNode pre = p.next;
				p.next = reverseList(p.next, q.next);
				pre.next = h;
				p = pre;
				q = h;
				idx = 1;
			}
			else
			{
				q = q.next;
				idx++;
			}
		}
		return head.next;
	}

	private ListNode reverseList(ListNode l, ListNode q)
	{
		if (l == null)
			return l;
		ListNode head = new ListNode(-1);

		while (l != q)
		{
			ListNode p = l.next;
			l.next = head.next;
			head.next = l;
			l = p;

		}
		return head.next;
	}

	public static void printList(ListNode head)
	{
		while (head != null)
		{
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		printList(head);
		ListNode rs = new Solution_25().reverseKGroup(head, 3);
		printList(rs);
	}
}

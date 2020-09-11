package com.lkzlee.leetcode.linklist;

import com.lkzlee.leetcode.datastructure.ListNode;

import java.util.List;

/***
 *
 */
public class Solution_160 {
    //设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
    //
    //当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部开始访问链表 B；
    // 同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部开始访问链表 A。
    // 这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p = (p == null) ? headB : p.next;
            q = (q == null) ? headA : q.next;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        ListNode head2 = new ListNode(1);
        ListNode rs = new Solution_160().getIntersectionNode(head1, head2);
        System.out.println(rs);

    }
}

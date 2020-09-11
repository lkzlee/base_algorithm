package com.lkzlee.leetcode.linklist;

import com.lkzlee.leetcode.datastructure.ListNode;

import java.util.HashMap;
import java.util.List;

/***
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode p = head, t = head.next;

        while (t != null) {
            if (p.val == t.val) {
                p.next = t.next;
                t = t.next;
            } else {
                p = t;
                t = t.next;
            }
        }
        return newHead.next;
    }

    public static void pringListNode(ListNode head) {
        while (head != null) {
            if (head.next != null) {
                System.out.print(head.val + "-->");
            } else {
                System.out.println(head.val);
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        pringListNode(head);
        ListNode rs = new Solution_83().deleteDuplicates(head);
        pringListNode(rs);
    }
}

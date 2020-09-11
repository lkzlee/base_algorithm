package com.lkzlee.leetcode.linklist;

import com.lkzlee.leetcode.datastructure.ListNode;

/***
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        int len = getListNodeLen(head);
        int cnt = 0;
        ListNode newHead = new ListNode(-1);
        ListNode p = head;
        //前半部分进行reverse
        while (p != null && cnt < len / 2) {
            cnt++;
            ListNode tmp = p.next;
            p.next = newHead.next;
            newHead.next = p;
            p = tmp;
        }
        if (len % 2 != 0) p = p.next;
        ListNode t = newHead.next;
        //两部分进行比较
        while (p != null && t != null) {
            if (p.val != t.val) return false;
            p = p.next;
            t = t.next;
        }
        return true;
    }

    private int getListNodeLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
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
//        ListNode h = new ListNode(1);
//        h.next = new ListNode(2);
//        h.next.next = new ListNode(2);
//        h.next.next.next = new ListNode(4);
//        pringListNode(h);
        boolean rs = new Solution_234().isPalindrome(null);
        System.out.println(rs);
    }
}

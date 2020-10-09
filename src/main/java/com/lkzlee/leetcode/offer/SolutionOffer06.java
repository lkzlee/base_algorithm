package com.lkzlee.leetcode.offer;

import com.lkzlee.leetcode.datastructure.ListNode;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/10/9 16:43
 * @desc: 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionOffer06 {
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[]{};
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        int[] rs = new int[len];
        p = head;
        while (p != null) {
            rs[len - 1] = p.val;
            p = p.next;
            len--;
        }
        return rs;
    }
}

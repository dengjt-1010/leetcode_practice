package com.department.deng.list;

import com.department.deng.base.ListNode;

/**
 * Created by deng on 19-4-12.
 * <p>
 * 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class TwoItemSwap {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode current = result;
        while (current.next != null && current.next.next != null) {
            ListNode tmp = current.next.next;
            current.next.next = current.next.next.next;
            tmp.next = current.next;
            current.next = tmp;
            current = current.next.next;
        }
        return result.next;
    }
}

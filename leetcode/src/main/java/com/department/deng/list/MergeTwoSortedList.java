package com.department.deng.list;

import com.department.deng.base.ListNode;

/**
 * Created by deng on 19-4-12.
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode p1 = l1, p2 = l2, current = result;

        while (p1 != null || p2 != null) {
            if (p1 == null) {
                current.next = p2;
                current = current.next;
                p2 = p2.next;
            } else if (p2 == null) {
                current.next = p1;
                current = current.next;
                p1 = p1.next;
            } else {
                if (p1.val < p2.val) {
                    current.next = p1;
                    current = current.next;
                    p1 = p1.next;
                } else {
                    current.next = p2;
                    current = current.next;
                    p2 = p2.next;
                }
            }
        }

        return result.next;
    }

}

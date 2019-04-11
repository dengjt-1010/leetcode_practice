package com.department.deng.array;

import com.department.deng.base.ListNode;

/**
 * Created by deng on 19-3-22.
 */
public class TwoNumSum2 {
/*
给出两个 非空 的链表用来表示两个非负的整数。
其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
[2,4,3]
[5,6,4]
 */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result=new ListNode(0);
        ListNode p1=l1,p2=l2,current=result;

        int next = 0;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                current.next = new ListNode((p2.val + next) % 10);
                current = current.next;
                next = (p2.val + next) >= 10 ? 1 : 0;
                p2 = p2.next;
            } else if (p2 == null) {
                current.next = new ListNode((p1.val + next) % 10);
                current = current.next;
                next = (p1.val + next) >= 10 ? 1 : 0;
                p1 = p1.next;

            }else {
                int temp = p1.val + p2.val;
                current.next = new ListNode(((temp + next) % 10));
                next = (temp + next) >= 10 ? 1 : 0;
                current = current.next;
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        if (next != 0) {
            current.next = new ListNode(next);
        }
        return result.next;
    }
}

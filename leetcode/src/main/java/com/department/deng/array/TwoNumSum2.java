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

        int grow = 0;
        while (p1 != null || p2 != null) {
            int val = (p1 != null ? p1.val : 0) + (p2 != null ? p2.val : 0) + grow;

            ListNode born = new ListNode(val % 10);

            grow = val / 10;

            current.next = born;
            current = current.next;

            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;
        }

        if (grow != 0) {
            ListNode born = new ListNode(grow);
            current.next = born;
        }
        return result.next;
    }
}

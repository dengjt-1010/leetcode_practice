package com.department.deng.list;

import com.department.deng.base.ListNode;

/**
 * Created by deng on 19-4-11.
 * 删除链表中倒数第N个节点
 */
public class DeleteLastNNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode result = new ListNode(0);
        result.next = head;

        ListNode first = result;
        ListNode second = result;

        int step = 0;
        while (first.next != null) {
            if (step >= n) {
                second = second.next;
            }
            step++;
            first = first.next;
        }
        if (second != result) {
            ListNode ne = second.next.next;
            second.next.next = null;
            second.next = ne;
        }
        return result.next;
    }


    public static void main(String[] args) {
        ListNode result1 = new ListNode(1);
        ListNode result2 = new ListNode(2);
        ListNode result3 = new ListNode(3);
        ListNode result4 = new ListNode(4);
        ListNode result5 = new ListNode(5);
//        result1.next=result2;
//        result2.next=result3;
//        result3.next=result4;
//        result4.next=result5;

        DeleteLastNNode deleteLastNNode = new DeleteLastNNode();
        deleteLastNNode.removeNthFromEnd(result1, 1);

    }
}

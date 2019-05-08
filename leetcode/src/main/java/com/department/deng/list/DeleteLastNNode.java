package com.department.deng.list;

import com.department.deng.base.ListNode;

/**
 * Created by deng on 19-4-11.
 * 19. 删除链表的倒数第N个节点
 */
public class DeleteLastNNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        if (n == 1 && head.next == null) {
            return null;
        }

        ListNode result = new ListNode(0);
        result.next = head;

        ListNode first = result;
        ListNode second = result;

        while (n > 0 && first.next != null) {
            n--;
            first = first.next;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        if (second != null) {
            ListNode nextNext = second.next.next;
            second.next.next = null;
            second.next = nextNext;

        }

        return result.next;
    }


    public static void main(String[] args) {
        ListNode result1 = new ListNode(1);
        ListNode result2 = new ListNode(2);
        ListNode result3 = new ListNode(3);
        ListNode result4 = new ListNode(4);
        ListNode result5 = new ListNode(5);
        result1.next = result2;
//        result2.next=result3;
//        result3.next=result4;
//        result4.next=result5;

        DeleteLastNNode deleteLastNNode = new DeleteLastNNode();
        deleteLastNNode.removeNthFromEnd(result1, 1);

    }
}

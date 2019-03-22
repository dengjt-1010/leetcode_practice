package com.department.deng.array;

import com.department.deng.base.ListNode;

/**
 * Created by deng on 19-3-22.
 */
public class TwoNumSum2 {
/*
[2,4,3]
[5,6,4]
 */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result=new ListNode(0);
        ListNode p1=l1,p2=l2,current=result;

        int nextGrow=0;
        while (p1!=null||p2!=null){
            int sum=(p1!=null?p1.val:0)+(p2!=null?p2.val:0)+nextGrow;
            if(sum>=10){
                nextGrow=1;
                sum%=10;
            }else {
                nextGrow=0;
            }

            current.next=new ListNode(sum);
            current=current.next;
            p1=p1!=null?p1.next:null;
            p2=p2!=null?p2.next:null;
        }

        if(nextGrow==1){
            current.next=new ListNode(nextGrow);
        }
        return result.next;
    }
}

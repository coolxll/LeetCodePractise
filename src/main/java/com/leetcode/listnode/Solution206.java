package com.leetcode.listnode;

import com.leetcode.helper.ListNode;

public class Solution206 {

//    public ListNode reverseList(ListNode head) {
//        if(head == null || head.next == null) return head; //单个节点的也无需反转
//        ListNode prev = null,curr = head;
//        while(curr != null) {
//            ListNode next = curr.next; //作用域可以缩小至括号内
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
//    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head; //单个节点的也无需反转
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
        
    }
}

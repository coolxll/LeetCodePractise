package com.leetcode.listnode;

import com.leetcode.helper.ListNode;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = new ListNode(0),curr,next;
        pre.next = head;
        ListNode dummyNode = pre;
        for (int i = 0; i < left - 1; i++) { //move to start node
            pre = pre.next;
        }
        curr = pre.next;
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}

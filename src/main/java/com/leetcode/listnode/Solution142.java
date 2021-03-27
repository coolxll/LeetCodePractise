package com.leetcode.listnode;

import com.leetcode.helper.ListNode;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast=head;
        while(fast!=null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return detectStartCycle(slow,head);
            }
        }
        return null;
    }

    private ListNode detectStartCycle(ListNode meet, ListNode head) {
        ListNode slow=meet,fast=head;
        while(slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

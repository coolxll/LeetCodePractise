package com.leetcode.listnode;

import com.leetcode.helper.ListNode;
import com.leetcode.helper.ListNodeHelper;
import org.junit.Test;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow=dummy,fast=head;
        for(int i=0;i<n;i++) {
            fast = fast.next;
        }
//        if(fast == null) { //fast 指向尾结点 说明要删除head
//            head = head.next;
//            return head;
//        }
        while(fast!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode listNode = removeNthFromEnd(ListNodeHelper.stringToListNode("[1,2,3,5]"), 3);
        System.out.println(ListNodeHelper.listNodeToString(listNode));
    }

    @Test
    public void test1() {
        ListNode listNode = removeNthFromEnd(ListNodeHelper.stringToListNode("[1,2]"), 2);
        System.out.println(ListNodeHelper.listNodeToString(listNode));
    }
}

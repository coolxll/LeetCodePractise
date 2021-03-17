package com.leetcode.listnode;

import com.leetcode.helper.ListNode;
import com.leetcode.helper.ListNodeHelper;
import org.junit.Test;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int count = 0;
        ListNode curr = head, newHead = head;
        while(count < k && curr != null) {
            curr = curr.next;
            count++;
        }
        if(count == k) {
            newHead = reverseList(head, curr);
            head.next = reverseKGroup(curr, k);

        }
        return newHead;
    }

    public ListNode reverseList(ListNode head, ListNode tail) {
        if(head == null || head.next == null) return head; //单个节点的也无需反转
        ListNode curr = head, prev = null, next;
        while(curr != tail) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    @Test
    public void test() {
        ListNode listNode = ListNodeHelper.stringToListNode("[1,2,3,4,5]");
        ListNode listNode1 = reverseKGroup(listNode, 2);
        System.out.println(ListNodeHelper.listNodeToString(listNode1));
    }

    @Test
    public void test1() {
        ListNode listNode = ListNodeHelper.stringToListNode("[1,2,3,4,5]");
        ListNode listNode1 = reverseKGroup(listNode, 3);
        System.out.println(ListNodeHelper.listNodeToString(listNode1));
    }

    @Test
    public void test2() {
        ListNode listNode = ListNodeHelper.stringToListNode("[1,2]");
        ListNode listNode1 = reverseKGroup(listNode, 2);
        System.out.println(ListNodeHelper.listNodeToString(listNode1));
    }
}

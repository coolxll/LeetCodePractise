package com.leetcode.listnode;

import com.leetcode.helper.ListNode;
import com.leetcode.helper.ListNodeHelper;
import org.junit.Test;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = mergeListNode(list1, list2);
        return sorted;
    }

    public ListNode mergeListNode(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if(temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next; //Important, do not forget
        }
        if(temp1 != null) {
            temp.next = temp1;
        } else if(temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    public ListNode sortInList(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        for (int i = 1; i < length; i <<= 1) { //相当于 i *= 2
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int j = 1; j < i && curr.next != null; j++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null; //队列1的tail
                curr = head2;
                for (int j = 1; j < i && curr != null && curr.next != null; j++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = mergeListNode(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    @Test
    public void test() {
        ListNode sortList = sortInList(ListNodeHelper.stringToListNode("[1,3,2,4,5]"));
        System.out.println(ListNodeHelper.listNodeToString(sortList));
    }
}


package com.leetcode.listnode;

import com.leetcode.helper.ListNode;
import com.leetcode.helper.ListNodeHelper;
import org.junit.Test;

public class Solution147 {

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0), lastSorted = head, curr = head.next;
        dummyHead.next = head;
        while(curr != null) {
            if(lastSorted.val <= curr.val) {
                lastSorted = curr;
            } else {
                ListNode prev = dummyHead;
                while(prev != lastSorted) {
                    if(prev.next.val > curr.val) {
                        lastSorted.next = curr.next;
                        curr.next = prev.next;
                        prev.next = curr;
                        break;
                    }
                    prev = prev.next;
                }
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

    @Test
    public void test() {
        ListNode sortList = insertionSortList(ListNodeHelper.stringToListNode("[4,2,1,3]"));
        System.out.println(ListNodeHelper.listNodeToString(sortList));
    }
}

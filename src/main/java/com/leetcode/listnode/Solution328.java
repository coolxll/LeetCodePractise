package com.leetcode.listnode;

import com.leetcode.helper.ListNode;
import com.leetcode.helper.ListNodeHelper;
import org.junit.Test;

public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head,oddHead = odd;
        ListNode even = new ListNode(-1),evenHead = even;
        boolean isEven = true;
        while(head != null) {
            if (isEven) {
                even.next = head.next;
                even = even.next;
            } else {
                odd.next = head.next;
                if(odd.next != null) {
                    odd = odd.next;
                }
            }
            head = head.next;
            isEven = !isEven;
        }
        odd.next = evenHead.next;
        return oddHead;
    }

    @Test
    public void test() {
        ListNode listNode = oddEvenList(ListNodeHelper.stringToListNode("[2,1,5,6,3,4,7]"));
        System.out.println(ListNodeHelper.listNodeToString(listNode));
    }

    @Test
    public void test1() {
        ListNode listNode = oddEvenList(ListNodeHelper.stringToListNode("[1,2,3,4,5]"));
        System.out.println(ListNodeHelper.listNodeToString(listNode));
    }

    @Test
    public void test2() {
        ListNode listNode = oddEvenList(ListNodeHelper.stringToListNode("[1,2,3,4,5,6,7,8]"));
        System.out.println(ListNodeHelper.listNodeToString(listNode));
    }
}

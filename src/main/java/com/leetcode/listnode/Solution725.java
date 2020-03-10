package com.leetcode.listnode;

import com.leetcode.helper.ListNode;
import com.leetcode.helper.ListNodeHelper;
import org.junit.Test;

public class Solution725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = size(root);
        int avg = length / k;
        int remain = length - avg * k; //多少份要加1
        ListNode[] result = new ListNode[k];
        ListNode dummy = root;
        ListNode newHead = dummy;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < avg - 1; j++) {
                newHead = newHead.next;
            }
            if (i < remain && avg >= 1) {
                newHead = newHead.next;
            }
            if(newHead != null) {
                ListNode tmp = newHead.next;
                newHead.next = null;
                newHead = tmp;
                result[i] = dummy; //停在头上
                dummy = newHead;
            } else {
                result[i] = null;
            }
        }
        return result;
    }

    private int size(ListNode node) {
        if(node == null) return 0;
        int cnt = 0;
        while(node != null) {
            cnt++;
            node = node.next;
        }
        return cnt;
    }
    
    @Test
    public void test() {
        ListNode[] listNodes = splitListToParts(ListNodeHelper.stringToListNode("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]"), 3);
    }

    @Test
    public void test1() {
        ListNode[] listNodes = splitListToParts(
                ListNodeHelper.stringToListNode("[1, 2, 3]"), 5);
    }

    @Test
    public void test2() {
        ListNode[] listNodes = splitListToParts(
                ListNodeHelper.stringToListNode("[1, 2, 3]"), 2);
        for (ListNode l : listNodes) {
            System.out.println(ListNodeHelper.listNodeToString(l));
        }
    }
}

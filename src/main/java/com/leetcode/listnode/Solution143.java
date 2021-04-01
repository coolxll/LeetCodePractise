package com.leetcode.listnode;

import com.leetcode.helper.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution143 {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode curr = head;
        List<ListNode> list = new ArrayList<>();
        while(curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        int l = list.size();
        int i = 0, j = l - 1;
        while(i < j) {
            list.get(i).next = list.get(j);
            i++;
            if(i == j) break;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}

package com.leetcode.listnode;

import com.leetcode.helper.ListNode;
import com.leetcode.helper.ListNodeHelper;
import org.junit.Test;

import java.util.*;

public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        if(n == 1) return lists[0];
        Deque<ListNode> middleResult = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (lists[i] != null) {
                middleResult.offer(lists[i]);
            }
        }
        while (middleResult.size() > 1) {
            ListNode listNode = mergeTwoLists(middleResult.poll(), middleResult.poll()); //成环
            middleResult.push(listNode);
        }
        return middleResult.poll();
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] listNodes,int begin,int end) {
        if(begin > end) return null;
        if(begin == end) return listNodes[begin];
        if(begin + 1 == end) return mergeTwoLists(listNodes[begin], listNodes[end]);
        final int middle = begin + (end - begin) / 2;
        ListNode left = merge(listNodes,begin, middle);
        ListNode right = merge(listNodes,middle + 1, end);
        return mergeTwoLists(left, right);
    }


    //迭代
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1!=null && l2!= null) {
            if (l1.val <= l2.val) { //等号放哪里都可以
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 == null)  {
            curr.next = l2;
        }
        if(l2 == null)  {
            curr.next = l1;
        }
        return dummy.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;
        int length = lists.length;
        for (int i = 0; i < length; i++) {
            if(lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        while(!pq.isEmpty()) {
            ans.next = pq.poll();
            ans = ans.next;
            if(ans.next != null) {
                pq.offer(ans.next);
            }
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode listNode = mergeKLists2(new ListNode[]{
                ListNodeHelper.stringToListNode("[1,4,5]"),
                ListNodeHelper.stringToListNode("[1,3,4]"),
                ListNodeHelper.stringToListNode("[2,6]"),
        });
        System.out.println(ListNodeHelper.listNodeToString(listNode));
    }

    @Test
    public void test1() {
        ListNode listNode = mergeKLists(new ListNode[]{
                ListNodeHelper.stringToListNode("[]"),
                ListNodeHelper.stringToListNode("[]"),
                ListNodeHelper.stringToListNode("[]"),
        });
        System.out.println(ListNodeHelper.listNodeToString(listNode));
    }
}

package com.leetcode.listnode;


import com.leetcode.helper.ListNode;

public class Solution21 {

    /**
     * 有序
     * @param l1
     * @param l2
     * @return
     */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1 == null)  return l2;
//        if(l2 == null)  return l1;
//        if(l1.val <= l2.val) { //等号放哪里都可以
//            l1.next = mergeTwoLists(l1.next,l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }

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
}

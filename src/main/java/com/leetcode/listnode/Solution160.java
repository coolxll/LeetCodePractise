package com.leetcode.listnode;

import com.leetcode.helper.ListNode;

public class Solution160 {
    //走完链表 走另一个链表 形成回环
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode l1 = headA, l2 = headB;
        while(l1 != l2) {
            if(l1 == null) {
                l1 = headB;
            } else {
                l1 = l1.next;
            }
            if(l2 == null) {
                l2 = headA;
            } else {
                l2 = l2.next;
            }
        }
        return l1;
    }


//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if(headA == null || headB == null) return null;
//        HashSet visited = new HashSet();
//        while(headA != null) {
//            visited.add(headA);
//            headA = headA.next;
//        }
//        while(headB != null) {
//            if(visited.contains(headB)) {
//                return headB;
//            } else {
//                headB = headB.next;
//            }
//        }
//        return null;
//    }
}

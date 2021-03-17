package com.leetcode.listnode;


import com.leetcode.helper.ListNode;
import com.leetcode.helper.ListNodeHelper;
import org.junit.Test;

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
    @SuppressWarnings("DuplicatedCode")
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

    public ListNode mergeTwoLists1 (ListNode l1, ListNode l2) {
        // write code here
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head,curr;
        ListNode i = l1, j = l2;
        if(l1.val < l2.val) {
            head = l1;
            i = i.next;
        } else {
            head = l2;
            j = j.next;
        }
        curr = head;
        while(i != null || j != null) {
            if(i == null) {
                curr.next = j;
                break;
            }
            if(j == null) {
                curr.next = i;
                break;
            }
            if(i.val < j.val) {
                curr.next = i;
                i = i.next;
                curr = curr.next;
            } else {
                curr.next = j;
                j = j.next;
                curr = curr.next;
            }
        }
        return head;
    }

    @Test
    public void test() {
        ListNode listNode = ListNodeHelper.stringToListNode("[1,4,5]");
        ListNode listNode1 = ListNodeHelper.stringToListNode("[2]");
        ListNode listNode2 = mergeTwoLists1(listNode, listNode1);
        System.out.println(ListNodeHelper.listNodeToString(listNode2));
    }
}

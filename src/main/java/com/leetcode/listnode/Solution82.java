package com.leetcode.listnode;

import com.leetcode.helper.ListNode;

public class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        //因为头结点也可能被删除，所以加入哑节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while(curr.next != null && curr.next.next != null) {
            //删除节点要在前一个节点进行操作比较方便
            if(curr.next.val == curr.next.next.val) {
                int x = curr.next.val;
                while(curr.next != null && curr.next.val == x) {
                    deleteNode(curr); //删除节点之后相当于自动往后遍历了
                }
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }

    /**
     * Delete Node's next node
     */
    private void deleteNode(ListNode node) {
        node.next = node.next.next;
    }
}

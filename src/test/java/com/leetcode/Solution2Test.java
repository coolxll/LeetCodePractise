package com.leetcode;

import com.leetcode.helper.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class Solution2Test {

    @Test
    public void addTwoNumbers() {
        Solution2 solution2 = new Solution2();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = solution2.addTwoNumbers(l1, l2);
        Assert.assertEquals(listNode.val, 7);
        Assert.assertEquals(listNode.next.val, 0);
        Assert.assertEquals(listNode.next.next.val,8);
    }
}
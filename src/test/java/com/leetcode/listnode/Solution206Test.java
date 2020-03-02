package com.leetcode.listnode;

import com.leetcode.helper.ListNode;
import com.leetcode.helper.ListNodeHelper;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution206Test {

    @Test
    public void reverseList() {
        Solution206 solution206 = new Solution206();
        ListNode listNode = ListNodeHelper.stringToListNode("[1,2,3]");
        ListNode reverseList = solution206.reverseList(listNode);
        System.out.println(ListNodeHelper.listNodeToString(reverseList));
    }
}
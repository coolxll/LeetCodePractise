package com.leetcode.helper;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return ListNodeHelper.listNodeToString(this);
    }
}

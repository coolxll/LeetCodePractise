package com.leetcode.listnode;

import com.leetcode.helper.ListNode;
import com.leetcode.helper.ListNodeHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution234 {

    private ListNode frontPointer;

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false;
            if (currentNode.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        if(head == null || head.next == null) return true; //先判断特殊情况，0个或1个元素
        //快慢指针遍历
        ListNode slow = head, fast=head; //slow 1步 fast 两步
        Deque<Integer> deque = new ArrayDeque<>();
        while(fast != null && fast.next != null) {
            deque.offer(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            int top = deque.pollLast();
            if (slow.val != top) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null) return true; //先判断特殊情况，0个或1个元素
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result & p2 != null) {
            if(p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    @Test
    public void test() {
        boolean palindrome = isPalindrome1(ListNodeHelper.stringToListNode("[0,0]"));
        Assert.assertTrue(palindrome);
    }

    @Test
    public void test1() {
        boolean palindrome = isPalindrome1(ListNodeHelper.stringToListNode("[1,2,2,1]"));
        Assert.assertTrue(palindrome);
    }
}

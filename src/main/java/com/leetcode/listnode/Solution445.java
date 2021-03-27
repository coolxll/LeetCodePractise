package com.leetcode.listnode;

import com.leetcode.helper.ListNode;
import com.leetcode.helper.ListNodeHelper;
import org.junit.Test;

import java.util.Stack;

public class Solution445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = reverseNode(l1),n2= reverseNode(l2);
        ListNode dummyHead = new ListNode(0),curr = dummyHead;
        int carry = 0;
        while(n1 != null || n2 != null) {
            int x = (n1 != null) ? n1.val : 0;
            int y = (n2 != null) ? n2.val : 0;
            int sum = x + y + carry;
            carry = sum/10; //其实carry最多是1，because of x,y is (0,9)
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(n1!=null) n1 = n1.next;
            if(n2!=null) n2 = n2.next;
        }
        if(carry != 0) {
            curr.next = new ListNode(carry);
        }
        return reverseNode(dummyHead.next);
    }

    private ListNode reverseListNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    private ListNode reverseNode(ListNode node) {
        if(node == null || node.next == null) return node;
        ListNode prev = null, cur = node, next;
        while(cur!=null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        int carry = 0;

        while(head1 != null) {
            s1.push(head1.val);
            head1 = head1.next;
        }
        while(head2 != null) {
            s2.push(head2.val);
            head2 = head2.next;
        }
        while(!s1.empty() || !s2.empty()) {
            int x = s1.empty() ? 0 :s1.pop();
            int y = s2.empty() ? 0 :s2.pop();
            int sum = x + y + carry;
            carry = sum / 10;
            s3.push(sum % 10);
        }
        if(carry > 0) s3.push(carry);
        ListNode dummy = new ListNode(0),curr = dummy;
        while(!s3.empty()) {
            curr.next = new ListNode(s3.pop());
            curr = curr.next;
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode l1 = ListNodeHelper.stringToListNode("[7,2,4,3]");
        ListNode l2 = ListNodeHelper.stringToListNode("[5,6,4]");
        ListNode addTwoNumbers = addInList(l1, l2);
        System.out.println(ListNodeHelper.listNodeToString(addTwoNumbers));

    }

    @Test
    public void test1() {
        ListNode l1 = ListNodeHelper.stringToListNode("[5]");
        ListNode l2 = ListNodeHelper.stringToListNode("[5]");
        ListNode addTwoNumbers = addTwoNumbers(l1, l2);
        System.out.println(ListNodeHelper.listNodeToString(addTwoNumbers));
    }
}

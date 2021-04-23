package com.leetcode.minih;

import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2 {

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String nodeList1 = input.nextLine();
        String nodeList2 = input.nextLine();
        ListNode head1 = transStringToListNode(nodeList1);
        ListNode head2 = transStringToListNode(nodeList2);
        ListNode merged = mergeTwoList(head1,head2);
        System.out.println(listNodeToString(merged));
    }

    private static ListNode transStringToListNode(String str) {
        ListNode dummyNode = new ListNode(0),curr = dummyNode;
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens()) {
            curr.next = new ListNode(Integer.parseInt(st.nextToken()));
            curr = curr.next;
        }
        return dummyNode.next;
    }


    private static ListNode transStringArrayToListNode(String[] strArr) {
        ListNode head, curr;
        if(strArr.length > 0) {
            head = new ListNode(Integer.parseInt(strArr[0]));
        } else {
            head = null;
        }
        curr = head;
        for(int i=1;i<strArr.length;i++) {
            curr.next = new ListNode(Integer.parseInt(strArr[i]));
            curr = curr.next;
        }
        return head;
    }

    public static ListNode mergeTwoList(ListNode head1, ListNode head2) {
        ListNode curr1 = head1, curr2 = head2;
        ListNode dummy = new ListNode(0), result = dummy;
        while(curr1 != null && curr2 != null) {
            if(curr1.val <= curr2.val) {
                result.next = curr1;
                curr1 = curr1.next;
                result = result.next;
            } else {
                result.next = curr2;
                curr2 = curr2.next;
                result = result.next;
            }
        }
        if(curr1 != null) {
            result.next = curr1;
        } else {
            result.next = curr2;
        }

        return dummy.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        while (node != null) {
            result.append(node.val).append(" ");
            node = node.next;
        }
        return result.substring(0, result.length() - 1);
    }

    @Test
    public void test() {
        ListNode head1 = transStringArrayToListNode("1,2,3,4,5".split(","));
        ListNode head2 = transStringArrayToListNode("2,3,4,5,6".split(","));
        ListNode merged = mergeTwoList(head1,head2);
        System.out.println(listNodeToString(merged));
    }
}

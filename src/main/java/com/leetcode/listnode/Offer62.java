package com.leetcode.listnode;

import com.leetcode.helper.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class Offer62 {


    public int joseph(int n, int m) {
        // write code here
        //填充环形链表
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i=1;i<n;i++) {
            cur.next = new ListNode(i+1);
            cur = cur.next;
        }
        cur.next = head;
        ListNode dummy = new ListNode(0); //dummy node;
        dummy.next = head;
        cur = dummy;

        while(cur.next != cur) {
            int count = m - 1;
            while(count > 0) {
                cur = cur.next;
                count--;
            }
//            log.info("Remove Node {}",cur.next.val);
            removeNode(cur);
        }
        return cur.val;
    }

    private void removeNode(ListNode node) { //remove node.next
        node.next = node.next.next;
    }

    @Test
    public void test() {
        int joseph = joseph(5, 3);
        log.info("{}",joseph);
    }
}

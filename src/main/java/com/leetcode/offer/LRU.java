package com.leetcode.offer;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class LRU {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        // write code here
        LRUCache lruCache = new LRUCache(k);
        ArrayList<Integer> output = new ArrayList<>();
        for (int[] arr : operators) {
            int operator = arr[0];
            switch (operator) {
                case 1:
                    int key = arr[1];
                    int value = arr[2];
                    lruCache.put(key, value);
                    break;
                case 2:
                    key = arr[1];
                    value = lruCache.get(key);
                    output.add(value);
                    break;
            }
        }
        int[] result = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            result[i] = output.get(i);
        }
        return result;
    }

    public class LRUCache {

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
            public DLinkedNode() {}
            public DLinkedNode(int _key, int _value) {key = _key; value = _value;}

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                DLinkedNode curr = this;
                while(curr !=null) {
                    sb.append('(').append(curr.key).append(',').append(curr.value).append(')').append("<->");
                    curr = curr.next;
                }
                sb.append("null");
                return sb.toString();
            }
        }

        private int capacity;

        private HashMap<Integer,DLinkedNode> cacheMap;

        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cacheMap = new HashMap<>();
            this.head = new DLinkedNode();
            this.tail = new DLinkedNode();
            head.next = tail; //head 是虚拟节点
            tail.prev = head;
        }

        public void put(int key, int value) {
            if(capacity == 0) return;
            DLinkedNode node = cacheMap.get(key);
            if (node == null) { //if not exist
                DLinkedNode newNode = new DLinkedNode(key, value);
                if (cacheMap.size() < capacity) {
                    cacheMap.put(key, newNode);
                } else {
                    cacheMap.remove(tail.prev.key);
                    cacheMap.put(key, newNode);
                    removeNode(tail.prev);
                }
                addToHead(newNode);
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        public int get(int key) {
            DLinkedNode node = cacheMap.get(key);
            if (node == null) {
                return -1;
            } else {
                moveToHead(node);
                return node.value;
            }

        }

        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }
    }


    @Test
    public void test() {
        //[[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]]
        int[][] operators = new int[][] {
                {1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}
        };
        int capacity = 3;
        int[] lru = LRU(operators, capacity);
        System.out.println(JSON.toJSONString(lru));
    }

    @Test
    public void test1() {
        int[][] operators = new int[][] {
                {1,1,0},{1,2,2},{2,1},{1,3,3},{2,2},{1,4,4},{2,1},{2,3},{2,4}
        };
        int capacity = 2;
        int[] lru = LRU(operators, capacity);
        System.out.println(JSON.toJSONString(lru));
    }
}

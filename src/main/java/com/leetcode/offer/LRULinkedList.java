package com.leetcode.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class LRULinkedList {
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
//                    System.out.println("LRU PUT:"+key+"："+value);
                        lruCache.put(key, value);
                        break;
                    case 2:
                        key = arr[1];
                        value = lruCache.get(key);
                        output.add(value);
//                    System.out.println("LRU GET:"+key+"："+value);
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

            private int capacity;

            public LRUCache(int capacity) {
                this.capacity = capacity;
                this.cacheMap = new HashMap<>();
                this.lruList = new LinkedList<>();
            }

            private HashMap<Integer,Integer> cacheMap;

            private LinkedList<Integer> lruList;

            public void put(int key, int value) {
                if(lruList.size() < capacity) {
                    lruList.addFirst(key);
                    cacheMap.put(key, value);
                } else { //Cache 已满
                    if(cacheMap.containsKey(key)) {
                        //需要将item放到lruList最前面
                        lruList.remove((Integer) key);
                        lruList.addFirst(key);
                        cacheMap.put(key, value);
                    } else {
                        Integer oldKey = lruList.removeLast();
                        lruList.addFirst(key);
                        cacheMap.remove(oldKey);
                        cacheMap.put(key, value);
                    }
                }

            }

            public int get(int key) {
                if(cacheMap.containsKey(key)) {
                    lruList.remove((Integer) key);
                    lruList.addFirst(key);
                    int result = cacheMap.get(key);
                    return result;
                } else {
                    return -1;
                }
            }

        }
}

package com.leetcode.offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LFUOptimize {

    public class LFUCache {
        int minFreq, capacity;
        Map<Integer, Node> key_table;
        Map<Integer, LinkedList<Node>> freq_table;

        public LFUCache(int capacity) {
            this.minFreq = 0;
            this.capacity = capacity;
            key_table = new HashMap<>();
            freq_table = new HashMap<>();
        }

        public int get(int key) {
            if(capacity == 0) return -1;
            if(!key_table.containsKey(key)) return -1;
            Node node = key_table.get(key);
            int val = node.val, freq = node.freq;
            freq_table.get(freq).remove(node);
            //如果当前freq删除后链表为空
            if (freq_table.get(freq).size() == 0) {
                freq_table.remove(freq);
                if (minFreq == freq) {
                    minFreq += 1;
                }
            }
            LinkedList<Node> list = freq_table.getOrDefault(freq + 1, new LinkedList<>());
            list.offerFirst(new Node(key, val, freq + 1));
            freq_table.put(freq + 1, list);
            key_table.put(key,freq_table.get(freq+1).peekFirst());
            return val;
        }

        public void put(int key, int value) {
            if(capacity == 0) return;
            if(!key_table.containsKey(key)) { //不含有当前key
                if (key_table.size() == capacity) { //满了，需要删除一个元素腾出空间
                    Node node = freq_table.get(minFreq).pollLast(); //删除的是链表末尾节点
                    key_table.remove(node.key);
                    if(freq_table.get(minFreq).size() == 0) {
                        freq_table.remove(minFreq);
                        minFreq += 1; //Needless
                    }
                }
                Node cache = new Node(key, value, 1);
                key_table.put(key, cache);
                LinkedList<Node> list = freq_table.getOrDefault(1, new LinkedList<>());
                list.addFirst(cache);
                freq_table.put(1, list);
                minFreq = 1;
            } else {
                Node node = key_table.get(key);
                if (freq_table.get(node.freq).size() == 0) {
                    freq_table.remove(node.freq);
                    if(minFreq == node.freq) {
                        minFreq = node.freq + 1;
                    }
                }
                freq_table.get(node.freq).remove(node);
                node.val = value;
                node.freq += 1;
                key_table.put(key,node);
                LinkedList<Node> list = freq_table.getOrDefault(node.freq, new LinkedList<>());
                list.addFirst(node);
                freq_table.put(node.freq,list);

            }
        }
    }

    public class Node {
        int key, val, freq;

        public Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }

    @Test
    public void test() {
        /**
         * ["LFUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
         * [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
         */
        String[] arr1 = new String[]{"LFUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"};
        int[][] arr2 = new int[][] {{10},{10,13},{3,17},{6,11},{10,5},{9,10},{13},{2,19},{2},{3},{5,25},{8},{9,22},{5,5},{1,30},{11},{9,12},{7},{5},{8},{9},{4,30},{9,3},{9},{10},{10},{6,14},{3,1},{3},{10,11},{8},{2,14},{1},{5},{4},{11,4},{12,24},{5,18},{13},{7,23},{8},{12},{3,27},{2,12},{5},{2,9},{13,4},{8,18},{1,7},{6},{9,29},{8,21},{5},{6,30},{1,12},{10},{4,15},{7,22},{11,26},{8,17},{9,29},{5},{3,4},{11,30},{12},{4,29},{3},{9},{6},{3,4},{1},{10},{3,29},{10,28},{1,20},{11,13},{3},{3,12},{3,8},{10,9},{3,26},{8},{7},{5},{13,17},{2,27},{11,15},{12},{9,19},{2,15},{3,16},{1},{12,17},{9,1},{6,19},{4},{5},{5},{8,1},{11,7},{5,2},{9,28},{1},{2,2},{7,4},{4,22},{7,24},{9,26},{13,28},{11,26}};

        LFUCache lfuCache = new LFUCache(arr2[0][0]);
        for (int i = 1; i < arr1.length; i++) {
            switch (arr1[i]) {
                case "put":
                    lfuCache.put(arr2[i][0],arr2[i][1]);
                    break;
                case "get":
                    lfuCache.get(arr2[i][0]);
                    break;
            }
        }
    }
}

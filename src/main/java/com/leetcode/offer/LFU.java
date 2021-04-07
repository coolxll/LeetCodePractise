package com.leetcode.offer;

import java.util.*;

public class LFU {

    /**
     * 一个缓存结构需要实现如下功能。
     * set(key, value)：将记录(key, value)插入该结构
     * get(key)：返回key对应的value值
     * 但是缓存结构中最多放K条记录，如果新的第K+1条记录要加入，就需要根据策略删掉一条记录，然后才能把新记录加入。这个策略为：在缓存结构的K条记录中，哪一个key从进入缓存结构的时刻开始，被调用set或者get的次数最少，就删掉这个key的记录；
     * 如果调用次数最少的key有多个，上次调用发生最早的key被删除
     * 这就是LFU缓存替换算法。实现这个结构，K作为参数给出
     * [要求]
     * set和get方法的时间复杂度为O(1)
     *
     * 若opt=1，接下来两个整数x, y，表示set(x, y)
     * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
     *
     * 对于每个操作2，输出一个答案
     *
     * @param operators
     * @param k
     * @return
     */
    public int[] LFU (int[][] operators, int k) {
        // write code here
        List<Integer> result = new ArrayList<>();
        LFUCache lfuCache = new LFUCache(k);
        for (int[] op : operators) {
            switch (op[0]){
                case 1:
                    lfuCache.put(op[1],op[2]);
                    break;
                case 2:
                    result.add(lfuCache.get(op[1]));
                    break;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public class LFUCache {

        //缓存容量，时间戳unixTime
        private int capacity;
        private int time;
        Map<Integer,Node> key_table;
        TreeSet<Node> S;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.time = 0;
            key_table = new HashMap<>();
            S = new TreeSet<>();
        }

        public int get(int key) {
            if(capacity == 0) return -1;
            if(!key_table.containsKey(key)) return -1;
            Node cache = key_table.get(key);
            S.remove(cache);
            //Update old cache
            cache.cnt += 1;
            cache.time = ++time;
            S.add(cache);
            key_table.put(key, cache);
            return cache.value;
        }

        public void put(int key, int value) {
            if(capacity == 0) return;
            if (!key_table.containsKey(key)) {
                if (key_table.size() == capacity) {
                    key_table.remove(S.first().key);
                    S.remove(S.first());
                }
                Node cache = new Node(1, ++time, key, value);
                key_table.put(key, cache);
                S.add(cache);
            } else {
                Node cache = key_table.get(key);
                S.remove(cache);
                cache.cnt += 1;
                cache.time = ++time;
                cache.value = value;
                S.add(cache);
                key_table.put(key, cache);
            }
        }
    }

    public class Node implements Comparable<Node> {

        int cnt, time,key, value;

        public Node(int cnt, int time, int key, int value) {
            this.cnt = cnt;
            this.time = time;
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if(obj instanceof Node) {
                Node rhs = (Node) obj;
                return this.cnt == rhs.cnt && this.time == rhs.time;
            }
            return false;
        }

        @Override
        public int compareTo(Node rhs) {
            if(this.cnt != rhs.cnt) return this.cnt - rhs.cnt;
            else {
                return this.time - rhs.time;
            }
        }

        @Override
        public int hashCode() {
            return cnt *  1000000007 + time;
        }
    }
}

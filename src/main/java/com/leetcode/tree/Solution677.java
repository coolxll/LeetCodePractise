package com.leetcode.tree;

import org.junit.Assert;
import org.junit.Test;

public class Solution677 {
    class MapSum {

        private MapSum[] children;

        private int score;

        /** Initialize your data structure here. */
        public MapSum() {
            children = new MapSum[26];
            score = 0;
        }

        public void insert(String key, int val) {
            MapSum node = this;
            for (int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                int index = ch - 'a';
                if(node.children[index] == null) {
                    node.children[index] = new MapSum();
                }
                node = node.children[index];
            }
            node.score = val;
        }

        public int sum(String prefix) {
            //先find 根节点 再dfs
            MapSum node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if(node.children[index] == null) {
                    return 0;
                }
                node = node.children[index];
            }
            return dfs(node, 0);
        }

        private int dfs(MapSum node, int ans) {
            ans += node.score;
            for(MapSum child:node.children) {
                if(child!=null) ans = dfs(child,ans);
            }
            return ans;
        }

    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

    @Test
    public void test() {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        int sum = mapSum.sum("ap");
        Assert.assertEquals(3,sum);
        mapSum.insert("app", 2);
        sum = mapSum.sum("ap");
        Assert.assertEquals(5,sum);
    }
}

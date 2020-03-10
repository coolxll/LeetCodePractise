package com.leetcode.tree;

import com.leetcode.helper.TreeHelper;
import com.leetcode.helper.TreeNode;
import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution637 {

    public List<Double> averageOfLevels(TreeNode root) {
        int i = 0;
        double cnt = 1;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            i++;
            TreeNode top = queue.poll();
            sum += top.val;
            if (i == cnt) {
                result.add(sum / cnt);
                i = 0;
                cnt *= 2;
            }
            if(top.left != null) {
                queue.offer(top.left);
            } else {
                cnt--;
            }
            if(top.right != null) {
                queue.offer(top.right);
            } else {
                cnt--;
            }
        }
        return result;
    }

    @Test
    public void test() {
        List<Double> doubles = averageOfLevels(TreeHelper.stringToTreeNode("[3,9,20,null,null,15,7]"));
        for (Double d:doubles) {
            System.out.println(d);
        }
    }
}

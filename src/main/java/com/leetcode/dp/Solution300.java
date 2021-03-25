package com.leetcode.dp;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int res = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res,dp[i]);
        }

        return res;
    }


    public int[] LIS_dp (int[] arr) {
        // write code here 递增子序列
        int n = arr.length;
        int[] dp = new int[n];
        List<Integer>[] dp_result = new List[n];
        List<Integer> result = null;
        Arrays.fill(dp,1);
        for (int i = 0; i < dp_result.length; i++) {
            dp_result[i] = new ArrayList<>();
            dp_result[i].add(arr[i]);
        }
        result = dp_result[0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        dp_result[i] = new ArrayList<>(dp_result[j]);
                        dp_result[i].add(arr[i]);
                    } else if(dp[j] + 1 == dp[i]) { //按字母序
                        List tmp = new ArrayList<>(dp_result[j]);
                        tmp.add(arr[i]);
                        if(compareTwoList(tmp,dp_result[i]) == -1) {
                            dp_result[i] = new ArrayList<>(dp_result[j]);
                            dp_result[i].add(arr[i]);
                        }
                    }
                }
            }
            if(dp_result[i].size() > result.size() || (dp_result[i].size() == result.size() && compareTwoList(dp_result[i],result) == -1)) {
                result = dp_result[i];
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int compareTwoList(List<Integer> l1, List<Integer> l2) {
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) < l2.get(i)) {
                return -1;
            } else if(l1.get(i) == l2.get(i)) {
                continue;
            } else if(l1.get(i) > l2.get(i)) {
                return 1;
            }
        }
        return 0;
    }


    public int[] LIS(int[] arr) {
        int[] top = new int[arr.length];
        int[] dp = new int[arr.length]; //包含当前最后一个的最长子序列长度
        int piles = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i]; //To Process data
            //////////
            int l = 0, r = piles;
            while(l < r) {
                int mid = l + (r - l)/2;
                if(top[mid] > num) {
                    r = mid;
                } else if (top[mid] == num) {
                    l = mid;
                    break;
                } else if (top[mid] < num) {
                    l = mid + 1;
                }
            }
            if(l == piles) piles++;
            top[l] = num;
            dp[i] = l + 1;
        }

        int[] result = new int[piles];
        for (int i = arr.length-1, j = result.length; j > 0; --i) {
            if (dp[i] == j) {
                result[--j] = arr[i];
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int len = lengthOfLIS(nums);
        Assert.assertEquals(4,len);
        System.out.println(JSON.toJSONString(LIS(nums)));
    }

    @Test
    public void test1() {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        int len = lengthOfLIS(nums);
        Assert.assertEquals(6,len);
        System.out.println(JSON.toJSONString(LIS(nums)));
    }
}

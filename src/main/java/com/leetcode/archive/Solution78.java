package com.leetcode.archive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Conan on 2017/2/12.
 *
 Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Solution78 {

    /**
     * 思路为转换为2进制，每位代表一个数字，按位与
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        int totalNum = (int) Math.pow(2, nums.length);
        List<List<Integer>> result = new ArrayList<>(totalNum);
        for(int i=0;i<totalNum;i++) {
            List<Integer> set = new LinkedList<>();
            for (int j=0; j<nums.length; j++) {
                if ((i & (1<<j)) != 0) {
                    set.add(nums[j]);
                }
            }
            result.add(set);
        }
        return result;
    }
}

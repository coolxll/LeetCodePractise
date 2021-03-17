package com.leetcode.backtracking;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/***
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * n! 种组合
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class Solution47 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(result,nums,item, visited);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> item,boolean[] visited) {
        if (item.size() == nums.length) {
            result.add(new ArrayList<>(item));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    item.add(nums[i]);
                    backtrack(result,nums,item,visited);
                    item.remove(item.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    @Test
    public void test() {
        List<List<Integer>> lists = permute(new int[]{1, 2, 3});
        System.out.println(lists);
    }
}

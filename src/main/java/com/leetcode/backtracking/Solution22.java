package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    /**
     *
     * @param ans 结果数组
     * @param cur 正在迭代的字符串Sb
     * @param open 左括号数量
     * @param close 右括号数量
     * @param max 最多括号数量（入参)
     */
    private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans,cur,open+1,close,max);
            cur.deleteCharAt(cur.length() - 1); //恢复原状
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans,cur,open,close+1,max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

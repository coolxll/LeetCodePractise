package com.leetcode.backtracking;

import org.junit.Assert;
import org.junit.Test;

public class Solution79 {

    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        int m = board.length;
        if(m == 0) return false;
        int n = board[0].length;
        if(n == 0) return false;
        boolean[][] mark = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(search(board,i,j,word,0,mark)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board,int x, int y,String word,int level,boolean[][] mark) {
        if(level == word.length()) return false;
        if(x<0 || x > board.length - 1) return false;
        if(y<0 || y > board[0].length - 1) return false;
        char c = word.charAt(level);
        if(c == board[x][y] && !mark[x][y]){
            if(level == word.length() - 1) {
                return true;
            } else {
                mark[x][y] = true;
                boolean found =  search(board,x-1,y,word,level+1,mark) ||
                        search(board,x+1,y, word,level+1,mark) ||
                        search(board, x,y-1,word,level+1,mark) ||
                        search(board,x,y+1,word,level+1,mark);
                if(!found) mark[x][y] = false;
                return found;
            }
        }
        else return false;
    }

    @Test
    public void test() {
        char[][] board = new char[][] {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        boolean exist = exist(board, "ABCCED");
        Assert.assertTrue(exist);
    }

    @Test
    public void test1() {
        char[][] board = new char[][] {{'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}};
        boolean exist = exist(board, "ABCB");
        Assert.assertFalse(exist);
    }

    @Test
    public void test2() {
        char[][] board = new char[][] {{'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}};
        boolean exist = exist(board, "ABCESEEEFS");
        Assert.assertTrue(exist);
    }
}

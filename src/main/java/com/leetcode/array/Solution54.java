package com.leetcode.array;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        Direction direction = Direction.RIGHT;
        if (matrix == null) return result;
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        if (n == 0) return result; //check null first

        boolean[][] visited = new boolean[m][n];
        int i = 0, j = 0;


        do { //Next Item is visited
            log.info("Traversal:{}", direction.toString());
            switch (direction) {
                case RIGHT:
                    while (j < n && !visited[i][j]) {
                        result.add(matrix[i][j]);
                        visited[i][j] = true;
                        j++;
                    }
                    j--;
                    break;
                case DOWN:
                    while (i < m && !visited[i][j]) {
                        result.add(matrix[i][j]);
                        visited[i][j] = true;
                        i++;
                    }
                    i--;
                    break;
                case LEFT:
                    while (j >= 0 && !visited[i][j]) {
                        result.add(matrix[i][j]);
                        visited[i][j] = true;
                        j--;
                    }
                    j++;
                    break;
                case UP:
                    while (i >= 0 && !visited[i][j]) {
                        result.add(matrix[i][j]);
                        visited[i][j] = true;
                        i--;
                    }
                    i++;
                    break;
            }
            switch (direction) {
                case UP:
                    j = j + 1;
                    direction = Direction.RIGHT;
                    break;
                case RIGHT:
                    i = i + 1;
                    direction = Direction.DOWN;
                    break;
                case DOWN:
                    j = j - 1;
                    direction = Direction.LEFT;
                    break;
                case LEFT:
                    i = i - 1;
                    direction = Direction.UP;
                    break;
            }
        } while ((i >= 0 && i < m) && (j >= 0 && j < n) && !visited[i][j]);
        return result;
    }

    private boolean isSurroundAllVisited(boolean[][] visited, int i, int j) {
        int m = visited.length;
        int n = visited[0].length;
        boolean up, down, left, right;
        if (i - 1 >= 0 && j < n) {
            left = visited[i - 1][j];
            if (!left) {
                return false;
            }
        }
        if (j - 1 >= 0 && i < m) {
            up = visited[i][j - 1];
            if (!up) {
                return false;
            }
        }
        if (i + 1 < m) {
            right = visited[i + 1][j];
            if (!right) {
                return false;
            }
        }
        if (j + 1 < n) {
            down = visited[i][j + 1];
            return down;
        }
        return true;
    }


    public enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> spiralOrder = spiralOrder(matrix);
        log.info(JSON.toJSONString(spiralOrder));
    }

    @Test
    public void test1() {
        int[][] matrix = new int[][]{{1}};
        List<Integer> spiralOrder = spiralOrder(matrix);
        log.info(JSON.toJSONString(spiralOrder));
    }

    @Test
    public void test2() {
        int[][] matrix = new int[][]{{2, 3}};
        List<Integer> spiralOrder = spiralOrder(matrix);
        log.info(JSON.toJSONString(spiralOrder));
    }

    @Test
    public void test3() {
        int[][] matrix = new int[][]{{2}, {3}};
        List<Integer> spiralOrder = spiralOrder(matrix);
        log.info(JSON.toJSONString(spiralOrder));
    }

    @Test
    public void test4() {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        List<Integer> spiralOrder = spiralOrder(matrix);
        log.info(JSON.toJSONString(spiralOrder));
    }
}
